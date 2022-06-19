// package sample;


// import java.net.DatagramPacket;
// import java.net.InetAddress;
// import java.io.*;
// import java.net.*;

// class MulticastReceiver {

//     public static void main(String[] args) throws IOException {
//         try {

//             InetAddress group = InetAddress.getByName("225.4.5.6");
//             MulticastSocket mSock = new MulticastSocket(7799);

//             mSock.joinGroup(group);
//             byte[] buffer = new byte[560];

//             DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
//             mSock.receive(packet);

//             System.out.println("Connected");
//             System.out.println(new String(buffer));

//             mSock.close();
//         } catch (Exception e) {
//             e.printStackTrace();
//         }

//     }
// }
