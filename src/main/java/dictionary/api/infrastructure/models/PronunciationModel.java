package dictionary.api.infrastructure.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PronunciationModel {
    public String audioFile;
    public List<String> dialects;

}
