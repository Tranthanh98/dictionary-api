package dictionary.api.features.translate.commands.handlers;

import an.awesome.pipelinr.Command;
import dictionary.api.features.translate.commands.AddToCache;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.ResponseEntity;

@Data
@AllArgsConstructor
public class AddToCacheHandler implements Command.Handler<AddToCache, ResponseEntity<String>> {
    @Override
    public ResponseEntity<String> handle(AddToCache addToCache) {
        return null;
    }
}
