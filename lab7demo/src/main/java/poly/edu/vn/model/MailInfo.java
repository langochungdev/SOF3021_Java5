package poly.edu.vn.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor 
@AllArgsConstructor
public class MailInfo {

//	String form;
//	String to;
//	String[] cc;
//	String[] bcc;
//	String subject;
//	String body;
//	String[] attachments;
//	
//	public MailInfo(String to, String subject, String body) {
//		this.form = "FPT Polytechnic <poly@fpt.edu.vn>";
//		this.to = to;
//		this.subject = subject;
//		this.body = body;
//	}
    private String from;
    private String to;
    private String cc;
    private String bcc;
    private String subject;
    private String body;
    private String[] attachments;

    public MailInfo(String from, String to, String cc, String bcc, String subject, String body) {
        this.from = from;
        this.to = to;
        this.cc = cc;
        this.bcc = bcc;
        this.subject = subject;
        this.body = body;
    }
}
