package com.nf.service;

import com.nf.config.Properties;
import com.nf.dto.SmsDto;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;
import org.springframework.stereotype.Service;

import static com.nf.config.Properties.*;

@Service
public class SendSmsServiceImple implements SendSmsService{


    @Override
    public void sendSms(SmsDto smsDto) {


       Twilio.init(ACCOUNT_SID, AUTH_TOKEN);


        PhoneNumber to= new PhoneNumber(smsDto.getPhoneNumber());
        PhoneNumber from= new PhoneNumber(TWILIO_NUMBER);
        String message= smsDto.getMessage();
        MessageCreator messageCreator= Message.creator(to,from,message);
        messageCreator.create();

    }
}
