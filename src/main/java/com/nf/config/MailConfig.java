package com.nf.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.Properties;

@Configuration
@EnableWebMvc
public class MailConfig {

    @Bean
    public JavaMailSender getJavaMailSender(){

        JavaMailSenderImpl javaMailSenderImpl= new JavaMailSenderImpl();
        javaMailSenderImpl.setHost("smtp.gmail.com");
        javaMailSenderImpl.setUsername("mailbotbd@gmail.com");
        javaMailSenderImpl.setPassword("phubbtmklzxnmsnk");
        javaMailSenderImpl.setPort(587);

        Properties mailProperties = new Properties();
        mailProperties.put("mail.smtp.starttls.enable",true);
        mailProperties.put("mail.smtp.ssl.trust", "smtp.gmail.com");

        javaMailSenderImpl.setJavaMailProperties(mailProperties);

        return javaMailSenderImpl;
    }
}
