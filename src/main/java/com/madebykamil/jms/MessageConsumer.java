package com.madebykamil.jms;

import com.madebykamil.model.Person;

import javax.jms.*;

public class MessageConsumer implements MessageListener {

    private MessageSender messageSender;

    public void setMessageSender(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    public void onMessage(final Message message) {
        if(message instanceof ObjectMessage){
            ObjectMessage objectMessage = (ObjectMessage) message;
            try {
                Person p = (Person) objectMessage.getObject();
                System.out.println(p.getName()+" "+p.getSurname());
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }
}
