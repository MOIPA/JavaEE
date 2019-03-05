package com.tr.controller;

import com.opensymphony.xwork2.ActionSupport;
import com.tr.dao.Person;

/***
 * @author tr
 */
public class Register extends ActionSupport {
    private Person personBean;

    @Override
    public String execute() throws Exception {
        //save the personBean to DataBase
        return SUCCESS;
    }

    public Person getPersonBean() {
        return personBean;
    }

    public void setPersonBean(Person personBean) {
        this.personBean = personBean;
    }
}
