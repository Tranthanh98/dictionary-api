package dictionary.api.features.health;

import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@NoArgsConstructor
public class HealthController {

    @GetMapping("/health")
    public ResponseEntity<?> health(){

        var status = HttpStatus.BAD_REQUEST;
        return ResponseEntity.ok("i'm good :)))");
    }

    @GetMapping("/mock-ip")
    public String mockIp(HttpServletRequest request) {
        var realIp = request.getHeader("X-Forwarded-For");

        if(realIp ==null
                || realIp.isBlank()
                || realIp.isEmpty()
                || realIp.equals("::1")
                || realIp.equals("0:0:0:0:0:0:0:1"))
        {
            realIp = "127.0.0.1";
        }

        return realIp;

    }
}
