package com.mycompany.app;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }

   public void testIntegrity() {
        String[] sArray = {"BIL481", "YAZILIM MUHENDISLIGI", null, "Hello world!"};
		int[] arr1 = {43, 324, 435, 32, 6, 321535, 34};
		int[] arr2 = {542, 0, 0, 4351};
		int key0 = 7;
        String[] testString = App.encrypt(arr1, arr2, sArray, key0);
        
        assertEquals(testString[0], "QUVJLI");
        assertEquals(testString[1], "]Q]UVUW@W[TSWRUZVUTU");
        assertEquals(testString[2], null);
        assertEquals(testString[3], "Tcffh@lhifbA");
    }

    public void testNullStrings() {
        String[] sArray = {null, null, null};
		int[] arr1 = {43, 324, 435, 32, 6, 321535, 34};
		int[] arr2 = {542, 0, 0, 4351};
		int key0 = 7;
        String[] testString = App.encrypt(arr1, arr2, sArray, key0);

        assertEquals(testString[0], null);
        assertEquals(testString[1], null);
        assertEquals(testString[2], null);
    }

    public void testZeroKey() {
        String[] sArray = {"Onur", "Demirezen", "TOBB ETU"};
		int[] arr1 = {0};
		int[] arr2 = {0};
		int key0 = 0;
        String[] testString = App.encrypt(arr1, arr2, sArray, key0);

        assertEquals(testString[0], "Onur");
        assertEquals(testString[1], "Demirezen");
        assertEquals(testString[2], "TOBB ETU");
    }

    public void testOneLength() {
        String[] sArray = {"B", "Y", "!", "7"};
		int[] arr1 = {43, 324, 435, 32, 6, 321535, 34};
		int[] arr2 = {542, 0, 0, 4351};
		int key0 = 7;
        String[] testString = App.encrypt(arr1, arr2, sArray, key0);

        assertEquals(testString[0], "Q");
        assertEquals(testString[1], "]");
        assertEquals(testString[2], "A");
        assertEquals(testString[3], "L");
    }

    public void testSameInput() {
        String[] sArray = {"Demirezen", "Demirezen"};
		int[] arr1 = {43, 324, 435, 32, 6, 321535, 34};
		int[] arr2 = {542, 0, 0, 4351};
		int key0 = 7;
        String[] testString = App.encrypt(arr1, arr2, sArray, key0);
        
        assertTrue(testString[0].equals(testString[1]));
    }
}
