import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.util.Scanner;
import java.util.concurrent.locks.Lock;

public class Server implements Runnable{
    private Semaphore semaphore = null;
    private ConnectionInfo connectionInfo;


    public Server(Semaphore semaphore, int serverSocketPort){
        this.semaphore = semaphore;
        this.connectionInfo = new ConnectionInfo();
    }

    public void run(){
        try {
            ServerSocket server = new ServerSocket(ConnectionInfo.myPort);
            Socket client = server.accept();
            InetAddress otherAddress = client.getInetAddress();
            System.out.println("server connected to " + otherAddress);

            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            int otherPort = Integer.parseInt(in.readLine());
            this.semaphore.setConnectionInfo(new ConnectionInfo(otherAddress, otherPort));
            this.semaphore.take();

            while (true) {
                System.out.println("Incoming message: " + in.readLine());
            }
        }catch(Exception e){
            System.out.println("Server exception:");
            e.printStackTrace();
        }

    }
}
