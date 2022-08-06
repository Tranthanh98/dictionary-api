package dictionary.api.features.translate.models;

import dictionary.api.infrastructure.models.PronunciationModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class TranslateResultWithPronun {
    public List<PronunciationModel> pronunciations;
    public List<TranslateResult> translateResult;
}
