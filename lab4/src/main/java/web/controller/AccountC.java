package web.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import web.service.CookieS;
import web.service.ParamS;
import web.service.SessionS;

@Controller
public class AccountC {
    @Autowired
    CookieS cookieService;

    @Autowired
    ParamS paramService;

    @Autowired
    SessionS sessionService;

    @GetMapping("/account/login")
    public String loginget(Model model) {
    	String savedUsername = cookieService.getValue("user");
        String savedPassword = cookieService.getValue("pass");
    	model.addAttribute("savedUsername", savedUsername);
        model.addAttribute("savedPassword", savedPassword);
        return "/account/login";
    }

    @PostMapping("/account/login")
    public String loginpost() {
        String un = paramService.getString("username", "");
        String pw = paramService.getString("password", "");
        boolean rm = paramService.getBoolean("remember", false);

        if ((un.equals("123")) && pw.equals("123")) {
            sessionService.set("username", un);
            System.err.println("đăng nhập thành công");
            if (rm) {
                cookieService.add("user", un, 10);
                cookieService.add("pass", pw, 10);
            } else {
                cookieService.remove("user");
                cookieService.remove("pass");
            }
        } else {
            System.err.println("đăng nhập thất bại");
        }
        return "/account/login";
    }
}
