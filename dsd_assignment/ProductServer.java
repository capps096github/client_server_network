package dsd_assignment;

import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ProductServer {

    // create ArrayList
    public static ArrayList<ProductTopic> productTopics = new ArrayList<>();

    // default chat topics initialization
    public static void init() {
        //
        productTopics.add(new ProductTopic("Engineers", 6666, 1000, Date()));
        productTopics.add(new ProductTopic("Writers", 7777, 1000,Date()));
        productTopics.add(new ProductTopic("Artists", 8888, 1000,Date()));
        productTopics.add(new ProductTopic("Musicians", 9999, 1000,Date()));
    }

    // static method create topic that adds an item to the list of topics
    public static void createTopic() {
        // print create topic
        System.out.println("\n> You can now Create a topic! \n");
        System.out.println("> Current list of chat topics from the server\n");

        printTopics();

        // create a new topic text
        System.out.println("\n\n> Enter the details of the  NEW topic here\n");

        // capture user input for topic name, port number and duration then create a
        // chat topic object that will be added to the list
        Scanner scanner = new Scanner(System.in);
        System.out.println("Name of the topic e.g. Artisans: ");
        String name = scanner.nextLine();
        System.out.println("Port Number e.g. 5555: ");
        int port = scanner.nextInt();
        System.out.println("Message Duration e.g 100: ");
        int duration = scanner.nextInt();
        //
        ProductTopic productTopic = new ProductTopic(name, port, duration);

        // add the chat topic to the list
        productTopics.add(productTopic);

        // print that the topic was created and all its details
        System.out.println("\n> New topic created successfully!");

        // print the topic details
        productTopic.printTopic();

        // close the scanner
        scanner.close();
    }

    public static void printTopics() {
        // check if the topic list is empty and if it is, call init method
        if (productTopics.isEmpty()) {
            init();
        }

        // use a for loop to print the list of chat topics
        for (int i = 0; i < productTopics.size(); i++) {
            // current chat topic
            ProductTopic productTopic = productTopics.get(i);
            //
            System.out.println(i + 1 + ") " + productTopic.name + " topic at Port: " + productTopic.port);
        }
    }

    // choose a chat topic to join method that shows the list of chat topics from
    // the server in a menu
    // then it asks the user to choose a chat topic to join
    // it then connects to the chat topic via the port number and starts listening
    // to it for messages
    // it then prints the message to the console
    public static void chooseTopic() {
        System.out.println("Current list of chat topics from the server\n");

        //
        printTopics();

        System.out.println("\n Choose a chat topic to join from ( 1 - " + productTopics.size() + " ): ");
        // get the user input
        Scanner scanner = new Scanner(System.in);

        // variable to store the user input
        int topicNumber = scanner.nextInt();

        // connect to a topic
        if (topicNumber > productTopics.size()) {
            //
            System.out.println("Invalid topic number");
        } else {
            // get the selected chat topic
            ProductTopic productTopic = productTopics.get(topicNumber - 1);

            // connect to the chat topic
            productTopic.connectToTopic();
        }
        // close the scanner
        scanner.close();
    }

    // sendMessages that periodically sends a message to all productTopic
    public static void sendMessages() {

        // print you can now send messages
        System.out.println("\n> You can now Send Messages! \n");

        // check if the topic list is empty and if it is, call init method
        if (productTopics.isEmpty()) {
            init();
        }

        Scanner scanner = new Scanner(System.in); // Create a Scanner object

        // for each chat topic
        for (ProductTopic productTopic : productTopics) {

            // get the message from the user on commandline
            System.out
                    .println("Enter Message to send: \nTo: " + productTopic.name + " topic at Port " + productTopic.port
                            + ": ");

            // as admin for input message that will be sent to the topic
            String message = scanner.nextLine(); // Read user input
            System.out.println("Message Sent As: " + message + "\n"); // Output user input

            // send a message
            productTopic.sendMessage(message);

            // sleep for a while
            try {
                Thread.sleep(productTopic.messageDuration);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // close the scanner
        }
        scanner.close();
    }

    // a method to send a message to the newly created last topic in productTopics
    public static void sendTopicMessage() {
        // get the user input
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n> You can now Send Messages! \n");

        System.out.println("\n\n>New list of chat topics from the server\n");

        //
        printTopics();

        System.out.println("\n> Choose a chat topic to Send a Message from ( 1 - " + productTopics.size() + " ): ");

        // variable to store the user input
        int topicNumber = scanner.nextInt();

        // connect to a topic
        if (topicNumber > productTopics.size()) {
            //
            System.out.println("Invalid topic number");
        } else {
            // flush the scanner
            scanner.nextLine();

            // get the selected chat topic
            ProductTopic productTopic = productTopics.get(topicNumber - 1);

            // get the message from the user on commandline
            System.out
                    .println("\nEnter Message to send: \nTo: " + productTopic.name + " topic at Port " + productTopic.port
                            + ": ");

            // as admin for input message that will be sent to the topic
            String message = scanner.nextLine(); // Read user input
            System.out.println("Message Sent As: " + message + "\n"); // Output user input

            // send a message
            productTopic.sendMessage(message);

        }

        // close the scanner
        scanner.close();
    }

    // main method
    public static void main(String[] args) throws NoSuchElementException, IOException {
        // initialize the chat topics
        init();

        System.out.println("\n +--------------------- Welcome to the Cephas Chat! ------------------------+\n");

        // print connected to the chat as a server
        System.out.println("\n+----> Connected as: SERVER");

        // send messages to each chat topic
        sendMessages();
    }

}
