package poly.edu.vn.service;

import jakarta.mail.MessagingException;
import poly.edu.vn.model.MailInfo;

public interface MailerService {
	void send(MailInfo mail) throws MessagingException;
//	void send(String to, String subject, String body) throws MessagingException;
}
