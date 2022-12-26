package com.nf.controller;

import com.nf.dto.SmsDto;
import com.nf.service.SendSmsServiceImple;
import com.twilio.Twilio;
import com.twilio.http.TwilioRestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SendSmsController {

    @Autowired
    private SendSmsServiceImple sendSmsServiceImple;

    @RequestMapping("/sendSms")
    public String getSmsPage(Model model){

        model.addAttribute("smsDto", new SmsDto());

        return "sendSms";
    }

    @PostMapping("views/sendSms")
    public String sendSms(@ModelAttribute("smsDto")SmsDto smsDto){

        sendSmsServiceImple.sendSms(smsDto);
        return "Sent SMS Successful";
    }
}
