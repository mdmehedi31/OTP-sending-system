package com.nf.controller;


import com.nf.dto.MailDto;
import com.nf.enums.OtpType;
import com.nf.service.CreateOtp;
import com.nf.service.SendOtpServiceImple;
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





    private CreateOtp createOtp;
    @RequestMapping("/sendOtp")
    public String createOtp(Model model){

        List<OtpType> enums= Arrays.asList(OtpType.values());
        model.addAttribute("enums", enums);
        return "/sendOtp";
    }

    @PostMapping("views/sendOtp")
    public String sendOtp(@ModelAttribute("mailDto")MailDto mailDto){

        Map<String, Object> model= new HashMap<>();

        int otp= createOtp.getOtp();

        model.put("code",otp);
        sendOtpServiceImple.sendEmail(mailDto,model);

        return "send successful";

    }
}
