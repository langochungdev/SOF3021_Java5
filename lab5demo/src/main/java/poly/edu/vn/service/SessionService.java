package poly.edu.vn.service;

import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Service
public class SessionService {

    public void setAttribute(HttpServletRequest request, String attributeName, Object attributeValue) {
        HttpSession session = request.getSession(true);
        session.setAttribute(attributeName, attributeValue);
    }

    public Object getAttribute(HttpServletRequest request, String attributeName) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            return session.getAttribute(attributeName);
        }
        return null;
    }

    public void removeAttribute(HttpServletRequest request, String attributeName) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.removeAttribute(attributeName);
        }
    }

    public void invalidateSession(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
    }
}