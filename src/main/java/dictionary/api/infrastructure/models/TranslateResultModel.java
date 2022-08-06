package dictionary.api.infrastructure.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class TranslateResultModel {
    public String id;
    public String language;
    public List<LexicalEntriesModel> lexicalEntries;
    public String type;
    public String word;

}


