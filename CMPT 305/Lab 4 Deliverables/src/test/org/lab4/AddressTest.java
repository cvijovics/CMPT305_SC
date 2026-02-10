package org.lab4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

class AddressTest {
    private Address address1;
    private Address address2;
    private Address address3;
    private Address address1copy;
    private String[] arr1 = {null, "101E", "1011", "Ale Blv"};
    private String[] arr2 = {null, null, null, "House Blv"};
    private String[] arr3 = {null, null, "1001", "House Str"};

    @BeforeEach
    void setUp() {
        address1 = new Address(arr1);
        address2 = new Address(arr2);
        address3 = new Address(arr3);
        address1copy = new Address(arr1);
    }

    @Test
    void getHouseNum() {
        assertEquals(1011, address1.getHouseNum());
        assertNotEquals(1011, address2.getHouseNum());
        assertNull(address2.getHouseNum());
    }

    @Test
    void getStreetName() {
        assertEquals("Ale Blv", address1.getStreetName());
        assertNotEquals("Ale Blv", address2.getStreetName());
    }

    @Test
    void getSuite() {
        assertEquals("101E", address1.getSuite());
        assertNotEquals("101E", address2.getSuite());
    }

    @Test
    void testToString() {
        assertEquals("101E 1011 Ale Blv", address1.toString());
        assertEquals("House Blv", address2.toString());
        assertNotEquals("101E 1011 Ale Blv", address2.toString());
        assertEquals("1001 House Str", address3.toString());
    }

    @Test
    void testHashCode() {
        assertEquals(address1.hashCode(), address1copy.hashCode());
        assertNotEquals(address1.hashCode(), address2.hashCode());
    }

    @Test
    void testEquals() {
        assertEquals(address1, address1);
        assertFalse(address1.equals(null));
        assertFalse(address1.equals(address3));
        assertEquals(address1.equals(address1copy), address1copy.equals(address1));

        assertEquals(address1.equals(address2), address2.equals(address1));
        assertNotSame(null, address1);
        assertNotNull(address1);

    }
}