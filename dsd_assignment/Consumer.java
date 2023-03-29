package dsd_assignment;

public class Consumer {

    // main method, this first calls the server choose topic method
    // which allows the client to choose which topic to join

    public static void main(String[] args) {
        System.out.println("\n +--------- Welcome to the Product! ---------+\n");

        // print connected to the chat as a server
        System.out.println("\n+----> Connected as: Consumer\n");

        // choose a topic and keep listening
        ProductServer.chooseTopic();
    }

}
