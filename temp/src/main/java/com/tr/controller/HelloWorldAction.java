package com.tr.controller;

import com.opensymphony.xwork2.ActionSupport;
import com.tr.dao.MessageStore;

public class HelloWorldAction extends ActionSupport {

    private MessageStore messageStore = null;

    @Override
    public String execute() throws Exception {
        messageStore = new MessageStore("Welcome");
        return SUCCESS;
    }

    public MessageStore getMessageStore() {
        return messageStore;
    }
}
