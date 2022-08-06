package dictionary.api.features.share.services.impl;

import dictionary.api.features.share.helper.CachingHelper;
import dictionary.api.features.share.services.TranslateCacheService;
import dictionary.api.features.translate.models.TranslateResult;
import dictionary.api.features.translate.models.TranslateResultWithPronun;
import dictionary.api.infrastructure.responses.ResponseMessageOf;
import dictionary.api.infrastructure.services.TranslateService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DefaultTranslateCache implements TranslateCacheService {

    private static final Logger logger = LoggerFactory.getLogger(DefaultTranslateCache.class);

    private final TranslateService translateService;

    @Override
    @CacheEvict(cacheNames="translateCaching", allEntries = true, key="#key")
    public String add(String key, TranslateResultWithPronun result) {
        return null;
    }

    @Override
    @Cacheable(cacheNames="translateCaching", key = "#word + '_' + #source + '_' + #target")
    public ResponseMessageOf<TranslateResultWithPronun> get(String word, String source, String target) {

        var cacheKey = CachingHelper.buildCacheKey(word, source, target);

        logger.info("Trying to get account information for id {} ", cacheKey);

        var result = translateService.translate(word, source, target);

        if(!result.getSuccess()){
            return new ResponseMessageOf("error when translating", result.getErrors());
        }

        var responseData = result.getData();


        var temp = responseData.getResults().get(0).getLexicalEntries();

        var pronunciations = temp.get(0).getEntries().get(0).getPronunciations();

        var resultData = new ArrayList<TranslateResult>();

        temp.forEach(l -> {

            var entry = l.getEntries().get(0);

            var meanings = entry.getSenses().stream()
                    .map(i-> i.getTranslations()).flatMap( j-> j.stream()).collect(Collectors.toList());


            var item = TranslateResult.builder()
                    .lexicalCategory(l.getLexicalCategory().getText())
                    .lang(l.getLanguage())
                    .id(cacheKey)
                    .translations(meanings)
                    .build();

            resultData.add(item);

        });



        return ResponseMessageOf.of(HttpStatus.OK, TranslateResultWithPronun.of(pronunciations, resultData));
    }

    @Override
    @CacheEvict("translateCaching")
    public void clearCacheByKey(String key) {

    }
}
