package group_chat;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.*;

// This is a special client among all clients, used to create groups on the server.
public class SpecialClient {

//    the getUserInput method for the special client that
//    gets user string input from the user

    public static String getUserInput() {
        // try block to handle exceptions
        try {
            // create a buffered reader
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            // read the user input
            String userInput = br.readLine();

//            create a group on the server
            createGroup(userInput);

            // return the user input
            return userInput;


        } catch (Exception e) {
            // display the exception on the console
            System.out.println(e);
            // return null
            return null;
        }
    }




  // the createGroup method for the client which is used to create a group on the server.
  public static void createGroup(String groupName) {
    // try block to handle exceptions
    try {
      // create a socket
      Socket socket = new Socket("localhost", 6666);
      // create a data output stream
      DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
      // write the message to the server
      dos.writeUTF("createGroup");
      // write the group name to the server
      dos.writeUTF(groupName);

      // close the socket
      socket.close();
    } catch (Exception e) {
      // display the exception on the console
      System.out.println(e);
    }
  }





}
