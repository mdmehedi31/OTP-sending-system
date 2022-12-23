package com.nf.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MailDto {

    private String userEmail;
    private String subject;
    private String message;

}
