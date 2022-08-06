package dictionary.api.infrastructure.controllers;


import an.awesome.pipelinr.Command;
import an.awesome.pipelinr.Pipeline;
import dictionary.api.infrastructure.commands.BaseIdentityCommand;
import dictionary.api.infrastructure.responses.ResponseMessageOf;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class BaseController {
    private final Pipeline pipeline;

    private static final Logger logger = LoggerFactory.getLogger(BaseController.class);

    protected <T> ResponseEntity<T> handle(Command<T> command) {

        if(command instanceof BaseIdentityCommand<?>){
            ((BaseIdentityCommand<ResponseEntity<T>>) command).setUserId("system-admin");
        }

        var result = command.execute(pipeline);

        return ResponseEntity.ok(result);
    }

    protected <T> ResponseEntity<?> handleWithResponseMessage(Command<ResponseMessageOf<T>> command) {
        try {

            var message= command.execute(pipeline);

            if(message.getSucceeded())
            {
                return ResponseEntity.status(message.getStatus()).body(message.getData());

            }

            return ResponseEntity
                    .status(message.getStatus())
                    .body(new ResponseMessageOf<T>(message.getMessage() , message.getFieldErrors()));

        } catch (Exception ex) {
            logger.error(ex.getMessage());
            return ResponseEntity.internalServerError().build();
        }

    }

}