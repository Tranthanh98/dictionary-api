package dictionary.api.features.translate.queries.handlers;

import an.awesome.pipelinr.Command;
import dictionary.api.features.share.helper.CachingHelper;
import dictionary.api.features.share.services.TranslateCacheService;
import dictionary.api.features.translate.models.TranslateResult;
import dictionary.api.features.translate.models.TranslateResultWithPronun;
import dictionary.api.features.translate.queries.Translate;
import dictionary.api.infrastructure.responses.ResponseMessageOf;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("TranslateHandler")
@AllArgsConstructor
public class TranslateHandler implements Command.Handler<Translate, ResponseMessageOf<TranslateResultWithPronun>> {

    private final TranslateCacheService translateService;

    @Override
    public ResponseMessageOf<TranslateResultWithPronun> handle(Translate query) {

         var result = translateService.get(query.getWord(),
                query.getSource().getValue(),
                query.getTarget().getValue());

         if(!result.getSucceeded()){
             var cacheKey = CachingHelper.buildCacheKey(query.getWord(),
                     query.getSource().getValue(),
                     query.getTarget().getValue());

             translateService.clearCacheByKey(cacheKey);
         }

         return result;

    }
}
