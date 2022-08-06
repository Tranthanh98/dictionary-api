package dictionary.api.features.share.services;

import dictionary.api.features.translate.models.TranslateResult;
import dictionary.api.features.translate.models.TranslateResultWithPronun;
import dictionary.api.infrastructure.responses.ResponseMessageOf;

import java.util.List;

public interface TranslateCacheService {
    String add(String key, TranslateResultWithPronun result);

    ResponseMessageOf<TranslateResultWithPronun> get(String word, String source, String target);

    void clearCacheByKey(String key);
}
