package com.nf.service;

import com.nf.dto.SmsDto;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;
import org.springframework.stereotype.Service;

@Service
public class SendSmsServiceImple implements SendSmsService{

    public static final String ACCOUNT_SID="ACf6833a03e14e7e6b12a4f182a4aab133";
    public static final String AUTH_TOKEN="ff9ad3284f7d81521c73c760956732f0";
    public static final String TWILIO_NUMBER ="+18145605224";



    @Override
    public void sendSms(SmsDto smsDto) {

        Twilio.init(ACCOUNT_SID,AUTH_TOKEN);

        PhoneNumber to= new PhoneNumber(smsDto.getPhoneNumber());
        PhoneNumber from= new PhoneNumber(TWILIO_NUMBER);
        String message= smsDto.getMessage();

        MessageCreator messageCreator= Message.creator(to,from,message);
        messageCreator.create();

    }
}
