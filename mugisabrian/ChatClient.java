package mugisabrian;

// Code Written
//->  MUGISA BRIAN - 2000707823 - 20/U/7823/PS

public class ChatClient {

    // main method, this first calls the server choose group method
    // which allows the client to choose which group to join

    public static void main(String[] args) {
        System.out.println("\n +--------------------- Welcome to the Cephas Chat! ------------------------+\n");

        // print connected to the chat as a server
        System.out.println("\n+----> Connected as: CLIENT\n");

        // choose a group and keep listening
        ChatServer.chooseGroup();
    }

}
