package transmission;

import org.junit.Assert;
import org.junit.Test;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;


public class TransmissionTest {
    private static final int PORTNUMBER = 7777;
    private static final int TEST_INT = 42;

    @Test
    public void gutConnectionTest1() throws IOException {
        // open server side
        DataConnector serverSide = new DataConnector(PORTNUMBER);

        // open client side
        DataConnector clientSide = new DataConnector("localhost", PORTNUMBER);

        DataOutputStream dos = clientSide.getDataOutputStream();
        dos.writeInt(TEST_INT);

        DataInputStream dis =serverSide.getDataInputStream();
        int readValue = dis.readInt();

        Assert.assertEquals(TEST_INT, readValue);
    }
}