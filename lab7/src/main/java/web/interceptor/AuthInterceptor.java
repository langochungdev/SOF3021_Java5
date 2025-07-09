package web.interceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import web.model.Account;
import web.util.SessionS;

@Service
public class AuthInterceptor implements HandlerInterceptor {

    @Autowired
    SessionS session;

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        String uri = request.getRequestURI();
        Account user = session.get("user");  

        String error = "";
        if (user == null) {
            error = "Please login!";
        } else if (!user.isAdmin() && uri.startsWith("/admin/")) {
            error = "Access denied!";
        }

        if (!error.isEmpty()) {
            session.set("security-uri", uri); 
            response.sendRedirect("/account/login?error=" + error);
            return false;
        }

        return true;
    }
}
