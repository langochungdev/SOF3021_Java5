package web.service;
import jakarta.mail.MessagingException;
import web.model.MailInfo;

public interface MailerS {
    void send(MailInfo mail) throws MessagingException;
    void send(String to, String subject, String body) throws MessagingException;

    void queue(MailInfo mail);
    void queue(String to, String subject, String body);
}
