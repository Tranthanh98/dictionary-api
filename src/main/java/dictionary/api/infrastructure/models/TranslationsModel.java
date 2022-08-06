package dictionary.api.infrastructure.models;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TranslationsModel{
    public String language;
    public String text;
}
