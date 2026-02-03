package org.lab3;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.Scanner;

public class Lab3Main {
    public static void main(String[] args) throws IOException {
        Scanner reader = new Scanner(System.in);

        System.out.print("CSV filename: ");
        String filename = reader.next();
        PropertyAssessments assessments = new PropertyAssessments(filename);

        System.out.print("\nPlease enter a neighbourhood name: ");
        String neighbourhood = reader.next();
        neighbourhoodStats(assessments, neighbourhood);

        System.out.print("\nPlease enter an assessment class: ");
        String assessment = reader.next();
        assessmentStats(assessments, assessment);

        reader.close();
    }

    public static void neighbourhoodStats(PropertyAssessments assessments, String neighbourhood){
        if (!assessments.doesNeighbourhoodExist(neighbourhood)){
            System.out.println("Neighbourhood is not found");
            return;
        }
        int n = assessments.getRecordAmount(neighbourhood);
        double mean = assessments.getMean(neighbourhood);
        double median = assessments.getMedian(neighbourhood);

        System.out.println("There are " + n + " properties in " + neighbourhood);
        System.out.println("The mean value is " + turnToMoney(mean));
        System.out.println("The median value is " + turnToMoney(median));

    }

    public static void assessmentStats(PropertyAssessments assessments, String assessment){
        if (!assessments.doesAssessmentExist(assessment)){
            System.out.println("Sorry, can't find " + assessment + " properties");
            return;
        }
        int n = assessments.getAssessmentAmount(assessment);
        double min = assessments.getLowestAssessment(assessment);
        double max = assessments.getHighestAssessment(assessment);

        System.out.println("There are " + n + " " + assessment + " properties in Edmonton"); //fix hardcoding of city?
        System.out.println("The min value is " + turnToMoney(min));
        System.out.println("The max value is " + turnToMoney(max));


    }


    public static String turnToMoney(double value){
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
        return currencyFormat.format(value);
    }

}