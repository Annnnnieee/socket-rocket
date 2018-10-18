import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client implements Runnable{
    private Semaphore semaphore = null;
    private ConnectionInfo connectionInfo;

    public Client(Semaphore semaphore){
        this.semaphore = semaphore;
    }

    public void run(){
        try {
            this.semaphore.release();
            this.connectionInfo = this.semaphore.getConnectionInfo();
            System.out.println(connectionInfo.getOtherIpAddress());
            System.out.println(connectionInfo.getOtherPort());
            this.connectionInfo = this.semaphore.getConnectionInfo();
            Socket socket = new Socket(connectionInfo.getOtherIpAddress(), connectionInfo.getOtherPort());

           //Socket socket = new Socket(InetAddress.getByName("70.79.245.158"), 9876);

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println("::connect::"+9875+"::");
            System.out.println("Client Connected to " + connectionInfo.getOtherIpAddress());

            Scanner reader = new Scanner(System.in);
                String message = "";
                while(!message.equalsIgnoreCase("stop")) {
                    message = reader.nextLine();
                    out.println("xxTheNamesSTASIYAxx: " + message);
                }
            out.println("*poof*");
            out.close();
            reader.close();

        }catch(Exception e){
            System.out.println("Client Exception");
            e.printStackTrace();
        }
    }
}
