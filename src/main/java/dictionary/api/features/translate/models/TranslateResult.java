package dictionary.api.features.translate.models;

import dictionary.api.infrastructure.models.TranslationsModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TranslateResult {
    public List<TranslationsModel> translations;
    public String lang;
    public String id;
    public String lexicalCategory;
}
