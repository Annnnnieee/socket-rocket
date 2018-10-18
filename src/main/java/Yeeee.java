import java.io.IOException;
import java.net.InetAddress;
import java.util.Scanner;

public class Yeeee {
    private static int otherPort = 9876;
    private static String otherAddress;

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        Semaphore semaphore = new Semaphore();

        Server sender = new Server(semaphore, otherPort);
        Client receiver = new Client(semaphore);
        Thread senderThread = new Thread(sender);
        Thread receiverThread = new Thread (receiver);
        senderThread.start();
        receiverThread.start();

        try {
            System.out.println("enter other port: ");
            int port = Integer.parseInt(scanner.nextLine());
            System.out.println("enter other ipAddress: ");
            String address = scanner.nextLine();
            if(semaphore.getConnectionInfo() == null) {
                semaphore.setConnectionInfo(new ConnectionInfo(InetAddress.getByName(address), port));
                semaphore.take();
            }

        }catch(Exception e){
            System.out.println("user input terminated.. connection should be established");
        }
    }
}
