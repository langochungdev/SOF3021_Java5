package poly.edu.vn.service;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import poly.edu.vn.model.MailInfo;

@Service
public class MailerServiceImpl implements MailerService {

	 @Autowired
	    JavaMailSender sender;

	    @Override
	    public void send(MailInfo mail) throws MessagingException {
	        MimeMessage message = sender.createMimeMessage();
	        MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
	        helper.setFrom(mail.getFrom());
	        helper.setTo(mail.getTo());
	        helper.setSubject(mail.getSubject());
	        helper.setText(mail.getBody(), true);
	        helper.setReplyTo(mail.getFrom());
	        if (mail.getCc() != null) {
	            helper.setCc(mail.getCc());
	        }
	        if (mail.getBcc() != null) {
	            helper.setBcc(mail.getBcc());
	        }
	        if (mail.getAttachments() != null) {
	            for (String path : mail.getAttachments()) {
	                File file = new File(path);
	                helper.addAttachment(file.getName(), file);
	            }
	        }
	        sender.send(message);
	    }

}

//@Autowired
//JavaMailSender sender;
//
//@Override
//public void send(MailInfo mail) throws MessagingException {
//	MimeMessage message = sender.createMimeMessage();
//	
//	MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
//	helper.setFrom(mail.getForm());
//	helper.setTo(mail.getTo());
//	helper.setSubject(mail.getSubject());
//	helper.setText(mail.getBody(), true);
//	helper.setReplyTo(mail.getForm());
//	String[] cc = mail.getCc();
//	if (cc != null && cc.length > 0) {
//		helper.setCc(cc);
//	}
//	String[] bcc = mail.getBcc();
//	if (bcc != null && bcc.length > 0) {
//		helper.setBcc(bcc);
//	}
//	String[] attachments = mail.getAttachments();
//	if (attachments != null && attachments.length > 0) {
//		for (String path : attachments) {
//			File file = new File(path);
//			helper.addAttachment(file.getName(), file);
//		}
//	}
//	sender.send(message);
//}
//
//@Override
//public void send(String to, String subject, String body) throws MessagingException {
//	this.send(new MailInfo(to, subject, body));
//}

