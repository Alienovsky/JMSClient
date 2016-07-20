package com.madebykamil;


import com.madebykamil.jms.MessageSender;
import com.madebykamil.jms.requests.AddBookRequest;
import com.madebykamil.jms.requests.GetAllBooksRequest;
import com.madebykamil.jms.requests.GetBookByIdRequest;
import com.madebykamil.jms.requests.RemoveBookRequest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static java.lang.Thread.sleep;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/application-context.xml");
        MessageSender messageSender = (MessageSender) applicationContext.getBean("messageSender");

        GetAllBooksRequest getAllBooksRequest = new GetAllBooksRequest();
        messageSender.send(getAllBooksRequest);
        sleep(100);

        GetBookByIdRequest getBookByIdRequest = new GetBookByIdRequest("bk101");
        messageSender.send(getBookByIdRequest);
        sleep(100);

        AddBookRequest addBookRequest = new AddBookRequest("Kamil","Trepczynski","Spock jest Spoko", "IT", 10.0f, "Ksiazka o tym jaki Spock jest spoko");
        messageSender.send(addBookRequest);
        sleep(100);

        RemoveBookRequest removeBookRequest = new RemoveBookRequest("bb");
        messageSender.send(removeBookRequest);
    }

}
