package com.madebykamil;


import com.madebykamil.jms.MessageSender;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/application-context.xml");

        MessageSender messageSender = (MessageSender) applicationContext.getBean("messageSender");

        messageSender.send("test");



    }

}
