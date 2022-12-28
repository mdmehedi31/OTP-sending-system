package com.nf.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.ui.freemarker.FreeMarkerConfigurationFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Properties;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = {"com.nf"})
public class ServletConfig implements WebMvcConfigurer {

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry){
        registry.jsp("/WEB-INF/views/",".jsp");
    }

    @Bean
    public JavaMailSender getJavaMailSender(){

        JavaMailSenderImpl javaMailSenderImpl= new JavaMailSenderImpl();
        javaMailSenderImpl.setHost("smtp.gmail.com");
        javaMailSenderImpl.setUsername("mailbotbd@gmail.com");
        javaMailSenderImpl.setPassword("dyewdpxaiqfgswhd");
        javaMailSenderImpl.setPort(587);

        Properties mailProperties = new Properties();
        mailProperties.put("mail.smtp.starttls.enable",true);
        mailProperties.put("mail.smtp.ssl.trust", "smtp.gmail.com");

        javaMailSenderImpl.setJavaMailProperties(mailProperties);

        return javaMailSenderImpl;
    }

    @Bean
    public FreeMarkerConfigurationFactoryBean factoryBean() {
        FreeMarkerConfigurationFactoryBean bean=new FreeMarkerConfigurationFactoryBean();
        bean.setTemplateLoaderPath("classpath:/templates");
        return bean;
    }
}
