package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

/**
 * An example of how to read and process a CSV file.
 * It uses that CsvParser class.
 * Copy both files into a package of your choice
 * This code uses only basic features of the Java language.
 * Feel free to modify this example.
 */
public class ReadCSV {
    public static void main(String[] args) {
        String csvFileName = "stocks.csv";

        try {
            String[][] data = readData(csvFileName);
            printData(data);
        } catch (IOException e) {
            System.out.println("Failed to read " + csvFileName);
        }
    }

    /**
     * Read the contents of a CSV file and return data as a 2D array of String.
     *
     * @param csvFileName - the CSV file name
     * @return the values in the CSV file
     * @throws IOException - IO exception
     */
    private static String[][] readData(String csvFileName) throws IOException {
        String[][] data;
        int currentIndex = 0;
        // Try-with-resources statement to create a stream to read the CSV file. Automatically closes the resource.
        try (BufferedReader reader = Files.newBufferedReader(Path.of(csvFileName))) {
            // Skip the header - this assumes the first line is a header
            reader.readLine();

            // Create 2D array to store all rows of data as String
            int initialSize = 100;
            data = new String[initialSize][];

            // Read the file line by line and store all rows into a 2D array
            String record;
            while ((record = reader.readLine()) != null) {
                // Parse the record into fields
                // A simple CSV line with fields that are not surrounded by double-quotes,
                // and all commas acting as separators, can be split using the String.plit() method.
                // String[] values = record.split(",");
                // Otherwise, a more general CSV parsing is required:
                String[] values = CsvParser.parseCSVLine(record);

                // Check if the array is full
                if (currentIndex == data.length)
                // Array is full, create and copy all values to a larger array
                {
                    data = Arrays.copyOf(data, data.length * 2);
                }

                data[currentIndex++] = values;
            }
        }

        // Remove empty rows in the array and return it
        return Arrays.copyOf(data, currentIndex);
    }

    /**
     * Print all rows of data.
     *
     * @param data - 2D array containing data
     */
    private static void printData(String[][] data) {
        System.out.println("The number of records: " + data.length);
        for (String[] row : data) {
            System.out.println("Date: " + row[0]);
            System.out.println("Symbol: " + row[1]);
            System.out.printf("Closing price: $%.2f\n\n", Double.parseDouble(row[3]));
        }
    }

}
