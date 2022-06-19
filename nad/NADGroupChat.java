package nad;

// this is the main class for the group chat
// it calls the methods to create the server and clients
public class NADGroupChat {

  public static void main(String[] args) {
    // create a server object
    GroupChatServer server = new GroupChatServer();
    // start the server
    server.start();
  }

}
