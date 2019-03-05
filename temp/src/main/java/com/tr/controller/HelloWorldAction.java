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

    @Override
    public String execute() throws Exception {
        count++;
        if (count % mgNumber == 0) {
            messageStoreSuccess = new MessageStore("Welcome you are the: " + count);
            return SUCCESS;
        } else {
            messageStoreError = new MessageStore("error count value is: " + count);
            return ERROR;
        }
    }

    public MessageStore getMessageStoreSuccess() {
        return messageStoreSuccess;
    }

    public MessageStore getMessageStoreError() {
        return messageStoreError;
    }


}
