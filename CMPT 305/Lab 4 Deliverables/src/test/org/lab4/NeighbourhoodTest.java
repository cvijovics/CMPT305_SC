package org.lab4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NeighbourhoodTest {

    private Neighbourhood hood1;
    private Neighbourhood hood2;
    private Neighbourhood hood3;
    private Neighbourhood hood1copy;

    private String[] arr1 = {null, null, null, null, "2230", "SPRUCE", "NOPE"};
    private String[] arr2 = {null, null, null, null, null, "WINDERMERE", null};
    private String[] arr3 = {null, null, null, null, null, "WINDERMERE", ""};

    @BeforeEach
    void setUp(){
        hood1 = new Neighbourhood(arr1);
        hood2 = new Neighbourhood(arr2);
        hood3 = new Neighbourhood(arr3);
        hood1copy = new Neighbourhood(arr1);
    }

    @Test
    void getName() {
        assertEquals("SPRUCE", hood1.getName());
        assertNotEquals("WINDERMERE", hood1.getName());
    }

    @Test
    void getId() {
        assertEquals(2230, hood1.getId());
        assertNull(hood2.getId());
        assertNotEquals(2230, hood2.getId());
    }

    @Test
    void getWard() {
        assertEquals("NOPE", hood1.getWard());
        assertNotEquals("NOPE", hood2.getWard());
        assertNull(hood2.getWard());
    }

    @Test
    void testToString() {
        assertEquals("SPRUCE (NOPE Ward)", hood1.toString());
        assertEquals("WINDERMERE", hood2.toString());
        assertEquals("WINDERMERE", hood3.toString());
    }

    @Test
    void testHashCode() {
        assertEquals(hood1.hashCode(), hood1copy.hashCode());
        assertNotEquals(hood1.hashCode(), hood2.hashCode());
    }

    @Test
    void testEquals() {
        assertEquals(hood1, hood1);
        assertFalse(hood1.equals(null));

        assertEquals(hood1.equals(hood1copy), hood1copy.equals(hood1));

        assertEquals(hood1.equals(hood2), hood2.equals(hood1));
    }
}