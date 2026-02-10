package org.lab4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GeoLocationTest {

    private GeoLocation location1;
    private GeoLocation location2;
    private GeoLocation location1copy;

    private String[] arr1 = {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, "58.12312", "-43.123132"}; //this needs refactoring later, in PropertyAssessment
    private String[] arr2 = {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, "30.12331", "50.123431"};

    @BeforeEach
    void setUp() {
        location1 = new GeoLocation(arr1);
        location2 = new GeoLocation(arr2);
        location1copy = new GeoLocation(arr1);
    }

    @Test
    void getLatitude() {
        assertEquals(58.12312, location1.getLatitude());
        assertEquals(30.12331, location2.getLatitude());
        assertNotEquals(30.12331, location1.getLatitude());
    }

    @Test
    void getLongitude() {
        assertEquals(-43.123132, location1.getLongitude());
        assertEquals(50.123431, location2.getLongitude());
        assertNotEquals(50.123431, location1.getLongitude());
    }

    @Test
    void testToString() {
        assertEquals("(58.12312, -43.123132)", location1.toString());
    }

    @Test
    void testHashCode() {
        assertEquals(location1.hashCode(), location1copy.hashCode());
        assertNotEquals(location1.hashCode(), location2.hashCode());
    }

    @Test
    void testEquals() {
        assertFalse(location1.equals(null));
        assertEquals(location1, location1);

        assertEquals(location1.equals(location1copy), location1copy.equals(location1));

        assertEquals(location1.equals(location2), location2.equals(location1));
    }
}