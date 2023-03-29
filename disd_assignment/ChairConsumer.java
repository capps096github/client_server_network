import javax.jms.*;
import javax.naming.*;
 
public class ChairConsumer {
 
    public static void main(String[] args) throws Exception{
 
        Properties props = new Properties();
        props.setProperty(Context.INITIAL_CONTEXT_FACTORY, 
                          "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
        props.setProperty(Context.PROVIDER_URL, "tcp://localhost:61616");
        props.put("topic.book-manufacture-topic", "book-manufacture-topic");
 
        InitialContext ctx = new InitialContext(props);
        TopicConnectionFactory connFactory = 
            (TopicConnectionFactory) ctx.lookup("ConnectionFactory");
        TopicConnection topicConn = connFactory.createTopicConnection();
        topicConn.start();
 
        TopicSession session = topicConn.createTopicSession(false, 
                                                 Session.AUTO_ACKNOWLEDGE);
        Topic topic = (Topic) ctx.lookup("book-manufacture-topic");
 
        TopicSubscriber subscriber = session.createSubscriber(topic);
 
        int count = 0;
        while (true) {
            Message message = subscriber.receive();
            if (message instanceof TextMessage) {
                count++;
                String text = ((TextMessage) message).getText();
                System.out.println("Consumer 1 received message: " +text);
System.out.println("Messages consumed by Consumer 1: " + count);
}
}
}
}