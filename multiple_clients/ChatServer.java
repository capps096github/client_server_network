package multiple_clients;

import java.io.*;
import java.net.*;

public class ChatServer {
  // this is a server manages many clients
  // each client has a thread that communicates with the server
  // the server has a thread that listens for new clients
  // the server has a thread that listens for messages from clients

  public static void main(String[] args) {
    // create a server object
    ChatServer server = new ChatServer();
    // start the server
    server.start();
  }

  public void start() {
    // create a server socket
    ServerSocket serverSocket;

    // try block to handle exceptions
    try {
      // create a server socket
      serverSocket = new ServerSocket(6666);
      // create a client thread
      ClientThread clientThread = new ClientThread(serverSocket.accept());
      // start the client thread
      clientThread.start();
    } catch (Exception e) {
      // display the exception on the console
      System.out.println(e);
    }

  }
}

// this ClientThread class is a thread that listens for new clients
// it is created by the server when a new client connects
// it is started by the server when a new client connects
// it is stopped by the server when the server is stopped
// it is stopped by the client when the client disconnects
/// it is stopped by the client when the client sends a message
class ClientThread extends Thread {

  // this is the client socket
  // it is created by the client when a new client connects
  // it is closed by the client when the client disconnects
  // it is closed by the client when the client sends a message
  private final Socket clientSocket;

  // this is the client thread
  // it is created by the server when a new client connects
  // it is stopped by the server when the server is stopped
  // it is stopped by the client when the client disconnects
  // it is stopped by the client when the client sends a message
  public ClientThread(Socket clientSocket) {
    // set the client socket
    this.clientSocket = clientSocket;
  }

  public void run() {
    // try block to handle exceptions
    try {
      // create a data input stream
      DataInputStream dis = new DataInputStream(clientSocket.getInputStream());
      // read the message from the client
      String message = dis.readUTF();
      // display the message on the console
      System.out.println("Client message = " + message);
      // close the client socket
      clientSocket.close();
    } catch (Exception e) {
      // display the exception on the console
      System.out.println(e);
    }
  }

  public void start() {
    // try block to handle exceptions
    try {
      // create a data input stream
      DataInputStream dis = new DataInputStream(clientSocket.getInputStream());
      // read the message from the client
      String message = dis.readUTF();
      // display the message on the console
      System.out.println("Client message = " + message);
      // close the client socket
      clientSocket.close();
    } catch (Exception e) {
      // display the exception on the console
      System.out.println(e);
    }
  }

  public void close() {
    // try block to handle exceptions
    try {
      // close the client socket
      clientSocket.close();
    } catch (Exception e) {
      // display the exception on the console
      System.out.println(e);
    }
  }

  public void send(String message) {
    // try block to handle exceptions
    try {
      // create a data output stream
      DataOutputStream dos = new DataOutputStream(clientSocket.getOutputStream());
      // write the message to the client
      dos.writeUTF(message);
    } catch (Exception e) {
      // display the exception on the console
      System.out.println(e);
    }
  }

}
