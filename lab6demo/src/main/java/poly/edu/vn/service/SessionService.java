package poly.edu.vn.service;

import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpSession;

@Service
public class SessionService {
    private HttpSession session;

    public void KeywordSessionManager(HttpSession session) {
        this.session = session;
    }

    public String getKeywords() {
        return (String) session.getAttribute("keywords");
    }

    public void setKeywords(String keywords) {
        session.setAttribute("keywords", keywords);
    }

    public void removeKeywords() {
        session.removeAttribute("keywords");
    }
}

