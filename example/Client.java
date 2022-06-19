package example;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;


// This is the Client class that will be used to create a client
public class Client {
  public static void main(String[] args) throws IOException {
    // create a socket that connects to the server
    Socket socket = new Socket("localhost", 9999);

    // data to be sent to the server
    String text = "Hi server";

    // create a PrintWriter that sends data to the server
    PrintWriter p = new PrintWriter(socket.getOutputStream(), true);

    // send the data to the server by calling the println method
    p.println(text);

    // close the socket
    socket.close();

  }

}