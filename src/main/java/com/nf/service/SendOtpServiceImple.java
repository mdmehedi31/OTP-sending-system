package com.nf.service;

import com.nf.dto.MailDto;
import com.nf.dto.MailOtpDto;
import com.nf.dto.SendOtpDto;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

@Service
public class SendOtpServiceImple implements SendOtpServiceDefinition {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private Configuration configuration;

    @Override
    public void sendEmail(MailOtpDto mailOtpDto,String to ,Map<String, Object> model) {


        MimeMessage message = javaMailSender.createMimeMessage();

        try {

            MimeMessageHelper helper = new MimeMessageHelper(message,
                    MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());
            Template t = configuration.getTemplate("template.ftl");
            String html = FreeMarkerTemplateUtils.processTemplateIntoString(t, model);

            String subject="Verification OTP";
            helper.setFrom("mailbotbd@gmail.com");
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(html, true);

            javaMailSender.send(message);

        } catch (MessagingException | IOException | TemplateException e) {

        }
    }
}