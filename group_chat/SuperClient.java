package group_chat;

import java.io.*;
import java.util.*;

import mugisabrian.ChatServer;

public class SuperClient {
  // main method that calls the server create group method
  public static void main(String[] args) throws IOException, NoSuchElementException {

    // create a group and send a message to it
    init();
  }

  // init method, that shows a menu to the user to ask them whether they want to
  // create a group or send a message
  public static void init() throws IOException {
    // print the menu
    System.out.println("\n +--------------------- Welcome to the Cephas Chat! ------------------------+\n");
    System.out.println("\n+----> Connected as: SPECIAL CLIENT\n");
    System.out.println("\nWhat do you want to do today?\n");
    System.out.println("\na. Create a Group");
    System.out.println("b. Send a Message");
    System.out.println("c. Exit");

    // get the user input
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    // print
    System.out.println("\n> Choose an option: ");
    // variable to store the user input

    // int choice = reader.read();
    char choice = reader.readLine().charAt(0);
    // print
    System.out.println("\n>Choice " + choice);

    //
    reader.close();

    // if choice is 1, call the create group method
    if (choice == 'a') {
      // call the create group method
      ChatServer.createGroup();
    } else if (choice == 'b') {
      // if choice is 2, call the send message method
      ChatServer.sendGroudMessage();
    } else if (choice == 'c') {
      // print exiting
      System.out.println("\n> Exiting... \n");

      // if choice is 3, exit the program
      System.exit(0);
    } else {
      // if choice is not 1, 2, or 3, print an error message
      System.out.println("\n> Invalid choice");
    }

  }
}
