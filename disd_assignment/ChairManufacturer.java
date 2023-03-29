import javax.jms.*;
import javax.naming.*;
import java.util.*;
 
public class ChairManufacturer {
 
        public static void main(String[] args) throws Exception{
 
        // Set up the properties for the initial context
        Properties props = new Properties();
        props.setProperty(Context.INITIAL_CONTEXT_FACTORY, 
                          "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
        props.setProperty(Context.PROVIDER_URL, "tcp://localhost:61616");
        props.put("topic.book-manufacture-topic", "book-manufacture-topic");
 
        // Create the initial context
        InitialContext ctx = new InitialContext(props);
 
        // Create a connection factory and a connection to the JMS provider
        TopicConnectionFactory connFactory = 
            (TopicConnectionFactory) ctx.lookup("ConnectionFactory");
        TopicConnection topicConn = connFactory.createTopicConnection();
 
        // Start the connection
        topicConn.start();
 
        // Create a session for sending messages
        TopicSession session = topicConn.createTopicSession(false, 
                                                 Session.AUTO_ACKNOWLEDGE);
 
        // Look up the topic
        Topic topic = (Topic) ctx.lookup("book-manufacture-topic");
 
        // Create a producer for the topic
        TopicPublisher publisher = session.createPublisher(topic);
 
        // Send a message every 10 seconds
        int count = 0;
        while (true) {
            String message = new Date().toString();
            TextMessage textMessage = session.createTextMessage(message);
            publisher.publish(textMessage);
            System.out.println("Message sent: " + message);
            count++;
            System.out.println("Messages sent: " + count);
            Thread.sleep(10000);
        }
    }
}