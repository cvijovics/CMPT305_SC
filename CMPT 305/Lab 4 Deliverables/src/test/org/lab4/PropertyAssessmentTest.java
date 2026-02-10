package org.lab4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class PropertyAssessmentTest {
    private PropertyAssessment property1;
    private PropertyAssessment property2;
    private PropertyAssessment property1copy;

    private String[] arr1 = {"1273614", null, "14348", "115 AVENUE NW", "3230", "HUFF BREMNER ESTATE INDUSTRIAL", "Anirniq", "10500"
            , "Non Residential", "N", "COMMERCIAL", null, null, "100", null, null, "53.56559302", "-113.5692501", "POINT (-113.56925014047397 53.56559301761956)"};

    private String[] arr2 = {"123", "321", "222", "115 Street NW", "555", "WINDING", "NO", "33333"
            , "YEA", "N", "NOPE", null, null, "100", null, null, "53.56559302", "-113.5692501", "POINT (-113.56925014047397 53.56559301761956)"};

    @BeforeEach
    void setUp() {
        property1 = new PropertyAssessment(arr1);
        property2 = new PropertyAssessment(arr2);
        property1copy = new PropertyAssessment(arr1);
    }

    @Test
    void getValue() {
        assertEquals(10500, property1.getValue());
        assertNotEquals(10500, property2.getValue());
    }

    @Test
    void getAccountNum() {
        assertEquals(1273614, property1.getAccountNum());
        assertNotEquals(1273614, property2.getAccountNum());
    }

    @Test
    void getAddress() {
        String[] tempArr1 = {null, null, "14348", "115 AVENUE NW"};
        String[] tempArr2 = {null, null, "123", "115 AVENUE NW"};
        Address temp1 = new Address(tempArr1);
        Address temp2 = new Address(tempArr2);
        assertEquals(temp1, property1.getAddress());
        assertNotEquals(temp2, property1.getAddress());

    }

    @Test
    void getHasGarage() {
        assertFalse(property1.getHasGarage());
    }

    @Test
    void getAssessment() {
        String[] tempArr1 = {null, null, null, null, null, null, null, null, null, null, "COMMERCIAL", null, null, "100", null, null};
        String[] tempArr2 = {null, null, null, null, null, null, null, null, null, null, "COMMERCIAL", "RESIDENTIAL", "RECREATIONAL", "50", "25", "25"};
        AssessmentClass temp1 = new AssessmentClass(tempArr1);
        AssessmentClass temp2 = new AssessmentClass(tempArr2);
        assertEquals(temp1, property1.getAssessment());
        assertNotEquals(temp2, property1.getAssessment());

    }

    @Test
    void getGeolocation() {
        String[] tempArr1 = {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, "53.56559302", "-113.5692501"}; //this needs refactoring later, in PropertyAssessment
        String[] tempArr2 = {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, "30.12331", "50.123431"};
        GeoLocation temp1 = new GeoLocation(tempArr1);
        GeoLocation temp2 = new GeoLocation(tempArr2);
        assertEquals(temp1, property1.getGeolocation());
        assertNotEquals(temp2, property1.getGeolocation());
    }

    @Test
    void getTaxClass() {
        assertEquals("Non Residential", property1.getTaxClass());
        assertNotEquals("Non Residential", property2.getTaxClass());
    }

    @Test
    void getNeighbourhood() {
        String[] tempArr1 = {null, null, null, null, "3230", "HUFF BREMNER ESTATE INDUSTRIAL", "Anirniq"};
        String[] tempArr2 = {null, null, null, null, null, "WINDERMERE", null};
        Neighbourhood temp1 = new Neighbourhood(tempArr1);
        Neighbourhood temp2 = new Neighbourhood(tempArr2);
        assertEquals(temp1.getId(), property1.getNeighbourhood().getId());
        assertNotEquals(temp2.getId(), property1.getNeighbourhood().getId());
    }

    @Test
    void testToString() {
        assertEquals("Account Number: 1273614", property1.toString());
        assertNotEquals("Account Number: 1273614", property2.toString());
    }

    @Test
    void testHashCode() {
        assertEquals(property1.hashCode(), property1copy.hashCode());
        assertNotEquals(property1.hashCode(), property2.hashCode());
    }

    @Test
    void compareTo() {
        assertTrue(property1.compareTo(property2) < 0);
        assertTrue(property2.compareTo(property1) > 0);
        assertEquals(0, property1.compareTo(property1copy));
    }

    @Test
    void testEquals() {
        assertEquals(property1, property1);
        assertFalse(property1.equals(null));

        assertEquals(property1.equals(property1copy), property1copy.equals(property1));

        assertEquals(property1.equals(property2), property2.equals(property1));
    }
}