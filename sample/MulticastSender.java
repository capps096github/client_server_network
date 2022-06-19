// package sample;

// import java.net.DatagramPacket;
// import java.net.InetAddress;
// import java.io.*;
// import java.net.*;

// class MulticastSenderUDP {

//     public static void main(String[] args) throws IOException {

//         try {
//             InetAddress group = InetAddress.getByName("225.4.5.6");
//             MulticastSocket mSock = new MulticastSocket();

//             String msg = "Hello student, have you eaten food today?";
//             DatagramPacket packet = new DatagramPacket(msg.getBytes(), msg.length(), group, 7799);

//             mSock.send(packet);
//             System.out.println("Waiting for receiver");

//             mSock.close();
//         } catch (Exception e) {
//             e.printStackTrace();
//         }

//     }
// }
