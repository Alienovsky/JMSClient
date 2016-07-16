package com.madebykamil.jms;

import com.madebykamil.model.Book;
import com.madebykamil.model.Person;

import javax.jms.*;
import java.util.ArrayList;
import java.util.List;

public class MessageConsumer implements MessageListener {

    private MessageSender messageSender;

    public void setMessageSender(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    public void onMessage(final Message message) {
        /*if(message instanceof ObjectMessage){
            ObjectMessage objectMessage = (ObjectMessage) message;
            try {
                Person p = (Person) objectMessage.getObject();
                System.out.println(p.getName()+" "+p.getSurname());
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }*/
        if(message instanceof ObjectMessage){
            ObjectMessage objectMessage = (ObjectMessage) message;
            try {
                List<Book> books = (ArrayList<Book>) objectMessage.getObject();
                System.out.println(books.size());
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }
}
