package mugisabrian;

import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

// Code Written
//->  MUGISA BRIAN - 2000707823 - 20/U/7823/PS

public class ChatServer {

    // create ArrayList
    public static ArrayList<ChatGroup> chatGroups = new ArrayList<>();

    // default chat groups initialization
    public static void init() {
        //
        chatGroups.add(new ChatGroup("Engineers", 6666, 1000));
        chatGroups.add(new ChatGroup("Writers", 7777, 1000));
        chatGroups.add(new ChatGroup("Artists", 8888, 1000));
        chatGroups.add(new ChatGroup("Musicians", 9999, 1000));
    }

    // static method create group that adds an item to the list of groups
    public static void createGroup() {
        // print create group
        System.out.println("\n> You can now Create a Group! \n");
        System.out.println("> Current list of chat groups from the server\n");

        printGroups();

        // create a new group text
        System.out.println("\n\n> Enter the details of the  NEW GROUP here\n");

        // capture user input for group name, port number and duration then create a
        // chat group object that will be added to the list
        Scanner scanner = new Scanner(System.in);
        System.out.println("Name of the group e.g. Artisans: ");
        String name = scanner.nextLine();
        System.out.println("Port Number e.g. 5555: ");
        int port = scanner.nextInt();
        System.out.println("Message Duration e.g 100: ");
        int duration = scanner.nextInt();
        //
        ChatGroup chatGroup = new ChatGroup(name, port, duration);

        // add the chat group to the list
        chatGroups.add(chatGroup);

        // print that the group was created and all its details
        System.out.println("\n> New Group created successfully!");

        // print the group details
        chatGroup.printGroup();

        // close the scanner
        scanner.close();
    }

    public static void printGroups() {
        // check if the group list is empty and if it is, call init method
        if (chatGroups.isEmpty()) {
            init();
        }

        // use a for loop to print the list of chat groups
        for (int i = 0; i < chatGroups.size(); i++) {
            // current chat group
            ChatGroup chatGroup = chatGroups.get(i);
            //
            System.out.println(i + 1 + ") " + chatGroup.name + " Group at Port: " + chatGroup.port);
        }
    }

    // choose a chat group to join method that shows the list of chat groups from
    // the server in a menu
    // then it asks the user to choose a chat group to join
    // it then connects to the chat group via the port number and starts listening
    // to it for messages
    // it then prints the message to the console
    public static void chooseGroup() {
        System.out.println("Current list of chat groups from the server\n");

        //
        printGroups();

        System.out.println("\n Choose a chat group to join from ( 1 - " + chatGroups.size() + " ): ");
        // get the user input
        Scanner scanner = new Scanner(System.in);

        // variable to store the user input
        int groupNumber = scanner.nextInt();

        // connect to a group
        if (groupNumber > chatGroups.size()) {
            //
            System.out.println("Invalid group number");
        } else {
            // get the selected chat group
            ChatGroup chatGroup = chatGroups.get(groupNumber - 1);

            // connect to the chat group
            chatGroup.connectToGroup();
        }
        // close the scanner
        scanner.close();
    }

    // sendMessages that periodically sends a message to all ChatGroup
    public static void sendMessages() {

        // print you can now send messages
        System.out.println("\n> You can now Send Messages! \n");

        // check if the group list is empty and if it is, call init method
        if (chatGroups.isEmpty()) {
            init();
        }

        Scanner scanner = new Scanner(System.in); // Create a Scanner object

        // for each chat group
        for (ChatGroup chatGroup : chatGroups) {

            // get the message from the user on commandline
            System.out
                    .println("Enter Message to send: \nTo: " + chatGroup.name + " Group at Port " + chatGroup.port
                            + ": ");

            // as admin for input message that will be sent to the group
            String message = scanner.nextLine(); // Read user input
            System.out.println("Message Sent As: " + message + "\n"); // Output user input

            // send a message
            chatGroup.sendMessage(message);

            // sleep for a while
            try {
                Thread.sleep(chatGroup.messageDuration);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // close the scanner
        }
        scanner.close();
    }

    // a method to send a message to the newly created last group in chatGroups
    public static void sendGroudMessage() {
        // get the user input
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n> You can now Send Messages! \n");

        System.out.println("\n\n>New list of chat groups from the server\n");

        //
        printGroups();

        System.out.println("\n> Choose a chat group to Send a Message from ( 1 - " + chatGroups.size() + " ): ");

        // variable to store the user input
        int groupNumber = scanner.nextInt();

        // connect to a group
        if (groupNumber > chatGroups.size()) {
            //
            System.out.println("Invalid group number");
        } else {
            // flush the scanner
            scanner.nextLine();

            // get the selected chat group
            ChatGroup chatGroup = chatGroups.get(groupNumber - 1);

            // get the message from the user on commandline
            System.out
                    .println("\nEnter Message to send: \nTo: " + chatGroup.name + " Group at Port " + chatGroup.port
                            + ": ");

            // as admin for input message that will be sent to the group
            String message = scanner.nextLine(); // Read user input
            System.out.println("Message Sent As: " + message + "\n"); // Output user input

            // send a message
            chatGroup.sendMessage(message);

        }

        // close the scanner
        scanner.close();
    }

    // main method
    public static void main(String[] args) throws NoSuchElementException, IOException {
        // initialize the chat groups
        init();

        System.out.println("\n +--------------------- Welcome to the Cephas Chat! ------------------------+\n");

        // print connected to the chat as a server
        System.out.println("\n+----> Connected as: SERVER");

        // send messages to each chat group
        sendMessages();
    }

}
