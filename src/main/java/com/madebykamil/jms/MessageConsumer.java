package com.madebykamil.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class MessageConsumer implements MessageListener {

    private MessageSender messageSender;

    public void setMessageSender(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    public void onMessage(final Message message) {
        if(message instanceof TextMessage){
            final TextMessage textMessage = (TextMessage) message;
            try {
                System.out.println("got message: " + textMessage.getText());
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }
}
