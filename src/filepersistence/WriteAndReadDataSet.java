package filepersistence;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Arrays;

public class WriteAndReadDataSet implements SensorDataStorage {

    final SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss.SSS");

    @Override
    public float[][] clearData(float[][] values) {
        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values[i].length; j++) {
                values[i][j] = 0;
            }
        }
        return values;
    }

    @Override
    public float[][] clearSpecData(float[][] values, int r, int c) {
        try {
            values[r - 1][c - 1] = 0;                                               //because of the zero-based indexing
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Diesen Eintrag gibt es nicht.");
            System.exit(0);
        }
        return values;
    }

    @Override
    public int dataSize(float[][] values) {
        int num = 0;
        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values[i].length; j++) {
                num++;
            }
        }
        return num;
    }

    @Override
    public boolean equalData(float[][] values1, float[][] values2) {
        boolean e = false;
        if (Arrays.deepEquals(values1, values2)) {
            e = true;
        }
        return e;
    }

    @Override
    public void writeDataToFile(float[][] values, long[] time, String filename, String sensorName) {
        try {
            FileOutputStream fos = new FileOutputStream(filename);
            DataOutputStream dos = new DataOutputStream(fos);
            for (int i = 0; i < values.length; i++) {
                for (int j = 0; j < values[i].length; j++) {
                    dos.writeUTF(sensorName);
                    dos.writeLong(time[j]);
                    dos.writeFloat(values[i][j]);
                }
            }
            dos.flush();
            dos.close();
        } catch (FileNotFoundException fe) {
            System.err.println("couldn't open data - fatal");
            System.exit(0);
        } catch (IOException ioe) {
            System.err.println("couldn't write data - fatal");
            System.exit(0);
        }
    }

    @Override
    public void writeSpecDataToFile(float[][] values, int r1, int r2, int c1, int c2, long[] time, String filename,
                                    String sensorName) {
        try {
            r1 = r1 - 1;                                                           //because of the zero-based indexing
            c1 = c1 -1;
            FileOutputStream fos = new FileOutputStream(filename);
            DataOutputStream dos = new DataOutputStream(fos);
            for (int r = r1 - 1; r >= r1 && r < r2; r++) {
                for (int c = c1 - 1; c >= c1 && c < c2; r++) {
                    dos.writeUTF(sensorName);
                    dos.writeLong(time[r - 1]);
                    dos.writeFloat(values[r][c]);
                }
            }
        } catch (FileNotFoundException fe) {
            System.err.println("couldn't open data - fatal");
            System.exit(0);
        } catch (IOException ioe) {
            System.err.println("couldn't read data - fatal");
            System.exit(0);
        }
    }

    @Override
    public String readDataFromFile(String filename) {
        String c = "";
        try {
            InputStream is = null;
            is = new FileInputStream(filename);
            DataInputStream dis = new DataInputStream(is);
            while (is.available() > 0) {
                String sName = dis.readUTF();
                long t = dis.readLong();
                float v = dis.readFloat();
                c = sName + ", " + sdf.format(t) + ", " + v + " Grad Celsius";
            }
            dis.close();
        } catch (FileNotFoundException fex) {
            System.err.println("couldn't open data - fatal");
            System.exit(0);
        } catch (IOException iex) {
            System.err.println("couldn't read data - fatal");
            System.exit(0);
        }
        return c;
    }
}