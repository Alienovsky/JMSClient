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
class SmokeTests extends Specification {
    @Autowired
    MessageSender messageSender;

    @Autowired
    MessageConsumer messageConsumer;

    @Test
    def "getAllBooksRequest"(){
        given:
        GetAllBooksRequest getAllBooksRequest = new GetAllBooksRequest()
        when:
        messageSender.send(getAllBooksRequest)
        sleep(100)
        then:
        messageConsumer.objectFromMessage instanceof GetAllBooksResponse
        def response = (GetAllBooksResponse) messageConsumer.objectFromMessage
        response.getAllBooks().size() > 0
    }

    @Test
    def "AddBookRequest"(){
        given:
        AddBookRequest addBookRequest = new AddBookRequest()
        addBookRequest.authorName = "Kamil"
        addBookRequest.authorSurname = "Trepczynski"
        addBookRequest.description = "Spock jest Spoko"
        addBookRequest.genre = "Nudy"
        addBookRequest.price = 22.0f
        addBookRequest.title = "O Spocku"
        when:
        messageSender.send(addBookRequest)
        sleep(100)
        then:
        messageConsumer.objectFromMessage instanceof AddBookResponse
        def response = (AddBookResponse) messageConsumer.objectFromMessage
        response.bookId != null
        response.errors == ""
    }

    @Test
    def "GetBookByIdRequest"(){
        given:
        GetBookByIdRequest getBookByIdRequest = new GetBookByIdRequest()
        getBookByIdRequest.bookId = "bk102"
        when:
        messageSender.send(getBookByIdRequest)
        sleep(100)
        then:
        messageConsumer.objectFromMessage instanceof GetBookByIdResponse
        def response = (GetBookByIdResponse) messageConsumer.objectFromMessage
        response.book != null
        response.errors == ""
    }

    @Test
    def "RemoveBookRequest"(){
        given:
        RemoveBookRequest removeBookRequest = new RemoveBookRequest()
        removeBookRequest.bookId = "bk102"
        when:
        messageSender.send(removeBookRequest)
        sleep(100)
        then:
        messageConsumer.objectFromMessage instanceof RemoveBookResponse
        def response = (RemoveBookResponse) messageConsumer.objectFromMessage
        response.isRemoved != null
        response.isRemoved == true
        response.errors == ""
    }

}