import com.madebykamil.jms.MessageConsumer
import com.madebykamil.jms.MessageSender
import com.madebykamil.jms.requests.GetAllBooksRequest
import com.madebykamil.jms.responses.GetAllBooksResponse
import org.junit.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

import static java.lang.Thread.sleep

@ContextConfiguration(locations = "classpath:application-context.xml")
class test extends Specification {
    @Autowired
    MessageSender messageSender;

    @Autowired
    MessageConsumer messageConsumer;

    @Test
    def "testuj testu"(){
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

}