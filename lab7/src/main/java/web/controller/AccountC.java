package web.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.dao.AccountDAO;
import web.model.Account;
import web.util.SessionS;

@Controller
@RequestMapping("/account")
public class AccountC {

    @Autowired
    AccountDAO dao;

    @Autowired
    SessionS session;

    @GetMapping("/login")
    public String loginForm() {
        return "account/login";
    }

    @PostMapping("/login")
    public String login(Model model,
                        @RequestParam String username,
                        @RequestParam String password) {
        try {
        	Account user = dao.findById(username).orElse(null);
            if (!user.getPassword().equals(password)) {
                model.addAttribute("message", "Invalid password");
            } else {
                session.set("user", user); 

                String uri = session.get("security-uri");
                if (uri != null) {
                    return "redirect:" + uri;
                } else {
                    model.addAttribute("message", "Login succeed");
                }
            }
        } catch (Exception e) {
            model.addAttribute("message", "Invalid username");
        }

        return "account/login";
    }
}
