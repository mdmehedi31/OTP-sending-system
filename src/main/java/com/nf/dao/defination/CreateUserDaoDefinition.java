package com.nf.dao.defination;

import com.nf.entity.User;

import java.util.List;

public interface CreateUserDaoDefinition {

    public boolean addUser(User user);
    public boolean updateUser(User user);
    public User getUser(Long userId);

    public List<User> listUser();
    public boolean deleteUser(User user);

}
