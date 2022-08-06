package dictionary.api.features.translate.queries;

import an.awesome.pipelinr.Command;
import dictionary.api.features.translate.models.TranslateResultWithPronun;
import dictionary.api.infrastructure.enums.Language;
import dictionary.api.infrastructure.responses.ResponseMessageOf;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class Translate implements Command<ResponseMessageOf<TranslateResultWithPronun>> {
    public Language source;
    public Language target;

    public String word;
}
