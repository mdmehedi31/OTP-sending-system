package com.nf.service;

import java.util.Random;

public class CreateOtp {

    public int getOtp(){

        int length=4;
        String numbers = "1234567890";
        Random random = new Random();
        char[] otp = new char[length];

        for(int i = 0; i< length ; i++) {
            otp[i] = numbers.charAt(random.nextInt(numbers.length()));
        }


        int getOtp= Integer.parseInt(new String(otp));

        System.out.println("The OTP is: "+ getOtp);
        return getOtp;
    }
}
