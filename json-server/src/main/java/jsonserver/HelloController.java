package jsonserver;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
public class HelloController {
    @RequestMapping("/")
    @ResponseBody
    public MessageDTO  index() {
        return new MessageDTO(1,"Hello World!");
    }
}

