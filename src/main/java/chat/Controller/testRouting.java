package chat.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testRouting {

    @GetMapping("/test")
    public String test(){
        return "oui";
    }
}
