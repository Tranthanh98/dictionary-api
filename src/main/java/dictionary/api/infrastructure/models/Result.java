package dictionary.api.infrastructure.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {

    public Boolean success;

    public Map<String, String> errors;


    public Result(Boolean success) {
        this.success = success;
    }

}
