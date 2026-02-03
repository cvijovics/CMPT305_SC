package org.lab3;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class PropertyAssessments {

    private final List<PropertyAssessment> assessmentList = new ArrayList<>();
    public PropertyAssessments(String csvFileName) throws IOException {
        String[][] data = readData(csvFileName);
        for (String[] index : data)
        {
            PropertyAssessment entry = new PropertyAssessment(index);
            assessmentList.add(entry);
        }
    }

    public PropertyAssessment getPropertyAssessment(String id)
    {
        if (intCheck(id)){
            for (PropertyAssessment property : assessmentList) {
                if (Integer.parseInt(id) == property.getAccountNum())
                {
                    return property;
                }
            }
            System.out.println("Property is not found");
            return null;
        } else {
            System.out.println("Error: invalid account number...");
            return null;
        }


    }

    private static boolean intCheck(String id){
        if (id == null){
            return false;
        }
        try {
            Integer.parseInt(id);
            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }

    public boolean doesNeighbourhoodExist(String neighbourhood){
        for (PropertyAssessment property : assessmentList){
            Neighbourhood currentHood = property.getNeighbourhood();
            if (neighbourhood.trim().equalsIgnoreCase(currentHood.getName().trim())){
                return true;
            }
        }
        return false;
    }

    public boolean doesAssessmentExist(String assessmentClass){
        for (PropertyAssessment property : assessmentList){

            AssessmentClass assessment = property.getAssessment();

            if (Objects.equals(assessment.getAssessmentClass1(), assessmentClass.toLowerCase()) ||
                    Objects.equals(assessment.getAssessmentClass2(), assessmentClass.toLowerCase()) ||
                    Objects.equals(assessment.getAssessmentClass3(), assessmentClass.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    public int getAssessmentAmount(String assessmentClass){
        int count = 0;
        for (PropertyAssessment property : assessmentList)  {
            AssessmentClass assessment = property.getAssessment();

            if (Objects.equals(assessment.getAssessmentClass1(), assessmentClass.toLowerCase()) ||
                    Objects.equals(assessment.getAssessmentClass2(), assessmentClass.toLowerCase()) ||
                    Objects.equals(assessment.getAssessmentClass3(), assessmentClass.toLowerCase())) {
                count++;
            }
        }

        return count;
    }


    public int getRecordAmount()
    {
        return assessmentList.toArray().length;
    }

    public int getRecordAmount(String neighbourhood)
    {
        int count = 0;
        for (PropertyAssessment property : assessmentList){
            Neighbourhood currentHood = property.getNeighbourhood();
            if (neighbourhood.trim().equalsIgnoreCase(currentHood.getName().trim()))
            {
                count++;
            }
        }
        return count;
    }


    public double getLowestValue()
    {

        int lowest = 0;
        int i = 0;
        while (lowest == 0){
            lowest = assessmentList.get(i).getValue();
            i++;
        }
        for (PropertyAssessment index : assessmentList) {
            int value = index.getValue();
            if (value < lowest && value != 0) {
                lowest = value;
            }
        }
        return lowest;
    }

    public double getLowestValue(String neighbourhood)
    {
        int lowest = 0;
        int i = 0;
        while (lowest == 0){
            lowest = assessmentList.get(i).getValue();
            i++;
        }
        for (PropertyAssessment property : assessmentList) {
            Neighbourhood currentHood = property.getNeighbourhood();
            if (neighbourhood.trim().equalsIgnoreCase(currentHood.getName().trim()))
            {
                int value = property.getValue();
                if (value < lowest && value != 0) {
                    lowest = value;
                }
            }

        }
        return lowest;
    }
    public double getLowestAssessment(String assessmentClass)
    {
        int lowest = 0;
        int i = 0;
        while (lowest == 0){
            lowest = assessmentList.get(i).getValue();
            i++;
        }
        for (PropertyAssessment property : assessmentList) {
            AssessmentClass assessment = property.getAssessment();
            if (Objects.equals(assessment.getAssessmentClass1(), assessmentClass.toLowerCase()) ||
                    Objects.equals(assessment.getAssessmentClass2(), assessmentClass.toLowerCase()) ||
                    Objects.equals(assessment.getAssessmentClass3(), assessmentClass.toLowerCase())) {
                int value = property.getValue();
                if (value < lowest) {
                    lowest = value;
                }
            }

        }
        return lowest;
    }

    public double getHighestValue()
    {
        int highest = assessmentList.get(0).getValue();
        for (PropertyAssessment property : assessmentList) {
            int value = property.getValue();
            if (value > highest) {
                highest = value;
            }
        }
        return highest;
    }

    public double getHighestValue(String neighbourhood)
    {
        int highest = assessmentList.get(0).getValue();
        for (PropertyAssessment property : assessmentList) {
            Neighbourhood currentHood = property.getNeighbourhood();
            if (neighbourhood.trim().equalsIgnoreCase(currentHood.getName().trim())) {

                int value = property.getValue();
                if (value > highest) {
                    highest = value;
                }
            }
        }
        return highest;
    }

    public double getHighestAssessment(String assessmentClass){
        int highest = assessmentList.get(0).getValue();
        for (PropertyAssessment property : assessmentList) {
            AssessmentClass assessment = property.getAssessment();
            if (Objects.equals(assessment.getAssessmentClass1(), assessmentClass.toLowerCase()) ||
                    Objects.equals(assessment.getAssessmentClass2(), assessmentClass.toLowerCase()) ||
                    Objects.equals(assessment.getAssessmentClass3(), assessmentClass.toLowerCase())) {

                int value = property.getValue();
                if (value > highest) {
                    highest = value;
                }
            }
        }
        return highest;
    }

    public double getRange()
    {
        return getHighestValue();
    }

    public double getRange(String neighbourhood)
    {

        return getHighestValue(neighbourhood);
    }

    public double getMean()
    {
        double totalValue = 0;
        for (PropertyAssessment property : assessmentList)
        {
            if(property.getValue() > 0)
                totalValue += property.getValue();
        }
        return totalValue / assessmentList.toArray().length;
    }

    public double getMean(String neighbourhood)
    {
        List<PropertyAssessment> tempList = new ArrayList<>();
        double totalValue = 0;
        for (PropertyAssessment property : assessmentList)
        {
            Neighbourhood currentHood = property.getNeighbourhood();
            if (neighbourhood.trim().equalsIgnoreCase(currentHood.getName().trim()))
            {
                tempList.add(property);
                if(property.getValue() > 0)
                    totalValue += property.getValue();
            }
        }
        return totalValue / tempList.toArray().length;
    }


    public double getMedian(){
        Collections.sort(assessmentList);
        int length = assessmentList.size();
        double median;
        if (length % 2 == 0){
            median = ((double)assessmentList.get(length/2).getValue() + (double)assessmentList.get(length/2 - 1).getValue())/2;
        } else {
            median = ((double)assessmentList.get(length/2).getValue());
        }
        return median;
    }

    public double getMedian(String neighbourhood){
        List<PropertyAssessment> tempAssessments = new ArrayList<>();
        for (PropertyAssessment propertyAssessment : assessmentList) {
            Neighbourhood currentHood = propertyAssessment.getNeighbourhood();
            if (neighbourhood.trim().equalsIgnoreCase(currentHood.getName().trim())) {
                tempAssessments.add(propertyAssessment);
            }
        }
        Collections.sort(tempAssessments);
        int length = tempAssessments.size();
        double median;
        if (length % 2 == 0){
            median = ((double)tempAssessments.get(length/2).getValue() + (double)tempAssessments.get(length/2 - 1).getValue())/2;
        } else {
            median = ((double)tempAssessments.get(length/2).getValue());
        }
        return median;
    }


    private static String[][] readData(String csvFileName) throws IOException {
        String[][] data = new String[0][];
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
        } catch (IOException e) {
            System.out.println("Error: can't open file " + csvFileName);
            System.exit(1);

        }

        // Remove empty rows in the array and return it
        return Arrays.copyOf(data, currentIndex);
    }

    @Override
    public String toString(){
        return assessmentList.toString();
    }

    @Override
    public int hashCode(){
        return Objects.hash(assessmentList);
    }

    @Override
    public boolean equals(Object other){
        if (other == null) return false;
        if (other == this) return true;
        if (!(other instanceof PropertyAssessments propertyAssessmentsOther)) return false;
        return false;
    }






}
