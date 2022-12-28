package com.nf.controller;


import com.nf.enums.OtpType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OTPController {

    @RequestMapping("/sendOtp")
    public String createOtp(Model model){

        return "/sendOtp";
    }

}
