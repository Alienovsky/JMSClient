package com.madebykamil.jms;


import com.madebykamil.jms.requests.AddBookRequest;
import com.madebykamil.jms.requests.GetAllBooksRequest;
import com.madebykamil.jms.requests.GetBookByIdRequest;
import com.madebykamil.jms.requests.RemoveBookRequest;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import java.util.Map;

public class MessageSender {

    private final JmsTemplate jmsTemplate;

    public MessageSender(final JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }


    public void send(final GetAllBooksRequest getAllBooksRequestrequest) {
        MessageCreator messageCreator = new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                return session.createObjectMessage(getAllBooksRequestrequest);
            }
        };
        jmsTemplate.send(messageCreator);
    }

    public void send(final GetBookByIdRequest getBookByIdRequest) {
        MessageCreator messageCreator = new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                return session.createObjectMessage(getBookByIdRequest);
            }
        };
        jmsTemplate.send(messageCreator);
    }

    public void send(final AddBookRequest addBookRequest) {
        MessageCreator messageCreator = new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                return session.createObjectMessage(addBookRequest);
            }
        };
        jmsTemplate.send(messageCreator);
    }

    public void send(final RemoveBookRequest removeBookRequest) {
        MessageCreator messageCreator = new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                return session.createObjectMessage(removeBookRequest);
            }
        };
        jmsTemplate.send(messageCreator);
    }
}