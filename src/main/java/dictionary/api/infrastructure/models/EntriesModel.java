package dictionary.api.infrastructure.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class EntriesModel {
    public List<SenseModel> senses;
    public List<PronunciationModel> pronunciations;
}
