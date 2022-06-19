package group_chat;

// this is the ClientThread class that is created by the server when a new client connects
// it is stopped by the server when the server is stopped
// it is stopped by the client when the client disconnects
// it is stopped by the client when the client sends a message

import java.io.*;
import java.net.*;

public class ClientThread extends Thread {

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
