package web.service;

import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpSession;

@Service
public class SessionS {
    private final HttpSession session;

    public SessionS(HttpSession session) {
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
