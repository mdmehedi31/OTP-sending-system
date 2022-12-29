package com.nf.service;

import com.nf.config.Properties;
import com.nf.dto.SmsDto;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;
import org.springframework.stereotype.Service;

@Service
public class SendOtpSmsServiceImple implements SendOtpSmsServiceDefinition{


    CreateOtp createOtp= new CreateOtp();

    @Override
    public void sendOtpSms(SmsDto smsDto) {

        Twilio.init(Properties.ACCOUNT_SID,Properties.AUTH_TOKEN);

        PhoneNumber to = new PhoneNumber(smsDto.getPhoneNumber());
        PhoneNumber from= new PhoneNumber(Properties.TWILIO_NUMBER);

        String message=getMessage();

        MessageCreator messageCreator = Message.creator(to, from,message);

        messageCreator.create();
    }


    public String getMessage(){

        int number= createOtp.getOtp();
        String message="M- "+number+"is Your verification OTP";

        return message;
    }
}
