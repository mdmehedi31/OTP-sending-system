package com.nf.service;

import com.nf.dto.SmsDto;
import com.nf.dto.SmsOtpDto;

public interface SendOtpSmsServiceDefinition {

    public void sendOtpSms(SmsOtpDto smsOtpDto,String to);
}
