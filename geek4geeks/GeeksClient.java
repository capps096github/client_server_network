package geek4geeks;


// Java Program to implement ServerSocket class
// Client - side

// Importing required libraries
import java.io.*;
import java.net.*;

// Main class
public class GeeksClient {

	// Main driver method
	public static void main(String[] args)
	{

		// Try block to check if exception occurs
		try {

			// Creating Socket class object and
			// initializing Socket
            Socket socket = new Socket("localhost", 6666);

      // create a DataOutputStream to write data to the server
			DataOutputStream dos = new DataOutputStream(
				socket.getOutputStream());

            // Message to be displayed on the server
      // this is sent by the client to the server using the DataOutputStream writeUTF() method
			dos.writeUTF("Hello GFG Readers!");

			// Flushing out internal buffers,
			// optimizing for better performance
			dos.flush();

			// Closing the connections

			// Closing DataOutputStream
			dos.close();
			// Closing socket
			socket.close();
		}

		// Catch block to handle exceptions
		catch (Exception e) {

			// Print the exception on the console
			System.out.println(e);
		}
	}
}
