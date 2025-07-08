package poly.edu.vn.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import poly.edu.vn.model.MailInfo;
import poly.edu.vn.service.MailerService;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
@Controller
public class MailController {
//
//    @Autowired
//    private MailerService mailerService;
//
//    @ResponseBody
//    @RequestMapping("/mail/demo")
//    private String sendMail(Model model) {
//        try {
//            mailerService.send("xuanchient033@gmail.com", "subject", "Body");
//            return "ok";
//        } catch (Exception e) {
//            return e.getMessage();
//        }
//    }

	@Autowired
	private MailerService mailerService;

	@GetMapping("/sendEmail")
	public String showSendEmailForm() {
		return "mail/send";
	}

	@PostMapping("/sendEmail")
	public String sendMail(Model model, @RequestParam("from") String from, @RequestParam("to") String to,
			@RequestParam(value = "cc", required = false) String cc,
			@RequestParam(value = "bcc", required = false) String bcc, @RequestParam("subject") String subject,
			@RequestParam("body") String body,
			@RequestParam(value = "attachments", required = false) MultipartFile[] attachments) {
		try {
			String[] attachmentPaths = null;
			if (attachments != null && attachments.length > 0) {
				attachmentPaths = new String[attachments.length];
				for (int i = 0; i < attachments.length; i++) {
					attachmentPaths[i] = saveAttachment(attachments[i]);
				}
			}
			if (cc != null && cc.isEmpty()) {
	            cc = null;
	        }
	        if (bcc != null && bcc.isEmpty()) {
	            bcc = null;
	        }
			MailInfo mailInfo = new MailInfo(from, to, cc, bcc, subject, body, attachmentPaths);
			mailerService.send(mailInfo);
			model.addAttribute("message", "ok");
		} catch (Exception e) {
			model.addAttribute("message", "lỗi");
			System.out.println(e.getMessage());
		}
		return "mail/send";
	}

	private String saveAttachment(MultipartFile attachment) {
		try {
			// Tạo một đường dẫn tạm thời để lưu trữ tệp đính kèm
			File tempFile = File.createTempFile("attachment-", ".tmp");

			// Lưu dữ liệu từ MultipartFile vào tệp tạm thời
			try (FileOutputStream fos = new FileOutputStream(tempFile)) {
				fos.write(attachment.getBytes());
			}

			// Trả về đường dẫn tạm thời của tệp đính kèm
			return tempFile.getAbsolutePath();
		} catch (IOException e) {
			e.printStackTrace();
			return null; // Trả về null nếu có lỗi xảy ra
		}
	}
}
