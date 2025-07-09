package web.model;
import lombok.*;

@Data
@NoArgsConstructor 
@AllArgsConstructor
public class Mail {
    private String from;
    private String to;
    private String cc;
    private String bcc;
    private String subject;
    private String body;
    private String[] attachments;

    public Mail(String from, String to, String cc, String bcc, String subject, String body) {
        this.from = from;
        this.to = to;
        this.cc = cc;
        this.bcc = bcc;
        this.subject = subject;
        this.body = body;
    }
}
