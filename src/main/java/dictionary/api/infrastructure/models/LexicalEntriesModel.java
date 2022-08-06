package dictionary.api.infrastructure.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class LexicalEntriesModel {
    public List<EntriesModel> entries;
    public String language;
    public String text;
    public LexicalCategoryModel lexicalCategory;
}
