package tutorial;

// File Name GreetingClient.java
import nad.ChatClient;

import java.net.*;
import java.io.*;

public class GreetingClient {

  public static void main(String[] args) {
    String serverName = args[0];
    int port = Integer.parseInt(args[1]);
      ChatClient.joinConnection(serverName, port);
  }
}