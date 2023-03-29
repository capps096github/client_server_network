package dsd_assignment;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;


///THis is the chat topic that the client subscribes to
public class ProductTopic {
  // name of the topic
  public String name;

  // port number
  public int port;

  // message duration to wait for before sending another message
  public int messageDuration;

  public  Date dateSent;

  // constructor
  public ProductTopic(String name, int port, int duration, Date date) {
    this.name = name;
    this.port = port;
    this.messageDuration = duration;
    this.dateSent = date;
  }

  // method to print the topic details
  public void printTopic() {
    // print
    System.out.println("\n +----------------------- Topic Details ----------------------+\n");
    System.out.println("> Topic name: " + name);
    System.out.println("> Port number: " + port);
    System.out.println("> Duration: " + messageDuration + "\n");
    System.out.println("> Date: " + dateSent + "\n");

  }

  // send message method that send a message to the topic at its port number
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
      dos.writeUTF(message + "\n> Sent from:\n - " + this.name + " Topic at Port: " + this.port
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

  // connect to a topic method that connects to a topic at its port number and
  // starts listening to it for messages
  public void connectToTopic() {
    // Try block to check for exceptions
    try {

      System.out.println("\n +---------------------------------------------+\n");

      // print the message to show the client has joined the topic
      System.out.println("You have joined the " + this.name + " topic\n");
      // print the topic details
      this.printTopic();

      // print now waiting for a message
      System.out.println("Now waiting for a message from the " + this.name + " topic ....\n");

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
