package com.madebykamil.jms;

import com.madebykamil.jms.responses.AddBookResponse;
import com.madebykamil.jms.responses.GetAllBooksResponse;
import com.madebykamil.jms.responses.GetBookByIdResponse;
import com.madebykamil.jms.responses.RemoveBookResponse;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import java.io.Serializable;

public class MessageConsumer implements MessageListener {

    Serializable objectFromMessage;

    public Serializable getObjectFromMessage() {
        return objectFromMessage;
    }

    public void onMessage(final Message message) {
        if (message instanceof ObjectMessage) {
            ObjectMessage objectMessage = (ObjectMessage) message;
            try {
                Serializable objectFromMessage = objectMessage.getObject();
               /* if (objectFromMessage instanceof
                        GetAllBooksResponse) {
                    GetAllBooksResponse response = (GetAllBooksResponse) objectFromMessage;
                    System.out.println(response.getAllBooks().size());
                }
                if(objectFromMessage instanceof GetBookByIdResponse){
                    GetBookByIdResponse response = (GetBookByIdResponse) objectFromMessage;
                    System.out.println(response.getBook().getDescription());
                }
                if(objectFromMessage instanceof AddBookResponse){
                    AddBookResponse response = (AddBookResponse) objectFromMessage;
                    System.out.println(response.getBookId());
                }
                if(objectFromMessage instanceof RemoveBookResponse){
                    RemoveBookResponse response = (RemoveBookResponse) objectFromMessage;
                    System.out.println(response.getBookId());
                }*/
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }
}
