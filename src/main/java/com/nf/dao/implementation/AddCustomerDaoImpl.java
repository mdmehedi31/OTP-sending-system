package com.nf.dao.implementation;

import com.nf.dao.defination.AddCustomerDaoDefinition;
import com.nf.entity.AddCustomer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AddCustomerDaoImpl implements AddCustomerDaoDefinition {

    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public boolean addCustomer(AddCustomer addCustomer) {

        Session session=sessionFactory.getCurrentSession();
        try{
            session.save(addCustomer);
            return true;
        }catch (Exception e){

            return false;
        }

    }

    @Override
    public boolean updateCustomer(AddCustomer addCustomer) {
        Session session= sessionFactory.getCurrentSession();

        try{
            session.update(addCustomer);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public AddCustomer getCustomer(Long customerId) {

        Session session= sessionFactory.getCurrentSession();
        AddCustomer addCustomer= session.get(AddCustomer.class,customerId);
        return addCustomer;
    }

    /*
    *
    *  List<User> users = sessionFactory.getCurrentSession()
                .createQuery("FROM User WHERE username = :username", User.class)
                .setParameter("username", username.toLowerCase())
                .getResultList();
        return users.size() > 0 ? users.get(0) : null;
    * */
    @Override
    public String getEmail(Long customerId) {

        String email = String.valueOf(sessionFactory.getCurrentSession()
                .createQuery("select AddCustomer.email from AddCustomer where AddCustomer.customerId=:customerId", AddCustomer.class)
                .setParameter("customerId", customerId)
                .getSingleResult());


        return email;

     /*   *//*session.close();*//*
        return email;*/

    }

    @Override
    public List<AddCustomer> listCustomer() {

        Session session = sessionFactory.openSession();

        Query query= session.createQuery("from AddCustomer");
        List<AddCustomer> listCustomer= query.list();
        session.close();
        return listCustomer;

    }

    @Override
    public boolean deleteCustomer(AddCustomer customer) {

        Session session= sessionFactory.getCurrentSession();
        try{
            session.delete(customer);
            return true;

        }catch (Exception e){

            return false;
        }

    }
}
