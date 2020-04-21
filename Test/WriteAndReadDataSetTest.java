package Test;

import filepersistence.SensorDataStorage;
import filepersistence.WriteAndReadDataSet;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class WriteAndReadDataSetTest {

    /**
     * These are some of the tests i could think of and implement.
     */

    private static WriteAndReadDataSet getSensor() {
        return new WriteAndReadDataSet();
    }

    /**
     * Tests, if clearData returns an small array with 0
     */
    @Test
    public void clearDataTestSmall() {

        SensorDataStorage s = WriteAndReadDataSetTest.getSensor();

        // test values
        float[][] values = new float[1][1];
        values[0][0] = 1;

        // expected values
        float[][] empty = new float[1][1];
        empty[0][0] = 0;

        s.clearData(values);
        assertArrayEquals(values, empty);
    }

    /**
     * Tests, if clearData returns an big array with 0
     */
    @Test
    public void clearDataTestBig() {

        SensorDataStorage s = WriteAndReadDataSetTest.getSensor();

        // test values
        float[][] values = new float[100][100];
        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values[i].length; j++) {
                values[i][j] = 1;
            }
        }

        // expected values
        float[][] empty = new float[100][100];
        for (int i = 0; i < empty.length; i++) {
            for (int j = 0; j < empty[i].length; j++) {
                empty[i][j] = 0;
            }
        }

        s.clearData(values);
        assertArrayEquals(values, empty);
    }

    /**
     * Tests, if cleaSpecData returns an small array with a specific data cleared
     */
    @Test
    public void clearSpecDataTestSmall() {

        SensorDataStorage s = WriteAndReadDataSetTest.getSensor();

        // test values
        float[][] values = new float[3][3];
        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values[i].length; j++) {
                values[i][j] = 1;
            }
        }

        // expected values
        float[][] empty = new float[3][3];
        for (int i = 0; i < empty.length; i++) {
            for (int j = 0; j < empty[i].length; j++) {
                empty[i][j] = 1;
            }
        }
        empty[2][1] = 0;

        s.clearSpecData(values, 3, 2);
        assertArrayEquals(values, empty);
    }

    /**
     * Tests, if cleaSpecData returns an big array with a specific data cleared
     */
    @Test
    public void clearSpecDataTestBig() {

        SensorDataStorage s = WriteAndReadDataSetTest.getSensor();

        // test values
        float[][] values = new float[100][100];
        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values[i].length; j++) {
                values[i][j] = 1;
            }
        }

        // expected values
        float[][] empty = new float[100][100];
        for (int i = 0; i < empty.length; i++) {
            for (int j = 0; j < empty[i].length; j++) {
                empty[i][j] = 1;
            }
        }
        empty[58][36] = 0;

        s.clearSpecData(values, 59, 37);
        assertArrayEquals(values, empty);
    }

    /**
     * Tests, if dataSize gives the correct size of a small array
     */
    @Test
    public void dataSizeTestSmall() {

        SensorDataStorage s = WriteAndReadDataSetTest.getSensor();

        // test values
        float[][] values = new float[1][2];

        /**
         * expected int,
         */
        int e = 2;

        assertEquals(s.dataSize(values), e);
    }

    /**
     * Tests, if dataSize gives the correct size of a big array
     */
    @Test
    public void dataSizeTestBig() {

        SensorDataStorage s = WriteAndReadDataSetTest.getSensor();

        float[][] values = new float[100][100];

        /**
         * expected int,
         */
        int e = 10000;

        assertEquals(s.dataSize(values), e);
    }

    /**
     * Tests with two different arrays, if equalData works with small arrays
     */
    @Test
    public void equalDataTestSmall() {

        SensorDataStorage s = WriteAndReadDataSetTest.getSensor();

        // test values
        float[][] values = new float[1][1];
        values[0][0] = 1;

        // wrong values
        float[][] v2 = new float[1][1];
        v2[0][0] = 0;

        assertFalse(s.equalData(values, v2));
    }

    /**
     * Tests, if equalData works with big arrays
     */
    @Test
    public void equalDataTestBig() {

        SensorDataStorage s = WriteAndReadDataSetTest.getSensor();

        // test values
        float[][] values = new float[100][100];
        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values[i].length; j++) {
                values[i][j] = 1;
            }
        }

        // same values, different array
        float[][] v2 = new float[100][100];
        for (int i = 0; i < v2.length; i++) {
            for (int j = 0; j < v2[i].length; j++) {
                v2[i][j] = 1;
            }
        }

        assertTrue(s.equalData(values, v2));
    }

    /**
     * Tests, if the file the method has written in is not empty
     */
    @Test
    public void writeDataToFileTestEmpty() {

        SensorDataStorage s = WriteAndReadDataSetTest.getSensor();

        float[][] values = new float[1][1];
        values[0][0] = 1;

        long timeStamps[] = new long[1];
        timeStamps[0] = System.currentTimeMillis();

        String filename = "values.txt";

        String sensorName = "Sensor_1";

        s.writeDataToFile(values, timeStamps, filename, sensorName);
        assertFalse(filename.isEmpty());
    }

    /**
     * Tests, if the file the method has written in is not empty
     */
    @Test
    public void writeSpecDataToFileTestEmpty() {

        SensorDataStorage s = WriteAndReadDataSetTest.getSensor();

        float[][] values = new float[5][5];
        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values[i].length; j++) {
                int v = 10;
                values[i][j] = v;
                v++;
            }
        }

        long timeStamps[] = new long[5];
        timeStamps[0] = System.currentTimeMillis();
        timeStamps[1] = timeStamps[0] + 1000;
        timeStamps[2] = timeStamps[1] + 1000;
        timeStamps[3] = timeStamps[2] + 1000;
        timeStamps[4] = timeStamps[3] + 1000;

        String filename = "values.txt";

        String sensorName = "Sensor_1";

        int r1 = 2;
        int r2 = 4;
        int c1 = 1;
        int c2 = 3;

        s.writeSpecDataToFile(values, r1, r2, c1, c2, timeStamps, filename,sensorName);
        assertFalse(filename.isEmpty());
    }

    /**
     * Tests, if the string the method has written in is empty
     */
    @Test
    public void readDataFromFileTestEmpty() {

        SensorDataStorage s = WriteAndReadDataSetTest.getSensor();

        float[][] values = new float[5][5];
        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values[i].length; j++) {
                int v = 10;
                values[i][j] = v;
                v++;
            }
        }

        long timeStamps[] = new long[5];
        timeStamps[0] = System.currentTimeMillis();
        timeStamps[1] = timeStamps[0] + 1000;
        timeStamps[2] = timeStamps[1] + 1000;
        timeStamps[3] = timeStamps[2] + 1000;
        timeStamps[4] = timeStamps[3] + 1000;

        String filename = "values.txt";
        String sensorName = "Sensor_1";

        s.writeDataToFile(values, timeStamps, filename, sensorName);
        assertFalse(s.readDataFromFile(filename).isEmpty());
    }
}