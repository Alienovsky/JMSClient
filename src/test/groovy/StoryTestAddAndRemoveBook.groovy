import com.madebykamil.jms.MessageConsumer
import com.madebykamil.jms.MessageSender
import com.madebykamil.jms.requests.AddBookRequest
import com.madebykamil.jms.requests.GetAllBooksRequest
import com.madebykamil.jms.requests.GetBookByIdRequest
import com.madebykamil.jms.requests.RemoveBookRequest
import com.madebykamil.jms.responses.AddBookResponse
import com.madebykamil.jms.responses.GetAllBooksResponse
import com.madebykamil.jms.responses.GetBookByIdResponse
import com.madebykamil.jms.responses.RemoveBookResponse
import org.junit.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

import static java.lang.Thread.sleep

@ContextConfiguration(locations = "classpath:application-context.xml")
class StoryTestAddAndRemoveBook extends Specification {
    @Autowired
    MessageSender messageSender;

    @Autowired
    MessageConsumer messageConsumer;


    @Test
    def "Add and remove book"(){
        given: "prepared request to create book"
        AddBookRequest addBookRequest = new AddBookRequest()
        addBookRequest.authorName = "Kamil"
        addBookRequest.authorSurname = "Trepczynski"
        addBookRequest.description = "Spock jest Spoko"
        addBookRequest.genre = "Nudy"
        addBookRequest.price = 22.0f
        addBookRequest.title = "O Spocku"
        when: "sending the request"
        messageSender.send(addBookRequest)
        sleep(100)
        then: "we should get response from server with book id and no errors"
        messageConsumer.objectFromMessage instanceof AddBookResponse
        def addBookResponse = (AddBookResponse) messageConsumer.objectFromMessage
        addBookResponse.bookId != null
        addBookResponse.errors == null
        when: "we are trying to retrieve created book by prepared request"
        GetBookByIdRequest getBookByIdRequest = new GetBookByIdRequest()
        getBookByIdRequest.bookId = addBookResponse.getBookId()
        messageSender.send(getBookByIdRequest)
        sleep(100)
        then: "we should get it from the server in a response and all data should be correct"
        messageConsumer.objectFromMessage instanceof GetBookByIdResponse
        def getBookByIdResponse = (GetBookByIdResponse) messageConsumer.objectFromMessage
        getBookByIdResponse.book != null
        getBookByIdResponse.errors == null
        getBookByIdResponse.book.author.name == addBookRequest.authorName
        getBookByIdResponse.book.author.surname == addBookRequest.authorSurname
        getBookByIdResponse.book.description == addBookRequest.description
        getBookByIdResponse.book.genre == addBookRequest.genre
        getBookByIdResponse.book.price == addBookRequest.price
        getBookByIdResponse.book.title == addBookRequest.title
        when: "we will try to remove already added book"
        RemoveBookRequest removeBookRequest = new RemoveBookRequest()
        removeBookRequest.bookId = addBookResponse.bookId
        messageSender.send(removeBookRequest)
        sleep(100)
        then: "we should get response without errors and confirmation that book is removed"
        messageConsumer.objectFromMessage instanceof RemoveBookResponse
        def removeBookResponse = (RemoveBookResponse) messageConsumer.objectFromMessage
        removeBookResponse.isRemoved != null
        removeBookResponse.isRemoved == true
        removeBookResponse.errors == null
        when: "we try to get removed book"
        GetBookByIdRequest getBookAgainByIdRequest = new GetBookByIdRequest()
        getBookAgainByIdRequest.bookId = addBookResponse.getBookId()
        messageSender.send(getBookAgainByIdRequest)
        sleep(100)
        then: "we should get error that book is not exist"
        messageConsumer.objectFromMessage instanceof GetBookByIdResponse
        def getBookAgainByIdResponse = (GetBookByIdResponse) messageConsumer.objectFromMessage
        getBookAgainByIdResponse.book == null
        getBookAgainByIdResponse.errors != null
        getBookAgainByIdResponse.errors.contains(getBookAgainByIdRequest.bookId)

    }


}