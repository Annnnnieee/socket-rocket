import java.net.InetAddress;

public class ConnectionInfo {
    private InetAddress otherIpAddress;
    private int otherPort;
    public static int myPort = 9875;
    public static String myIpAddress = "localhost";

    public ConnectionInfo(){
    }

    public ConnectionInfo(InetAddress otherIpAddress, int otherPort){
        this.otherIpAddress = otherIpAddress;
        this.otherPort = otherPort;
    }

    public InetAddress getOtherIpAddress() {
        return otherIpAddress;
    }

    public void setOtherIpAddress(InetAddress otherIpAddress) {
        this.otherIpAddress = otherIpAddress;
    }

    public int getOtherPort() {
        return otherPort;
    }

    public void setOtherPort(int otherPort) {
        this.otherPort = otherPort;
    }

    public int getMyport() {
        return myPort;
    }

    public void setMyport(int myport) {
        this.myPort = myport;
    }

    public String getMyIpAddress() {
        return myIpAddress;
    }

    public void setMyIpAddress(String myIpAddress) {
        this.myIpAddress = myIpAddress;
    }

}
