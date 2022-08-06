package dictionary.api.infrastructure.services.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Strings;
import dictionary.api.infrastructure.models.ResultOf;
import dictionary.api.infrastructure.responses.OxfordTranslateResponse;
import dictionary.api.infrastructure.services.TranslateService;
import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@Service
public class OxfordTranslateService implements TranslateService {

    @Value("${oxford.app-id}")
    String oxfordAppId;

    @Value("${oxford.app-key}")
    String oxfordAppKey;

    @Value("${oxford.server.path}")
    String serverPath;

    private final String TRANSLATE_ENDPOINT = "translations";

    private static final Logger logger = LoggerFactory.getLogger(OxfordTranslateService.class);

    @Override
    public ResultOf<OxfordTranslateResponse> translate(String word, String sourceLanguage, String targetLanguage) {
        var url = TRANSLATE_ENDPOINT + "/"
                + sourceLanguage.toLowerCase() + "/"
                + targetLanguage.toLowerCase() + "/"
                + word.toLowerCase()
                + "?strictMatch=true&fields=translations%2Cpronunciations";

       return getRequest(url);
    }

    private ResultOf<OxfordTranslateResponse> getRequest(String pathApi) {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();

        var requestBuilder = new Request.Builder()
                .url(this.serverPath + pathApi)
                .method(HttpMethod.GET.toString(), null)
                .addHeader("app_id", oxfordAppId)
                .addHeader("app_key", oxfordAppKey)
                .addHeader("Accept", "application/json");

        var request = requestBuilder.build();

        try(Response response = client.newCall(request).execute()) {
            var stringResponse = response.body() != null ?
                    Objects.requireNonNullElse(response.body().string(),null) : null;

            if (response.code() >= 200 && response.code() <= 299) {
                if(!Strings.isNullOrEmpty(stringResponse)) {
                    var result =
                            mapperResponseOkHttp(stringResponse, OxfordTranslateResponse.class);

                    return ResultOf.of(result);
                }
            } else
            {
                logger.error(Optional.ofNullable(stringResponse)
                        .orElse("OxfordTranslateService.mapperResponseOkHttp was failed with http status = " + response.code()));


                return ResultOf.failedWithErrorsMessage(
                        Map.of("errorBody", "OxfordTranslateService return an error with status " + response.code())
                );
            }
        }catch (Exception ex)
        {
            logger.error(ex.getMessage(),ex);
            return ResultOf.failedWithErrorsMessage(Map.of("error", ex.getMessage()));
        }

        return ResultOf.failedWithErrorsMessage(Map.of("error", "something went wrong"));
    }

    private <T> T mapperResponseOkHttp(String response, Class<T> classInstance) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        return objectMapper.readValue(response, classInstance);
    }
}
