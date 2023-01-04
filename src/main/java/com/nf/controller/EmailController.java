package com.nf.controller;

import com.nf.dao.definition.AddCustomerDaoDefinition;
import com.nf.dao.definition.AddWorkDaoDefinition;
import com.nf.dto.MailDto;
import com.nf.entity.AddWork;
import com.nf.service.MailServiceImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.List;

@Controller
public class EmailController {


    @Autowired
    private MailServiceImple mailServiceImple;

    @Autowired
    private AddCustomerDaoDefinition addCustomerDaoDefinition;

    @Autowired
    private AddWorkDaoDefinition addWorkDaoDefinition;



    @RequestMapping("/writeEmail")
   /*  @RequestMapping("/writeEmail/{customerId}")*/
    public String createEmail(Model model/*, @PathVariable("customerId")Long customerId*/){

        //String mailId= addCustomerDaoDefinition.getEmail(customerId);

        List<AddWork> mailList= getToDayMailList();
        model.addAttribute("mailList", mailList);
       //  model.addAttribute("mailId",mailId);
        model.addAttribute("mailDto", new MailDto());
        return "/writeEmail";
    }


    @PostMapping("views/writeEmail")
    public String sendMail(@ModelAttribute("mailDto")MailDto mailDto){

//        mailServiceImple.sendEmail(mailDto.getUserEmail(),mailDto.getSubject(),mailDto.getMessage());
        mailServiceImple.sendEmail(mailDto);
        return "Sent Successful";
    }

    private List<AddWork> getToDayMailList(){

         String date= String.valueOf(LocalDate.now());
         List<AddWork> customerList=addWorkDaoDefinition.todayMail(date);
         return customerList;
    }

}
