package com.mycompany.app;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import java.util.*;

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
        ArrayList<String> sList = new ArrayList<>();
        sList.add("BIL481");
        sList.add("YAZILIM MUHENDISLIGI");
        sList.add(null);
        sList.add("Hello world!");

        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(43);
        list1.add(324);
        list1.add(435);
        list1.add(32);
        list1.add(6);
        list1.add(321535);
        list1.add(34);

        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(542);
        list2.add(0);
        list2.add(0);
        list2.add(4351);

		int key0 = 7;
        
        String[] testString = App.encrypt(list1, list2, sList, key0);
        
        assertEquals(testString[0], "QUVJLI");
        assertEquals(testString[1], "]Q]UVUW@W[TSWRUZVUTU");
        assertEquals(testString[2], null);
        assertEquals(testString[3], "Tcffh@lhifbA");
    }

    public void testNullStrings() {
        ArrayList<String> sList = new ArrayList<>();
        sList.add(null);
        sList.add(null);
        sList.add(null);
        sList.add(null);

		ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(43);
        list1.add(324);
        list1.add(435);
        list1.add(32);
        list1.add(6);
        list1.add(321535);
        list1.add(34);

		ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(542);
        list2.add(0);
        list2.add(0);
        list2.add(4351);

		int key0 = 7;
        
        String[] testString = App.encrypt(list1, list2, sList, key0);

        assertEquals(testString[0], null);
        assertEquals(testString[1], null);
        assertEquals(testString[2], null);
    }

    public void testZeroKey() {
        ArrayList<String> sList = new ArrayList<>();
        sList.add("Onur");
        sList.add("Demirezen");
        sList.add("TOBB ETU");

        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(0);

        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(0);
        
        int key0 = 0;
        
        String[] testString = App.encrypt(list1, list2, sList, key0);

        assertEquals(testString[0], "Onur");
        assertEquals(testString[1], "Demirezen");
        assertEquals(testString[2], "TOBB ETU");
    }

    public void testOneLength() {
        ArrayList<String> sList = new ArrayList<>();
        sList.add("B");
        sList.add("Y");
        sList.add("!");
        sList.add("7");

		ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(43);
        list1.add(324);
        list1.add(435);
        list1.add(32);
        list1.add(6);
        list1.add(321535);
        list1.add(34);

		ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(542);
        list2.add(0);
        list2.add(0);
        list2.add(4351);

        int key0 = 7;
        
        String[] testString = App.encrypt(list1, list2, sList, key0);

        assertEquals(testString[0], "Q");
        assertEquals(testString[1], "]");
        assertEquals(testString[2], "A");
        assertEquals(testString[3], "L");
    }

    public void testSameInput() {
        ArrayList<String> sList = new ArrayList<>();
        sList.add("Demirezen");
        sList.add("Demirezen");

		ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(43);
        list1.add(324);
        list1.add(435);
        list1.add(32);
        list1.add(6);
        list1.add(321535);
        list1.add(34);

		ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(542);
        list2.add(0);
        list2.add(0);
        list2.add(4351);

        int key0 = 7;
        
        String[] testString = App.encrypt(list1, list2, sList, key0);
        
        assertTrue(testString[0].equals(testString[1]));
    }
}
