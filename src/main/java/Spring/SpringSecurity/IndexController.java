package Spring.SpringSecurity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // @RestController = @Controller + @ResponseBody
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "index";
    }
}
