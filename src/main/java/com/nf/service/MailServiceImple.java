package com.nf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImple implements MailServiceDefinition{

   /* @Autowired*/
    private JavaMailSender javaMailSender;
    @Override
    public void sendEmail(String userMail, String subject, String message) {

        SimpleMailMessage simpleMail= new SimpleMailMessage();
        simpleMail.setFrom("mailbotbd@gmail.com");
        simpleMail.setTo(userMail);
        simpleMail.setSubject(subject);
        simpleMail.setText(message);

        javaMailSender.send(simpleMail);

    }

}
