package poly.edu.vn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import poly.edu.vn.entity.Account;

@Service
public class AuthInterceptor implements HandlerInterceptor {
	@Autowired
	SessionService session;

	@Override
	public boolean preHandle(HttpServletRequest request,
	                         HttpServletResponse response,
	                         Object handler) throws Exception {
	    String uri = request.getRequestURI();
	    Account user = (Account) session.getAttribute(request, "user"); // Lấy từ session
	    String error = "";

	    if (user == null) { // Chưa đăng nhập
	        error = "Please login!";
	        session.setAttribute(request, "security-uri", uri); // Lưu trữ URI vào session
	        response.sendRedirect("/account/login?error=" + error);
	        return false;
	    } else if (!user.getAdmin() && uri.startsWith("/admin/")) { // Không đủ quyền
	        error = "Access denied!";
	        session.setAttribute(request, "security-uri", uri); // Lưu trữ URI vào session
	        response.sendRedirect("/account/login?error=" + error);
	        return false;
	    } else if (uri.equals("/home/index")) { // Đã đăng nhập, chuyển hướng đến trang index
	        response.sendRedirect("/home/index");
	        return false;
	    }

	    return true;
	}


}
