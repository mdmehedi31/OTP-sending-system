package com.nf.controller;


import com.nf.dao.definition.AddWorkDaoDefinition;
import com.nf.dto.AddWorkDto;
import com.nf.entity.AddWork;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@Controller
public class AddWorkController {

    @Autowired
    private AddWorkDaoDefinition addWorkDaoDefinition;


    @RequestMapping("addWork")
    public String addWork(Model model){

        model.addAttribute("addWorkDto", new AddWorkDto());

        return "addWork";
    }

    @PostMapping("views/addWork")
    public String createWork(Model model, @ModelAttribute("addWorkDto") AddWorkDto addWorkDto){

        AddWork addWork= new AddWork();

        addWork.setMailId(addWorkDto.getMailId());
        addWork.setSubTitle(addWorkDto.getMailSubtitle());
        addWork.setMailTopic(addWorkDto.getMailTopic());
        addWork.setMailDate(addWorkDto.getMailDate());


    /*    LocalDate date = Instant.ofEpochMilli(timestamp * 1000).atZone(ZoneId.systemDefault()).toLocalDate();
        return date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        */

       /* Timestamp timestamp= new Timestamp(System.currentTimeMillis());

        LocalDate date= Instant.ofEpochMilli(timestamp*1000)*/

        System.out.println(LocalDate.now());

        addWorkDaoDefinition.addMail(addWork);
        model.addAttribute("addWork", addWork);

        return "Save Successful";
    }
}
