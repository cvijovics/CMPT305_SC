package org.lab3;
import java.text.NumberFormat;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class Lab2Main {
    public static void main(String[] args) throws IOException {
        Scanner reader = new Scanner(System.in);

        System.out.print("CSV filename: ");
        String filename = reader.next();
        PropertyAssessments assessments = new PropertyAssessments(filename);
        overall(assessments);

        System.out.print("\nFind a property assessment by account number: ");
        String accountNum = reader.next();
        accountNumStats(assessments, accountNum);

        System.out.print("\nFind statistics by neighbourhood: ");
        String neighbourhood = reader.next();
        neighbourhoodStats(assessments, neighbourhood);


        reader.close();
    }

    public static void overall(PropertyAssessments assessments) {

        int n = assessments.getRecordAmount();

        int min = (int) assessments.getLowestValue();
        String formatted_min = String.format("%,d", min);

        int max = (int) assessments.getHighestValue();
        String formatted_max = String.format("%,d", max);

        int range = (int) assessments.getRange();
        String formatted_range = String.format("%,d", range);

        int mean = (int) assessments.getMean();
        String formatted_mean = String.format("%,d", mean);

        int median = (int) assessments.getMedian();
        String formatted_median = String.format("%,d", median);

        System.out.println("Descriptive statistics of all property assessments\n" +
                "n = " + n + "\n" +
                "min = $" + formatted_min + "\n" +
                "max = $" + formatted_max + "\n" +
                "range = $" + formatted_range + "\n" +
                "mean = $" + formatted_mean + "\n" +
                "median = $" + formatted_median);
    }

    public static void accountNumStats(PropertyAssessments assessments, String accountNum) {
        PropertyAssessment property = assessments.getPropertyAssessment(accountNum);
        if (property == null)
        {
            return;
        }

        int value = property.getValue();
        String formatted_value = String.format("%,d", value);

        System.out.println("Account number = " + property.getAccountNum() + "\n" +
                "Address = " + property.getAddress() + "\n" +
                "Assessed Value = " +  formatted_value + "\n" +
                "Assessment Class = " + property.getAssessment() + "\n" +
                "Neighbourhood = " + property.getNeighbourhood() + "\n" +
                "Location = " + property.getGeolocation() + "\n");
    }

    public static void neighbourhoodStats(PropertyAssessments assessments, String neighbourhood) {
        if (!assessments.doesNeighbourhoodExist(neighbourhood)){
            System.out.println("Neighbourhood is not found");
            return;
        }

        int n = assessments.getRecordAmount(neighbourhood);
        String formatted_n = String.format("%,d", n);

        int min = (int) assessments.getLowestValue(neighbourhood);
        String formatted_min = String.format("%,d", min);


        int max = (int) assessments.getHighestValue(neighbourhood);
        String formatted_max = String.format("%,d", max);


        int range = (int) assessments.getRange(neighbourhood);
        String formatted_range = String.format("%,d", range);


        int mean = (int) assessments.getMean(neighbourhood);
        String formatted_mean = String.format("%,d", mean);

        int median = (int) assessments.getMedian(neighbourhood);
        String formatted_median = String.format("%,d", median);


        System.out.println("Statistics (neighbourhood = " + neighbourhood + ")\n" +
                "n = " + formatted_n + "\n" +
                "min = $" + formatted_min + "\n" +
                "max = $" + formatted_max + "\n" +
                "range = $" + formatted_range + "\n" +
                "mean = $" + formatted_mean + "\n" +
                "median = $" + formatted_median);

    }


}