package com.nf.dao.definition;

import com.nf.entity.AddWork;

import java.util.List;

public interface AddWorkDaoDefinition {

    public boolean addMail(AddWork addWork);
    public boolean updateMail(AddWork addWork);
    public boolean deleteMailSc(AddWork addWork);

    public List<AddWork> todayMail(String date);
}
