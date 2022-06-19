package group_chat;

public class ChatGroup {
  // name
  String name;

  // port number
  int port;

  // members
  String[] members;

  // constructor
  public ChatGroup(String name, String[] members, int port) {
    this.name = name;
    this.port = port;
    this.members = members;
  }

}
