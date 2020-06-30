package Chess;

import java.io.DataInputStream;
import java.io.DataOutputStream;

public interface Streams {

    /**
     * get DataInputStream
     * @return
     */
    DataInputStream getDIS();

    /**
     * get DataOutputStream
     * @return
     */
    DataOutputStream getDOS();
}
