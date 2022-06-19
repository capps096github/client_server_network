package mugisabrian;

import java.io.*;
import java.util.*;

// Code Written
//->  MUGISA BRIAN - 2000707823 - 20/U/7823/PS

public class SpecialClient {
  // get the user input
  public static Scanner scanner = new Scanner(System.in);

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
    System.out.println("\n1. Create a Group");
    System.out.println("2. Send a Message");
    System.out.println("3. Exit");

    // print
    System.out.println("\n> Choose an option: ");

    // variable to store the user input
    int choice = scanner.nextInt();

    // print
    System.out.println("\n>Choice " + choice);

    // if choice is 1, call the create group method
    if (choice == 1) {
      // call the create group method
      ChatServer.createGroup();
    } else if (choice == 2) {
      // if choice is 2, call the send message method
      ChatServer.sendGroudMessage();
    } else if (choice == 3) {
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
