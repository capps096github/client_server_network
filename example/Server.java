package example;

import java.net.*;
import java.io.*;

// This is the Server class that will be used to create a server 
// https://www.geeksforgeeks.org/java-net-serversocket-class-in-java/?ref=gcse
public class Server {

  public static void main(String args[]) throws IOException {
    // declare a variable for the server socket which will be used to listen for connections to the server
    ServerSocket socket = null;

    // declare a variable for the buffered reader which will read data from the client
    BufferedReader reader = null;

      // server starts listening for connections on port 9999
      System.out.println("Waiting..");

    // while the server is running
    while (true) {
      // instantiate a server socket and listen for connections on port 9999
      socket = new ServerSocket(9999);

      // accept a connection from a client
      Socket sock = socket.accept();

      // instantiate a buffered reader to read data from the client
      reader = new BufferedReader(new InputStreamReader(sock.getInputStream()));

      // read data from the client
      String text = reader.readLine();

      // print the data received from the client
      System.out.println("\n\nReceived text:" + text);

      // close the socket
      sock.close();

      // close the server socket
      socket.close();

    }

  }

}
