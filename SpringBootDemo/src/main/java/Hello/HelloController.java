package Hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import org.springframework.web;
@RestController
public class HelloController {
    @RequestMapping("/")
    public String index() {
        return "hello spring boot";
    }
}
