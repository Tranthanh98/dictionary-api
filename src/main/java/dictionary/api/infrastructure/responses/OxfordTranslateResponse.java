package dictionary.api.infrastructure.responses;

import dictionary.api.infrastructure.models.TranslateResultModel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class OxfordTranslateResponse {
    public String id;
    public List<TranslateResultModel> results;
    public String word;
}
