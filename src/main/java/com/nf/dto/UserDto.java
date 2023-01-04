package com.nf.dto;

import com.nf.enums.OrganizationType;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {

    private String userName;
    private String email;
    private OrganizationType organizationType;
    private String password;
}
