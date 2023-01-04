package com.nf.dto;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class AddWorkDto {

    private String mailId;
    private String mailSubtitle;
    private String mailTopic;
    private String mailDate;
}
