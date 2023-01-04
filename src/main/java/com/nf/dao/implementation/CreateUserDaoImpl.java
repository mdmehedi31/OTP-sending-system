package com.nf.dao.implementation;

import com.nf.dao.definition.CreateUserDaoDefinition;
import com.nf.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
/*@Component*/
@Service
@Transactional
public class CreateUserDaoImpl implements CreateUserDaoDefinition {


    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public boolean addUser(User user) {

        Session session= sessionFactory.getCurrentSession();
        try{
            session.save(user);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean updateUser(User user) {

        Session session = sessionFactory.getCurrentSession();

        try {
            session.update(user);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

    @Override
    public User getUser(Long userId) {

        Session session= sessionFactory.getCurrentSession();
        User user= session.get(User.class,userId);
        return user;
    }

    @Override
    public List<User> listUser() {

        Session session= sessionFactory.openSession();

        Query query= session.createQuery("from User");
        List<User> userList= query.list();
        session.close();
        return userList;
    }

    @Override
    public boolean deleteUser(User user) {

        Session session= sessionFactory.getCurrentSession();
        try{
            session.delete(user);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
