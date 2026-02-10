package org.lab4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class PropertyAssessmentsTest {

    private PropertyAssessments propertyAssessments1;
    private PropertyAssessments propertyAssessments2;
    private PropertyAssessments propertyAssessments1copy;

    private String[] arr = {"1273614", null, "14348", "115 AVENUE NW", "3230", "HUFF BREMNER ESTATE INDUSTRIAL", "Anirniq", "10500"
            , "Non Residential", "N", "COMMERCIAL", null, null, "100", null, null, "53.56559302", "-113.5692501", "POINT (-113.56925014047397 53.56559301761956)"};

    @BeforeEach
    void setUp() throws IOException {
        propertyAssessments1 = new PropertyAssessments("Property_Assessment_Data_2025.csv");
        propertyAssessments2 = new PropertyAssessments("Property_Assessment_Data_2025_Small.csv");
        propertyAssessments1copy = new PropertyAssessments("Property_Assessment_Data_2025.csv");
    }


    @Test
    void throw_IOException_FileError(){
        assertThrows(IOException.class, () -> new PropertyAssessments("whatever.csv"));
    }

    @Test
    void getPropertyAssessment() throws NumberFormatException {
        PropertyAssessment temp = new PropertyAssessment(arr);
        assertEquals(propertyAssessments2.getPropertyAssessment("1273614"), temp);
        assertNotEquals(propertyAssessments1.getPropertyAssessment("124"), temp);
        assertNull(propertyAssessments1.getPropertyAssessment("123"));
        assertThrows(NumberFormatException.class, () -> propertyAssessments1.getPropertyAssessment(null));
        assertThrows(NumberFormatException.class, () -> propertyAssessments1.getPropertyAssessment("abc"));

    }

    @Test
    void doesNeighbourhoodExist() {
        PropertyAssessments temp = propertyAssessments1.doesNeighbourhoodExist("HUFF BREMNER ESTATE INDUSTRIAL");
        PropertyAssessments temp2 = propertyAssessments1.doesNeighbourhoodExist("WINDERMERE");
        assertNull(propertyAssessments1.doesNeighbourhoodExist("123"));
        assertEquals(temp.hashCode(), propertyAssessments1.doesNeighbourhoodExist("HUFF BREMNER ESTATE INDUSTRIAL").hashCode());
        assertNotEquals(temp2, propertyAssessments1.doesNeighbourhoodExist("HUFF BREMNER ESTATE INDUSTRIAL"));
    }

    @Test
    void doesAssessmentExist() {
        PropertyAssessments temp = propertyAssessments1.doesAssessmentExist("RESIDENTIAL");
        PropertyAssessments temp2 = propertyAssessments1.doesAssessmentExist("COMMERCIAL");
        assertNull(propertyAssessments1.doesAssessmentExist("123"));
        assertEquals(temp.hashCode(), propertyAssessments1.doesAssessmentExist("RESIDENTIAL").hashCode());
        assertNotEquals(temp2, propertyAssessments1.doesAssessmentExist("RESIDENTIAL"));
    }

    @Test
    void getRecordAmount() {
        assertEquals(431706, propertyAssessments1.getRecordAmount());
        assertNotEquals(431706, propertyAssessments2.getRecordAmount());
    }

    @Test
    void getLowestValue() {
        assertEquals(500, propertyAssessments1.getLowestValue());
        assertNotEquals(0, propertyAssessments1.getLowestValue());
    }

    @Test
    void getHighestValue() {
        assertEquals(19712500, propertyAssessments2.getHighestValue());
        assertNotEquals(0, propertyAssessments2.getHighestValue());

    }

    @Test
    void getRange() {
        assertEquals(19712500, propertyAssessments2.getRange());
        assertNotEquals(0, propertyAssessments2.getRange());
    }

    @Test
    void getMean() {
        assertEquals(1055839, propertyAssessments2.getMean());
        assertNotEquals(0, propertyAssessments2.getMean());
    }

    @Test
    void getMedian() {
        assertEquals(404250, propertyAssessments2.getMedian());
        assertNotEquals(0, propertyAssessments2.getMedian());
    }

    @Test
    void testToString() {
        assertEquals(propertyAssessments1.toString(), propertyAssessments1copy.toString()); //don't really know how id do this
        assertNotEquals(propertyAssessments1.toString(), propertyAssessments2.toString());
    }

    @Test
    void testHashCode() {
        assertEquals(propertyAssessments1.hashCode(), propertyAssessments1copy.hashCode());
        assertNotEquals(propertyAssessments1.hashCode(), propertyAssessments2.hashCode());
    }

    @Test
    void testEquals() {
        assertEquals(propertyAssessments1, propertyAssessments1);
        assertFalse(propertyAssessments1.equals(null));

        assertEquals(propertyAssessments1.equals(propertyAssessments1copy), propertyAssessments1copy.equals(propertyAssessments1));

        assertEquals(propertyAssessments1.equals(propertyAssessments2), propertyAssessments2.equals(propertyAssessments1));
    }
}