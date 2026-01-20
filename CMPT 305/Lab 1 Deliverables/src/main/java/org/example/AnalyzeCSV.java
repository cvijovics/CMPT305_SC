package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class AnalyzeCSV {
    public static void main(String[] args)
    {
        String csvFileName = "Property_Assessment_Data_2025.csv";
        try {
            String[][] data = readData(csvFileName);
            printAnswers(data);
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
                    data = Arrays.copyOf(data, data.length*2);
                }

                data[currentIndex++] = values;
            }
        }

        // Remove empty rows in the array and return it
        return Arrays.copyOf(data, currentIndex);
    }
    private static void printAnswers(String[][] data)
    {
        System.out.println("Amount of records: " + getRecordAmount(data));
        System.out.println("Lowest assessed value: " + getLowestValue(data));
        System.out.println("Highest assessed value: " + getHighestValue(data));
        System.out.println("Total wards in Edmonton: " + numberOfWards(data));
        System.out.println("Assessment classes in Edmonton: " + getAssessmentClasses(data));
    }
    /**
     * @param data - processed data from csv
     * @return the amount of records in the csv
     *
     */
    private static int getRecordAmount(String[][] data)
    {
        return data.length;
    }

    /// Go through each line and continuously update the lowest value (column index 7)
    private static int getLowestValue(String[][] data)
    {
        int lowest = 100000; /// use number in dataset
        for (String[] index : data) {
            int value = Integer.parseInt(index[7]);
            if (value < lowest) {
                lowest = value;
            }
        }
        return lowest;
    }

    ///  Go through each line and continuously update the highest value
    private static int getHighestValue(String[][] data)
    {
        int highest = 100000;
        for (String[] index : data) {
            int value = Integer.parseInt(index[7]);
            if (value > highest) {
                highest = value;
            }
        }
        return highest;
    }

    /// Increment a value whenever a unique ward is found
    private static int numberOfWards(String[][] data)
    {
        String[] uniqueWards = new String[1];
        for (String[] index: data) {
            if (wardExists(index, uniqueWards))
            {
                if (uniqueWards[0] != null) {
                    uniqueWards = Arrays.copyOf(uniqueWards, uniqueWards.length + 1);
                }
                uniqueWards[uniqueWards.length-1] = index[6];
            }
        }

        return uniqueWards.length;
    }

    private static boolean wardExists(String[] index, String[] uniqueWards)
    {
        if (uniqueWards[0] == null)
        {
            return true;
        }
        for (String ward: uniqueWards) {
            if (ward.equals(index[6])) {
                return false;
            }
        }
        return true;
    }

    private static boolean classExists(String[] index, String[] uniqueClasses)
    {
        if (uniqueClasses[0] == null)
        {
            return true;
        }
        for (String uniqueClass: uniqueClasses) {
            if (uniqueClass.equals(index[10])) {
                return false;
            }
        }
        return true;
    }

    /// Populate an array whenever a unique property assessment class is found
    private static String getAssessmentClasses (String[][] data)
    {
        String[] uniqueClasses = new String[1];
        for (String[] index : data) {
            if (classExists(index, uniqueClasses))
            {
                if (uniqueClasses[0] != null) {
                    uniqueClasses = Arrays.copyOf(uniqueClasses, uniqueClasses.length + 1);
                }
                uniqueClasses[uniqueClasses.length-1] = index[10];
            }
        }
        StringBuilder result = new StringBuilder();

        for (String uniqueClass: uniqueClasses){
            if (result.isEmpty()){
                result.append(uniqueClass);
            }
            else{
                result.append(", ").append(uniqueClass);
            }
        }
        return result.toString();
    }
}
