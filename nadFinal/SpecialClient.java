package nadFinal;

import java.util.ArrayList;

public class SpecialClient {
  // Start the special client
  // this creates groups
  // and shows a menu for clients to join or leave groups
  // and allows clients to send messages to other clients

  // ArrayList<ChatGroup> chatGroups = new ArrayList<ChatGroup>();
  // create a default chat group with the name "default" and port number 6666 and
  // an empty list of ChatClient
  // chatGroups.add(new ChatGroup("default", 6666, new ArrayList<ChatClient>()));
  // chatGroups.add(new ChatGroup("default", 6666));
  ArrayList<ChatGroup> chatGroups;

  public SpecialClient() {
    chatGroups = new ArrayList<ChatGroup>();
    chatGroups.add(new ChatGroup("default", 6666, new ArrayList<ChatClient>()));
  }

  public void start() {
    // try block to handle exceptions
    try {
      ClientThread clientThread = new ClientThread(6666);

      // start the client thread to handle the clients connection
      clientThread.start();
    } catch (Exception e) {
      // display the exception on the console
      System.out.println(e);
    }
  }

  public void createGroup(String name, int port, ArrayList<ChatClient> clients) {
    chatGroups.add(new ChatGroup(name, port, clients));
  }


}
