package streamMachine;

public interface SensorDataStorage {

    /**
     * This method can be called by a sensor to delete all values.
     * @param values sensor data
     */
    float[][] clearData(float[][] values);

    /**
     * This method can be called by a sensor to delete a specific value.
     * @param values sensor data
     * @param r row index
     * @param c column index
     */
    float[][] clearSpecData(float[][] values, int r, int c);

    /**
     * This method can be called by a sensor to show the number of values.
     * @param values sensor data
     */
    int dataSize(float[][] values);

    /**
     * This method can be called by a sensor to show if values are equal
     * @param values1 first set of sensor data
     * @param values2 second set of sensor data
     */
    boolean equalData(float[][] values1, float[][] values2);

    /**
     * This method can be called by a sensor to write Data into a file.
     * @param values sensor data
     * @param time time when measurement took place
     * @param filename File the sensor writes in
     * @param sensorName name of the sensor
     */
    void writeDataToFile(float[][] values, long[] time, String filename, String sensorName);

    /**
     * This method can be called by a sensor to print specific data. Works for one or more than one values.
     * @param values sensor data
     * @param  r1 first row index
     * @param r2 second row index
     * @param c1 first column index
     * @param c2  second column index
     * @param time time when measurement took place
     * @param filename File the sensor writes in
     * @param sensorName name of the sensor
     */
    void writeSpecDataToFile(float[][] values, int r1, int r2, int c1, int c2, long[] time, String filename,
                             String sensorName);

    /**
     * This method can be called by a sensor to read Data from a file in a String.
     * @param filename File the sensor reads from
     */
    String readDataFromFile(String filename);
}
