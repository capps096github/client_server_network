package nadFinal;

import java.util.ArrayList;

///This is a group class with a name and port number
public class ChatGroup {
    // name
    String name;

    // port of the server
    int port;

    // list of clients in the group
    ArrayList<ChatClient> clients;

    // constructor
    public ChatGroup(String name, int port, ArrayList<ChatClient> clients) {
        this.name = name;
        this.port = port;
        this.clients = clients;
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

    // getter for clients
    public ArrayList<ChatClient> getClients() {
        return clients;
    }

    // setter for clients
    public void setClients(ArrayList<ChatClient> clients) {
        this.clients = clients;
    }

}
