package com.nf.service;

import com.nf.dto.MailDto;
import com.nf.dto.MailOtpDto;

import java.util.Map;

public interface SendOtpServiceDefinition {


    public void sendEmail(MailOtpDto mailOtpDto,String to, Map<String, Object> model);
}
