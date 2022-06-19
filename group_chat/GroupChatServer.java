package group_chat;

import java.net.ServerSocket;

// A server manages many clients
// Each client has a thread that communicates with the server
// The server has a thread that listens for new clients
// The server has a thread that listens for messages from clients

public class GroupChatServer {

    // this is the start method for the server
    public void start() {
        // create a server socket
        ServerSocket serverSocket;

        // try block to handle exceptions
        try {
            // create a server socket
            serverSocket = new ServerSocket(6666);

            // create a client thread
            ClientThread clientThread = new ClientThread(serverSocket.accept());

            // start the client thread to handle the clients connection
            clientThread.start();
        } catch (Exception e) {
            // display the exception on the console
            System.out.println(e);
        }

    }

}
