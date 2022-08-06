package dictionary.api.infrastructure.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class SenseModel {
    public String id;
    public List<TranslationsModel> translations;
}
