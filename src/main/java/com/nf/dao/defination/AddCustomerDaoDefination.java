package com.nf.dao.defination;

import com.nf.entity.AddCustomer;

import java.util.List;

public interface AddCustomerDaoDefination {

    public boolean addCustomer(AddCustomer addCustomer);
    public boolean updateCustomer(AddCustomer addCustomer);
    public AddCustomer getCustomer(Long customerId);
    public String getEmail(Long customerId);

    public List<AddCustomer> listCustomer();
    public boolean deleteCustomer(AddCustomer customer);
}
