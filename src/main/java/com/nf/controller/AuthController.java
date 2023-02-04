package com.nf.controller;

import com.nf.dao.definition.CreateUserDaoDefinition;
import com.nf.entity.User;
import com.nf.enums.Role;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AuthController {


   private final CreateUserDaoDefinition userDao;
    private final PasswordEncoder passwordEncoder;

    public AuthController(CreateUserDaoDefinition userDao, PasswordEncoder passwordEncoder) {
        this.userDao = userDao;

        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/login")
    public ModelAndView login(Model model, @RequestParam(name = "error",
            required = false)  String error){

        var mv= new ModelAndView();
        createDemoUser();
        mv.addObject("error", error);
        mv.setViewName("/login");
        return mv;
    }

    protected void createDemoUser(){

        if (userDao.findByEmailId("user1@gmail.com")==null) {

            User user1= new User();

            user1.setUserName("user1");
            user1.setPassword(passwordEncoder.encode("user1"));
            user1.setEmail("user1@gmail.com");
            user1.setRole(Role.ROLE_USER);
            user1.setEnabled(true);
            userDao.addUser(user1);


        }

        if (userDao.findByEmailId("admin@gmail.com")==null){

            User admin= new User();
            admin.setUserName("admin");
            admin.setPassword(passwordEncoder.encode("admin"));
            admin.setEmail("admin@gmail.com");
            admin.setRole(Role.ROLE_ADMIN);
            admin.setEnabled(true);

            userDao.addUser(admin);
        }

    }
}
