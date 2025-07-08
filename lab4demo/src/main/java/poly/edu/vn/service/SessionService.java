package poly.edu.vn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;

@Service
public class SessionService {

	@Autowired
	HttpSession session;
	
	public <T> T get(String name) {
		return (T) session.getAttribute(name);
	}
	public void set(String name, Object value) {
		session.setAttribute(name, value);
	}
	public void remove(String name) {
		session.removeAttribute(name);
	}
}
