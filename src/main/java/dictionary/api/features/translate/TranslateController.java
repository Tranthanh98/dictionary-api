package dictionary.api.features.translate;

import an.awesome.pipelinr.Pipeline;
import dictionary.api.features.translate.queries.Translate;
import dictionary.api.infrastructure.controllers.BaseController;
import dictionary.api.infrastructure.enums.Language;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("translate")
public class TranslateController extends BaseController {
    public TranslateController(Pipeline pipeline) {
        super(pipeline);
    }

    @GetMapping("{source}/{target}/{word}")
    public ResponseEntity<?> translate(@PathVariable("source") String source,
                                       @PathVariable("target") String target,
                                       @PathVariable("word") String word){

        var query = Translate.of(Language.valueOf(source.toUpperCase()),
                                            Language.valueOf(target.toUpperCase()),
                                            word);

        return handleWithResponseMessage(query);
    }
}
