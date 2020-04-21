package filepersistence;

import java.io.*;

public class TestStreams {
    public static void main(String[]args) {

        try {
            String filename ="testFile.txt";
            OutputStream os = new FileOutputStream(filename);   //opened Outputstream
            byte[] textAsByte = filename.getBytes();            //String to bytes
            os.write(textAsByte);                               //write Data

            InputStream is = null;
            is = new FileInputStream(filename);                 //opened InputStream
            byte[] readBuffer = new byte[100];
            is.read(readBuffer);                                //read Data
            String readString = new String(readBuffer);
            System.out.println("read something: " + readString);

            DataOutputStream dos = new DataOutputStream(os);    //new DataOutputStream
            dos.writeInt(42);                                //write Integer

            DataInputStream dis = new DataInputStream(is);      //new DataInputStream
            int readIntValue = dis.readInt();                   //read Integer
            System.out.println("read Integer: " + readIntValue);

            PrintStream ps = new PrintStream(os);               //new Printstream
            ps.println("Hello Stream");

            InputStreamReader isr = new InputStreamReader(is);  //new InputStreamReader
            BufferedReader br = new BufferedReader(isr);        //new BufferedReader
            readString = br.readLine();                         //read String
            System.out.println("read: " + readString);

        } catch (FileNotFoundException ex) {
            System.err.println("couldn't open file - fatal");
            System.exit(0);
        } catch (IOException e) {
            System.err.println("couldn't write data - fatal");
            System.exit(0);
        }

    }
}
