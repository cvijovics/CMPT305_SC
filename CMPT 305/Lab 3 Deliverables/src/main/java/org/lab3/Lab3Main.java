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
        String formatted_n = String.format("%,d", n);

        int mean = (int) assessments.getMean(neighbourhood);
        String formatted_mean = String.format("%,d", mean);

        int median = (int) assessments.getMedian(neighbourhood);
        String formatted_median = String.format("%,d", median);

        System.out.println("There are " + formatted_n + " properties in " + neighbourhood);
        System.out.println("The mean value is CAD " + formatted_mean);
        System.out.println("The median value is CAD " + formatted_median);

    }

    public static void assessmentStats(PropertyAssessments assessments, String assessment){
        if (!assessments.doesAssessmentExist(assessment)){
            System.out.println("Sorry, can't find " + assessment + " properties");
            return;
        }
        int n = assessments.getAssessmentAmount(assessment);
        String formatted_n = String.format("%,d", n);

        int min = (int)assessments.getLowestAssessment(assessment);
        String formatted_min = String.format("%,d", min);

        int max = (int) assessments.getHighestAssessment(assessment);
        String formatted_max = String.format("%,d", max);

        System.out.println("There are " + formatted_n + " " + assessment + " properties in Edmonton"); //fix hardcoding of city?
        System.out.println("The min value is CAD " + formatted_min);
        System.out.println("The max value is CAD " + formatted_max);


    }




}