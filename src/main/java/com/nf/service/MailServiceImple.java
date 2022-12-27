package com.nf.service;

import com.nf.dto.MailDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImple implements MailServiceDefinition{


    @Autowired
    private JavaMailSender javaMailSender;
    @Override
    public void sendEmail(MailDto mailDto) {

        SimpleMailMessage simpleMail= new SimpleMailMessage();
        simpleMail.setFrom("mailbotbd@gmail.com");
        simpleMail.setTo(mailDto.getUserEmail());
        simpleMail.setSubject(mailDto.getSubject());
        simpleMail.setText(mailDto.getMessage());

        javaMailSender.send(simpleMail);

    }

}
