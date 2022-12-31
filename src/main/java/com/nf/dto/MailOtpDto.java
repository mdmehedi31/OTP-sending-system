package com.nf.dto;

import lombok.Data;

@Data
public class MailOtpDto extends SendOtpDto {


    private String userEmail;
    private String subject;
    private String message;


}
