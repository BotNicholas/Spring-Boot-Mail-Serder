package org.example.maildemo;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.FileNotFoundException;

@Component
public class DemoMailSender {
    @Autowired
    JavaMailSender mailSender;

    public void sendSimpleMail(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);

        mailSender.send(message);
    }

    public void sendHtmlMail(String to, String subject, String text) throws MessagingException, FileNotFoundException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);
        messageHelper.setTo(to);
        messageHelper.setSubject(subject);
        messageHelper.setText(String.format("<h1>%s</h1>", text), true);
        FileSystemResource file = new FileSystemResource(ResourceUtils.getFile("classpath:cat.jpg"));
        messageHelper.addAttachment("Cat.jpg", file);
        mailSender.send(mimeMessage);
    }
}
