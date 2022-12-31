package com.nf.dto;

import lombok.Data;

@Data
public class SmsOtpDto extends SendOtpDto {

    private String phoneNumber;
    private String message;
}
