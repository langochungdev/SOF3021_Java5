package poly.edu.vn.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import poly.edu.vn.service.CookieService;
import poly.edu.vn.service.ParamService;
import poly.edu.vn.service.SessionService;

@Controller
public class AccountController {
    @Autowired
    CookieService cookieService;

    @Autowired
    ParamService paramService;

    @Autowired
    SessionService sessionService;

    @GetMapping("/account/login")
    public String login1(Model model) {
    	String savedUsername = cookieService.getValue("user");
        String savedPassword = cookieService.getValue("pass");
    	model.addAttribute("savedUsername", savedUsername);
        model.addAttribute("savedPassword", savedPassword);
        return "/account/login";
    }

    @PostMapping("/account/login")
    public String login2() {
        String un = paramService.getString("username", "");
        String pw = paramService.getString("password", "");
        boolean rm = paramService.getBoolean("remember", false);

        if ((un.equals("123")) && pw.equals("123")) {
            sessionService.set("username", un);
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
