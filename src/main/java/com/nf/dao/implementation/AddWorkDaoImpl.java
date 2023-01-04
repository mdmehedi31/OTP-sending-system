package com.nf.dao.implementation;


import com.nf.dao.definition.AddWorkDaoDefinition;
import com.nf.entity.AddWork;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AddWorkDaoImpl implements AddWorkDaoDefinition {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public boolean addMail(AddWork addWork) {

        Session session= sessionFactory.getCurrentSession();
        try{

            session.save(addWork);
            return true;

        }catch (Exception e){
            return false;
        }

    }

    @Override
    public boolean updateMail(AddWork addWork) {

        Session session= sessionFactory.getCurrentSession();

        try{
            session.update(addWork);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean deleteMailSc(AddWork addWork) {

        Session session = sessionFactory.getCurrentSession();
        try {
            session.delete(addWork);
            return true;

        } catch (Exception e) {

            return false;
        }
    }

    /*
    *   List<User> users = sessionFactory.getCurrentSession()
                .createQuery("FROM User WHERE username = :username", User.class)
                .setParameter("username", username.toLowerCase())
                .getResultList();
        return users.size() > 0 ? users.get(0) : null;
    * */

    @Override
    public List<AddWork> todayMail(String mailDate) {

        List<AddWork> addWorkList=sessionFactory.getCurrentSession()
                .createQuery("from AddWork where mailDate =: mailDate", AddWork.class)
                .setParameter("mailDate", mailDate)
                .getResultList();

        return addWorkList;
    }
}
