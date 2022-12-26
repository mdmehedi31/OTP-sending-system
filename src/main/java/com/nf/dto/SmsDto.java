package com.nf.dto;


import lombok.Data;

@Data
public class SmsDto {
    private String phoneNumber;
    private String message;
}
