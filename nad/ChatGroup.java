package nad;

///This is a group class with a name and port number
public class ChatGroup {
  // name
  String name;

  // port of the server
  int port;

  // constructor
  public ChatGroup(String name, int port) {
    this.name = name;
    this.port = port;
  }

    // getter for name
    public String getName() {
        return name;

    }

    // getter for port
    public int getPort() {
        return port;
    }

    // setter for name
    public void setName(String name) {
        this.name = name;
    }

    // setter for port
    public void setPort(int port) {
        this.port = port;
    }

}
