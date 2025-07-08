package poly.edu.vn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;
import poly.edu.vn.dao.AccountDao;
import poly.edu.vn.entity.Account;
import poly.edu.vn.service.SessionService;

@Controller
public class AccountController {

    @Autowired
    AccountDao dao;

    @Autowired
    SessionService session;

    @GetMapping("/account/login")
    public String login() {
        return "account/login";
    }

    @PostMapping("/account/login")
    public String login(Model model, HttpServletRequest request,
                        @RequestParam("username") String username,
                        @RequestParam("password") String password) {
        try {
            Account user = dao.findByUsername(username);
            if (user == null) {
                throw new Exception("Invalid username");
            } else if (!user.getPassword().equals(password)) {
                throw new Exception("Invalid password");
            } else {
                if (user.getAdmin()) {
                    return "redirect:/home/index";
                } else {
                    String uri = (String) session.getAttribute(request, "security-uri");
                    if (uri != null) {
                        return "redirect:" + uri;
                    } else {
                        model.addAttribute("message", "Login succeed");
                    }
                }
            }
        } catch (Exception e) {
            model.addAttribute("message", e.getMessage());
        }
        return "account/login";
    }

}
