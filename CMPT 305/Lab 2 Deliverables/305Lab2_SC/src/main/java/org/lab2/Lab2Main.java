package lab2;
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
        double min = assessments.getLowestValue();
        double max = assessments.getHighestValue();
        double range = assessments.getRange();
        double mean = assessments.getMean();
        double median = assessments.getMedian();
        System.out.println("Descriptive statistics of all property assessments\n" +
                "n = " + n + "\n" +
                "min = " + turnToMoney(min) + "\n" +
                "max = " + turnToMoney(max) + "\n" +
                "range = " + turnToMoney(range) + "\n" +
                "mean = " + turnToMoney(mean) + "\n" +
                "median = " + turnToMoney(median));
    }

    public static void accountNumStats(PropertyAssessments assessments, String accountNum) {
        PropertyAssessment property = assessments.getPropertyAssessment(accountNum);
        if (property == null)
        {
            return;
        }

        System.out.println("Account number = " + property.getAccountNum() + "\n" +
                "Address = " + property.getAddress() + "\n" +
                "Assessed Value = " + turnToMoney(property.getValue()) + "\n" +
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
        double min = assessments.getLowestValue(neighbourhood);
        double max = assessments.getHighestValue(neighbourhood);
        double range = assessments.getRange(neighbourhood);
        double mean = assessments.getMean(neighbourhood);
        double median = assessments.getMedian(neighbourhood);
        System.out.println("Statistics (neighbourhood = " + neighbourhood + ")\n" +
                "n = " + n + "\n" +
                "min = " + turnToMoney(min) + "\n" +
                "max = " + turnToMoney(max) + "\n" +
                "range = " + turnToMoney(range) + "\n" +
                "mean = " + turnToMoney(mean) + "\n" +
                "median = " + turnToMoney(median));

    }

    public static String turnToMoney(double value){
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
        return currencyFormat.format(value);
    }

}