package com.nf.service;

import com.nf.dto.MailDto;

import java.util.Map;

public interface SendOtpServiceDefinition {


    public void sendEmail(MailDto mailDto, Map<String, Object> model);
}
