package com.nf.controller;


import com.nf.dao.definition.CreateUserDaoDefinition;
import com.nf.dto.UserDto;
import com.nf.entity.User;
import com.nf.enums.OrganizationType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

@Controller
public class AddUserController {


    @Autowired
    private CreateUserDaoDefinition createUserDaoDefinition;

    @RequestMapping("createUser")
    private String user(Model model){

        List<OrganizationType> orType = Arrays.asList(OrganizationType.values());
        model.addAttribute("orType", orType);
        model.addAttribute("userDto", new UserDto());

        return "createUser";
    }

    @PostMapping("views/createUser")
    public String createUser(Model model, @ModelAttribute("userDto")UserDto userDto) throws IOException {

        User user= new User();

        user.setUserName(userDto.getUserName());
        user.setEmail(userDto.getEmail());
        user.setOrganization(userDto.getOrganizationType());
        user.setJoinDate(new Timestamp(System.currentTimeMillis()));
        user.setPassword(userDto.getPassword());

        createUserDaoDefinition.addUser(user);
        model.addAttribute("user", user);

        return "Save Successful";
    }
}
