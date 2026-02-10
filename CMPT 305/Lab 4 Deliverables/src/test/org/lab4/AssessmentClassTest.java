package org.lab4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AssessmentClassTest {
    private AssessmentClass assessment1;
    private AssessmentClass assessment2;
    private AssessmentClass assessment3;
    private AssessmentClass assessment4;
    private AssessmentClass assessment5;
    private AssessmentClass assessment6;
    private AssessmentClass assessment1copy;

    private String[] arr1 = {null, null, null, null, null, null, null, null, null, null, "RESIDENTIAL", null, null, "100", null, null};
    private String[] arr2 = {null, null, null, null, null, null, null, null, null, null, "COMMERCIAL", "RESIDENTIAL", "RECREATIONAL", "50", "25", "25"};
    private String[] arr3 = {null, null, null, null, null, null, null, null, null, null, "COMMERCIAL", "RESIDENTIAL", "RECREATIONAL", "50", "50", null};
    private String[] arr4 = {null, null, null, null, null, null, null, null, null, null, "COMMERCIAL", "RESIDENTIAL", "RECREATIONAL", "55", "25", "20"};
    private String[] arr5 = {null, null, null, null, null, null, null, null, null, null, "COMMERCIAL", "RESIDENTIAL", "RECREATIONAL", "40", "40", "20"};
    private String[] arr6 = {null, null, null, null, null, null, null, null, null, null, "YUP", "RESIDENTIAL", "RECREATIONAL", "40", "40", "20"};


    @BeforeEach
    void setUp() {
        assessment1 = new AssessmentClass(arr1);
        assessment2 = new AssessmentClass(arr2);
        assessment3 = new AssessmentClass(arr3);
        assessment4 = new AssessmentClass(arr4);
        assessment5 = new AssessmentClass(arr5);
        assessment6 = new AssessmentClass(arr6);
        assessment1copy = new AssessmentClass(arr1);
    }

    @Test
    void getAssessmentClass1() {
        assertEquals("residential", assessment1.getAssessmentClass1());
        assertNotEquals("residential", assessment2.getAssessmentClass1());
    }

    @Test
    void getAssessmentClass1Percent() {
        assertEquals(100, assessment1.getAssessmentClass1Percent());
        assertNotEquals(100, assessment2.getAssessmentClass1Percent());
        assertEquals(50, assessment2.getAssessmentClass1Percent());
    }

    @Test
    void getAssessmentClass2() {
        assertNull(assessment1.getAssessmentClass2());
        assertNotEquals("residential", assessment1.getAssessmentClass2());
        assertEquals("residential", assessment2.getAssessmentClass2());
    }

    @Test
    void getAssessmentClass2Percent() {
        assertNull(assessment1.getAssessmentClass2Percent());
        assertEquals(25, assessment2.getAssessmentClass2Percent());
        assertNotEquals(50, assessment1.getAssessmentClass2Percent());
    }

    @Test
    void getAssessmentClass3Percent() {
        assertNull(assessment1.getAssessmentClass3Percent());
        assertEquals(25, assessment2.getAssessmentClass3Percent());
        assertNotEquals(25, assessment1.getAssessmentClass3Percent());
    }

    @Test
    void getAssessmentClass3() {
        assertNull(assessment1.getAssessmentClass3());
        assertEquals("recreational", assessment2.getAssessmentClass3());
        assertNotEquals("recreational", assessment1.getAssessmentClass3());
    }

    @Test
    void testToString() {
        assertEquals("[residential 100%]", assessment1.toString());
        assertEquals("[commercial 50%, residential 25%, recreational 25%]", assessment2.toString());
        assertEquals("[commercial 50%, residential 50%]", assessment3.toString());
    }

    @Test
    void testHashCode() {
        assertEquals(assessment1.hashCode(), assessment1copy.hashCode());
        assertNotEquals(assessment1.hashCode(), assessment2.hashCode());
    }

    @Test
    void testEquals() {
        assertEquals(assessment1, assessment1);
        assertFalse(assessment1.equals(null));

        assertEquals(assessment4.equals(assessment5), assessment5.equals(assessment4));
        assertEquals(assessment2.equals(assessment4), assessment4.equals(assessment2));
        assertEquals(assessment1.equals(assessment1copy), assessment1copy.equals(assessment1));
        assertEquals(assessment5.equals(assessment6), assessment6.equals(assessment5));

        assertEquals(assessment1.equals(assessment2), assessment2.equals(assessment1));
        assertEquals(assessment1.equals(assessment3), assessment3.equals(assessment1));
    }
}