package mugisabrian;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

// Code Written
//->  MUGISA BRIAN - 2000707823 - 20/U/7823/PS

///THis is the chat group that the client subscribes to
public class ChatGroup {
  // name of the group
  public String name;

  // port number
  public int port;

  // message duration to wait for before sending another message
  public int messageDuration;

  // constructor
  public ChatGroup(String name, int port, int duration) {
    this.name = name;
    this.port = port;
    this.messageDuration = duration;
  }

  // method to print the group details
  public void printGroup() {
    // print
    System.out.println("\n +----------------------- Group Details ----------------------+\n");
    System.out.println("> Group name: " + name);
    System.out.println("> Port number: " + port);
    System.out.println("> Duration: " + messageDuration + "\n");

  }

  // send message method that send a message to the group at its port number
  public void sendMessage(String message) {
    //
    // Try block to check if exception occurs
    try {

      // Creating Socket class object and
      // initializing Socket
      Socket socket = new Socket("localhost", this.port);

      // create a DataOutputStream to write data to the server
      DataOutputStream dos = new DataOutputStream(
          socket.getOutputStream());

      // Message to be displayed on the server
      // this is sent by the client to the server using the DataOutputStream
      // writeUTF() method
      dos.writeUTF(message + "\n> Sent from:\n - " + this.name + " Group at Port: " + this.port
          + "\n+---------------------------------------------+\n");

      // Flushing out internal buffers,
      // optimizing for better performance
      dos.flush();

      // Closing the connections

      // Closing DataOutputStream
      dos.close();
      // Closing socket
      socket.close();
    }

    // Catch block to handle exceptions
    catch (Exception e) {

      // Print the exception on the console
      System.out.println(e);
    }

  }

  // connect to a group method that connects to a group at its port number and
  // starts listening to it for messages
  public void connectToGroup() {
    // Try block to check for exceptions
    try {

      System.out.println("\n +---------------------------------------------+\n");

      // print the message to show the client has joined the group
      System.out.println("You have joined the " + this.name + " group\n");
      // print the group details
      this.printGroup();

      // print now waiting for a message
      System.out.println("Now waiting for a message from the " + this.name + " group ....\n");

      // Creating an object of ServerSocket class
      // in the main() method for socket connection
      ServerSocket ss = new ServerSocket(this.port);

      // Establishing a connection
      Socket soc = ss.accept();

      // Invoking input stream via getInputStream()
      // method by creating DataInputStream class
      // object
      DataInputStream dis = new DataInputStream(soc.getInputStream());

      String str = dis.readUTF();

      // Display the string on the console
      System.out.println("> New Message: " + str);

      // Lastly close the socket using standard close
      // method to release memory resources
      ss.close();
    }

    // Catch block to handle the exceptions
    catch (Exception e) {

      // Display the exception on the console
      System.out.println(e);
    }
  }
}
