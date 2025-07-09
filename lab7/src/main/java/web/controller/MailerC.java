package web.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import web.model.MailInfo;
import web.service.MailerS;

@Controller
@RequestMapping("/mailer")
public class MailerC {

    @Autowired
    MailerS mailer;

    @GetMapping("/form")
    public String form() {
        return "mailer/form";
    }

    @PostMapping("/send")
    public String send(
            @RequestParam String from,
            @RequestParam String to,
            @RequestParam(required = false) String cc,
            @RequestParam(required = false) String bcc,
            @RequestParam String subject,
            @RequestParam String body,
            @RequestParam(required = false) MultipartFile[] attachments,
            Model model) {

        try {
            MailInfo mail = new MailInfo();
            mail.setFrom(from);
            mail.setTo(to);
            mail.setSubject(subject);
            mail.setBody(body);

            // Parse cc & bcc
            if (cc != null && !cc.trim().isEmpty()) {
                String[] ccArray = cc.split("\\s*,\\s*");
                System.out.println("CC parsed: " + String.join(", ", ccArray));
                mail.setCc(ccArray);
            }

            if (bcc != null && !bcc.trim().isEmpty()) {
                String[] bccArray = bcc.split("\\s*,\\s*");
                System.out.println("BCC parsed: " + String.join(", ", bccArray));
                mail.setBcc(bccArray);
            }

            if (attachments != null && attachments.length > 0) {
                String[] files = new String[attachments.length];
                for (int i = 0; i < attachments.length; i++) {
                    MultipartFile file = attachments[i];
                    if (!file.isEmpty()) {
                        String name = UUID.randomUUID() + "_" + file.getOriginalFilename();
                        String path = System.getProperty("java.io.tmpdir") + "/" + name;
                        file.transferTo(new File(path));
                        files[i] = path;
                        System.out.println("Tệp đính kèm [" + i + "]: " + path);
                    }
                }
                mail.setAttachments(files);
            }

            mailer.queue(mail);
            System.out.println("Mail đã được đưa vào hàng đợi.");
            model.addAttribute("message", "Mail đã được xếp vào hàng đợi!");

        } catch (IOException e) {
            e.printStackTrace();
            model.addAttribute("message", "Lỗi gửi mail: " + e.getMessage());
        }

        return "mailer/form";
    }
}
