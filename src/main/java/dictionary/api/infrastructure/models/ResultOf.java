package dictionary.api.infrastructure.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResultOf <T> extends Result{
    public T data;

    public ResultOf(Boolean success, T data) {
        super(success);
        this.data = data;
    }

    public ResultOf(Map errors){
        super(false);
        this.errors = errors;
    }


    public static <T> ResultOf<T> of(T data){
        return new ResultOf<>(true, data);
    }

    public static ResultOf failedWithErrorsMessage(Map errors){
        return new ResultOf(errors);
    }
}
