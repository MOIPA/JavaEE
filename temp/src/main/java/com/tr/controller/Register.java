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

    @Override
    public String input() throws Exception {
        return super.input();
    }

    public Person getPersonBean() {
        return personBean;
    }

    public void setPersonBean(Person personBean) {
        this.personBean = personBean;
    }

    public void validate(){
        if (personBean.getFirstName().length() == 0) {
            addFieldError("personBean.firstName", "First name is required.");
        }

        if (personBean.getEmail().length() == 0) {
            addFieldError("personBean.email", "Email is required.");
        }

        if (personBean.getAge() < 18) {
            addFieldError("personBean.age", "Age is required and must be 18 or older");
        }
    }


}
