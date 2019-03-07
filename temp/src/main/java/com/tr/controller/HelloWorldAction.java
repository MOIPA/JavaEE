package com.tr.controller;

import com.opensymphony.xwork2.ActionSupport;
import com.tr.dao.MessageStore;

import java.util.Random;

/***
 * @author tr
 */
public class HelloWorldAction extends ActionSupport {

    private MessageStore messageStoreSuccess = null;
    private MessageStore messageStoreError = null;
    private static int count = 0;
    private int mgNumber = 2;
    private String userName = "";

    @Override
    public String execute() throws Exception {
        count++;
        if (count % mgNumber == 0) {
            messageStoreSuccess = new MessageStore("Welcome"+userName+" you are the: " + count);
            //success turn to HelloWorld.jsp
            return SUCCESS;
        } else {
            messageStoreError = new MessageStore("error count value is: " + count);
            //turn to error.jsp
            return ERROR;
        }
    }

    public MessageStore getMessageStoreSuccess() {
        return messageStoreSuccess;
    }

    public MessageStore getMessageStoreError() {
        return messageStoreError;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
