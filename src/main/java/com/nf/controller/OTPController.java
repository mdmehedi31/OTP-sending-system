package com.nf.controller;


import com.nf.dto.MailDto;
import com.nf.dto.MailOtpDto;
import com.nf.dto.SendOtpDto;
import com.nf.dto.SmsOtpDto;
import com.nf.enums.OtpType;
import com.nf.service.CreateOtp;
import com.nf.service.SendOtpServiceImple;
import com.nf.service.SendOtpSmsServiceImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class OTPController {


    @Autowired
    private SendOtpServiceImple sendOtpServiceImple;

    @Autowired
    private SendOtpSmsServiceImple sendOtpSmsServiceImple;


    @RequestMapping("/sendOtp")
    public String createOtp(Model model){

        List<OtpType> enums= Arrays.asList(OtpType.values());
        model.addAttribute("enums", enums);
        model.addAttribute("sendOtpDto", new SendOtpDto());
        return "/sendOtp";
    }

    @PostMapping("views/sendOtp")
    public String sendOtp(@ModelAttribute("sendOtpDto")SendOtpDto sendOtpDto){

        CreateOtp createOtp= new CreateOtp();
        String type= sendOtpDto.getTypeOtp();
        String to=sendOtpDto.getSendTo();

        if (type.equals("EMAIL")){
            Map<String, Object> model= new HashMap<>();

            MailOtpDto mailOtpDto= new MailOtpDto();
            int otp= createOtp.getOtp();

            model.put("code",otp);
            sendOtpServiceImple.sendEmail(mailOtpDto,to,model);
        }
        else if (type.equals("SMS")){
            SmsOtpDto smsOtpDto= new SmsOtpDto();

            sendOtpSmsServiceImple.sendOtpSms(smsOtpDto,to);

        }
        else {
            return "Value is not correct format";
        }




        return "send successful";

    }
}
