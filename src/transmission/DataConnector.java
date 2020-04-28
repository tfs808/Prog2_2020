package transmission;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class DataConnector implements DataConnection {

    private final Socket s;

    /**
     * Create client side - open connection to address / port
     * @param address
     */
    public DataConnector(String address, int port) throws IOException {
        this.s = new Socket(address, port);
        System.out.println("connected to " + address + ": " + port);
    }

    /**
     * Create server side - open port on this port and wait for one client
     * @param port
     */
    public DataConnector(int port) throws IOException {
        ServerSocket ss = new ServerSocket(port);
        this.s = ss.accept();
        System.out.println("connection established");
    }

    @Override
    public DataInputStream getDataInputStream() throws IOException {
        DataInputStream dis = new DataInputStream(this.s.getInputStream());
        return dis;
    }

    @Override
    public DataOutputStream getDataOutputStream() throws IOException {
        DataOutputStream dos = new DataOutputStream(this.s.getOutputStream());
        return dos;
    }

}
