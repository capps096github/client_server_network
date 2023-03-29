import javax.jms.*;
import javax.naming.*;
 
public class ChairConsumer2 {
 
   

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
        topicConn.start();
 
        // Create a session for receiving messages
        TopicSession session = topicConn.createTopicSession(false, 
                                                 Session.AUTO_ACKNOWLEDGE);
 
        // Look up the topic
        Topic topic = (Topic) ctx.lookup("book-manufacture-topic");
 
        // Create a subscriber for the topic
        TopicSubscriber subscriber = session.createSubscriber(topic);
 
        // Consume messages and display the number of messages consumed and the content of each message
        int count = 0;
        while (true) {
            Message message = subscriber.receive();
            if (message instanceof TextMessage) {
                count++;
                String text = ((TextMessage) message).getText();
                System.out.println("Consumer 2 received message: " + text);
                System.out.println("Messages consumed by Consumer 2: " + count);
            }
        }
    }
}