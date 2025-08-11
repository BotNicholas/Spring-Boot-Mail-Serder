package org.example.maildemo;

import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;

@RestController
public class Controller {
    @Autowired
    DemoMailSender sender;

    @PostMapping("/send")
    public String send(@RequestBody String text) {
        sender.sendSimpleMail("botannicolai22@gmail.com", "TEST", text);
        return "Sent";
    }

    @PostMapping("/send/mime")
    public String sendMime(@RequestBody String text) throws MessagingException, FileNotFoundException {
        sender.sendHtmlMail("botannicolai22@gmail.com", "TEST MIME", text);
        return "Mime Sent";
    }

}
