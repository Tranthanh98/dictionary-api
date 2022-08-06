package dictionary.api.infrastructure.responses;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.Map;

@Data
@NoArgsConstructor
public class ResponseMessageOf <T> extends ResponseMessage{
    @Setter
    @Getter
    HttpStatus status = HttpStatus.valueOf(200);

    @Getter
    @Setter
    T data;

    public boolean getSucceeded()
    {
        var statusValue = status.value();
        return  statusValue >=200 && statusValue< 300;
    }

    public ResponseMessageOf(HttpStatus statusResult) {
        super();
        this.status = statusResult;
    }


    public ResponseMessageOf(HttpStatus statusResult, T result ) {
        super();
        this.status = statusResult;
        this.data=result;
    }

    public  static <T> ResponseMessageOf<T> of(HttpStatus statusResult)
    {
        return new ResponseMessageOf<T>(statusResult);
    }

    public  static <T> ResponseMessageOf<T> of(HttpStatus statusResult, T data)
    {
        return new ResponseMessageOf<T>(statusResult,data);
    }

    public ResponseMessageOf(String message, Map<String, String> fieldErrors) {
        super(message, fieldErrors);
        this.status = HttpStatus.BAD_REQUEST;
    }
}
