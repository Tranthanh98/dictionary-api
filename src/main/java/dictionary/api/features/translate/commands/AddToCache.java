package dictionary.api.features.translate.commands;

import an.awesome.pipelinr.Command;
import dictionary.api.features.translate.models.TranslateResult;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddToCache implements Command<ResponseEntity<String>> {
    public String key;
    public List<TranslateResult> value;
}
