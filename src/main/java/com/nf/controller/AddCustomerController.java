package com.nf.controller;


import com.nf.dao.defination.AddCustomerDaoDefinition;
import com.nf.dto.AddCustomerDto;
import com.nf.entity.AddCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
public class AddCustomerController {



    @Autowired
    private AddCustomerDaoDefinition addCustomerDaoDefinition;

    @RequestMapping("addCustomer")
    public String customer(Model model){

        model.addAttribute("addCustomerDto", new AddCustomerDto());

        List<AddCustomer> listCustomer= getListCustomer();
        model.addAttribute("listCustomer", listCustomer);

        return "addCustomer";
    }

    @PostMapping("views/addCustomer")
    public String addCustomer(Model model, @ModelAttribute("addCustomerDto")
    AddCustomerDto addCustomerDto) throws IOException {

        AddCustomer addCustomer= new AddCustomer();
        addCustomer.setName(addCustomerDto.getName());
        addCustomer.setEmail(addCustomerDto.getEmail());
        addCustomer.setCustomerDetails(addCustomerDto.getCustomerDetails());


        addCustomerDaoDefinition.addCustomer(addCustomer);
        model.addAttribute("addCustomer", addCustomer);

       List<AddCustomer>listCustomer=getListCustomer();
        model.addAttribute("listCustomer", listCustomer);

        return "redirect:/addCustomer";
    }

    private List<AddCustomer>  getListCustomer(){

        List<AddCustomer> listCustomer= addCustomerDaoDefinition.listCustomer();

        return listCustomer;
    }


    @RequestMapping(value = "viewCustomer/{customerId}")
    public String getCustomer(Model model, @PathVariable("customerId") Long customerId){


        AddCustomer addCustomer= addCustomerDaoDefinition.getCustomer(customerId);

        model.addAttribute("addCustomer", addCustomer);

        return "viewCustomer";

    }

    @RequestMapping(value = "editCustomer/{customerId}")
    public String editCustomer(Model model, @PathVariable("customerId") Long customerId){

        AddCustomer customer= addCustomerDaoDefinition.getCustomer(customerId);
        model.addAttribute("customer", customer);

        return "updateCustomer";
    }


    @RequestMapping(value = "/updateCustomer", method = RequestMethod.POST)
    public String updateCustomer(@RequestParam("customerId")Long customerId,
                                 @ModelAttribute("customerDto") AddCustomerDto addCustomerDto){


        AddCustomer customer= addCustomerDaoDefinition.getCustomer(customerId);
        customer.setName(addCustomerDto.getName());
        customer.setEmail(addCustomerDto.getEmail());
        customer.setCustomerDetails(addCustomerDto.getCustomerDetails());

        addCustomerDaoDefinition.updateCustomer(customer);

        return "redirect:/addCustomer";

    }

    @RequestMapping(value = "deleteCustomer/{customerId}")
    public String deleteCustomer(@PathVariable("customerId")Long customerId){

        AddCustomer addCustomer= addCustomerDaoDefinition.getCustomer(customerId);

        addCustomerDaoDefinition.deleteCustomer(addCustomer);

        return "redirect:/addCustomer";
    }

}
