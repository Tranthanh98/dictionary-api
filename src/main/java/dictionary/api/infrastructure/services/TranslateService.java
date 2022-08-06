package dictionary.api.infrastructure.services;

import dictionary.api.infrastructure.models.ResultOf;
import dictionary.api.infrastructure.responses.OxfordTranslateResponse;

public interface TranslateService {
    ResultOf<OxfordTranslateResponse> translate(String word, String sourceLanguage, String targetLanguage);
}
