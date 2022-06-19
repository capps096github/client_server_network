package tutorial;

// Compile the client and the server and then start the server as follows

// File Name GreetingServer.java
import nad.ClientThread;

import java.net.*;
import java.io.*;

public class GreetingServer extends Thread {
  private ServerSocket serverSocket;

  public GreetingServer(int port) throws IOException {
    serverSocket = new ServerSocket(port);
    serverSocket.setSoTimeout(10000);
  }

  public void run() {
      ClientThread.connect(serverSocket);
  }

  public static void main(String[] args) {
    int port = Integer.parseInt(args[0]);
    try {
      Thread t = new GreetingServer(port);
      t.start();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}