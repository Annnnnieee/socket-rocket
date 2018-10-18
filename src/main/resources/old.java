//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.PrintWriter;
//import java.net.InetAddress;
//import java.net.ServerSocket;
//import java.net.Socket;
//import java.util.Scanner;
//
//public class old {
//}
//
//import java.io.BufferedReader;
//        import java.io.IOException;
//        import java.io.InputStreamReader;
//        import java.io.PrintWriter;
//        import java.net.InetAddress;
//        import java.net.ServerSocket;
//        import java.net.Socket;
//        import java.net.UnknownHostException;
//        import java.util.Scanner;
//
//public class Yeeee {
//    private static int otherPort;
//    private static String otherAddress;
//
//    public static void main(String[] args) throws IOException {
//
//        final int serverSocketPort = 9900;
//
//        //192.168.0.20
//        final InetAddress address = InetAddress.getByName("192.168.0.24");
//        //final InetAddress address = InetAddress.getLocalHost();
//
//        Thread serverThread = new Thread(new Runnable() {
//            public void run() {
//                try {
//                    ServerSocket server = new ServerSocket(serverSocketPort);
//                    Socket client = server.accept();
//                    otherAddress = client.getInetAddress().toString();
//                    System.out.println("connected to " + otherAddress);
//
//                    BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
//                    otherPort =  Integer.parseInt(in.readLine());
//                    while (true) {
//                        System.out.println(in.readLine());
//                    }
//
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//
//        Thread clientThread = new Thread(new Runnable() {
//            public void run() {
//                try {
//                    Socket socket = new Socket(otherAddress, otherPort);
//
//                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
//                    out.println(serverSocketPort);
//                    Scanner reader = new Scanner(System.in);
//                    String message = "";
//                    while(!message.equalsIgnoreCase("stop")) {
//                        message = reader.nextLine();
//                        out.println("xxTheNamesSTASIYAxx: " + message);
//                    }
//                    reader.close();
//                    out.println("*poof*");
//                    out.close();
//                    reader.close();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//
//
//        serverThread.start();
//        clientThread.start();
//    }
//}
