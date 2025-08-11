package org.example.maildemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MailDemoApplication {

    @Autowired
    DemoMailSender sender;

    public static void main(String[] args) {
        SpringApplication.run(MailDemoApplication.class, args);
    }
}
