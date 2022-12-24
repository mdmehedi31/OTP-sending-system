package com.nf.service;

import com.nf.dto.MailDto;

public interface MailServiceDefinition {

    void sendEmail(/*String userEmail, String subject, String message*/ MailDto mailDto);
}
