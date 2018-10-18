public class Semaphore {
    private boolean signal = false;
    private ConnectionInfo connectionInfo;

    public synchronized void take() {
        this.signal = true;
        this.notify();
    }

    public synchronized void release() throws InterruptedException{
        while(!this.signal) wait();
        this.signal = false;
    }


    public ConnectionInfo getConnectionInfo() {
        return connectionInfo;
    }

    public void setConnectionInfo(ConnectionInfo connectionInfo) {
        this.connectionInfo = connectionInfo;
    }
}
