package web.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeC {

    @RequestMapping("/home/index")
    public String index() {
        return "home/index";
    }

    @RequestMapping("/home/about")
    public String about() {
        return "home/about";
    }
}
