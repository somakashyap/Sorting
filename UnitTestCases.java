/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package unitTesting;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runners.Parameterized;
import org.junit.runner.RunWith;
import org.junit.Rule;

import sorting.*;
import java.util.*;
import org.junit.rules.ExpectedException;


/**
 *
 * @author somak
 */
@RunWith(Parameterized.class)
public class UnitTestCases {
    
    public SortingAlgorithm sortingAlgo;
    public UnitTestCases(SortingAlgorithm sortingAlgo) {
        this.sortingAlgo = sortingAlgo;
        
    }
   
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    
    @Rule public ExpectedException thrown = ExpectedException.none();
    
    @Test
    public void sortingOnEmptyList(){
        
        // expectations
        thrown.expect(java.lang.NullPointerException.class);
        thrown.expectMessage("Array list is null or empty");
        
        // create an empty array list
        ArrayList<Integer> integerList = new ArrayList<>();
        // no element added should thrown an exception
        sortingAlgo.sortAsc(integerList);
       
                
    }
    
    @Test
    public void sortingOnListWithNonIntegerValue(){
        
        // expectations
        thrown.expect(java.lang.ClassCastException.class);
    
        ArrayList nonintegerList = new ArrayList ();
        nonintegerList.add(2);
        nonintegerList.add('a');
        nonintegerList.add('b');
        sortingAlgo.sortAsc(nonintegerList);
       
                
    }
    
    @Test
    public void sortingOnNullList(){
        
        // expectations
        thrown.expect(java.lang.NullPointerException.class);
        thrown.expectMessage("Array list is null or empty");
        
        ArrayList integerList = null;
        
        sortingAlgo.sortAsc(integerList);
       
                
    }
    
    @Test
    public void sortingOnElement(){
        ArrayList <Integer> integerList = new ArrayList<>();
        integerList.add(1);
        
        ArrayList input = integerList;
        sortingAlgo.sortAsc(integerList);
        ArrayList output = integerList;
        
        assertArrayEquals(input.toArray(), output.toArray());
        
    }
    
    
    
    @Test
    public void sortingOnTwoIdenticalElements(){
        ArrayList<Integer> integerList = new ArrayList<>();
        integerList.add(5);
        integerList.add(2);
        integerList.add(2);
        integerList.add(3);
        integerList.add(1);
        
        ArrayList<Integer> sortedList = new ArrayList<>();
        sortedList.add(1);
        sortedList.add(2);
        sortedList.add(2);
        sortedList.add(3);
        sortedList.add(5);
        
        sortingAlgo.sortAsc(integerList);
        
        assertArrayEquals(sortedList.toArray(), integerList.toArray());
        
    }
    
    @Test
    public void sortingOnThreeIdenticalElements(){
        ArrayList<Integer> integerList = new ArrayList<>();
        integerList.add(7);
        integerList.add(4);
        integerList.add(5);
        integerList.add(4);
        integerList.add(10);
        integerList.add(2);
        integerList.add(4);
        integerList.add(1);
        
        ArrayList<Integer> sortedList = new ArrayList<>();
        sortedList.add(1);
        sortedList.add(2);
        sortedList.add(4);
        sortedList.add(4);
        sortedList.add(4);
        sortedList.add(5);
        sortedList.add(7);
        sortedList.add(10);
        
        sortingAlgo.sortAsc(integerList);
        
        assertArrayEquals(sortedList.toArray(), integerList.toArray());
        
    }
    
    @Test
    public void sortingOnTwoElementsInCorrectOrder(){
        ArrayList<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(2);
        
        
        ArrayList<Integer> sortedList = new ArrayList<>();
        sortedList.add(1);
        sortedList.add(2);
        
        
        sortingAlgo.sortAsc(integerList);
        
        assertArrayEquals(sortedList.toArray(), integerList.toArray());
        
    }
    
    @Test
    public void sortingOnTwoElementsInReverseOrder(){
        ArrayList<Integer> integerList = new ArrayList<>();
        integerList.add(2);
        integerList.add(1);
        
        
        ArrayList<Integer> sortedList = new ArrayList<>();
        sortedList.add(1);
        sortedList.add(2);
        
        
        sortingAlgo.sortAsc(integerList);
        
        assertArrayEquals(sortedList.toArray(), integerList.toArray());
        
    }
    
    @Test
    public void sortingOnThreeElementsInDifferentPermutation(){
        ArrayList<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        
        
        ArrayList<Integer> sortedList = new ArrayList<>();
        sortedList.add(1);
        sortedList.add(2);
        sortedList.add(3);
        
        
        sortingAlgo.sortAsc(integerList);
        
        assertArrayEquals(sortedList.toArray(), integerList.toArray());
        
        integerList.clear();
        integerList.add(1);
        integerList.add(3);
        integerList.add(2);
        sortingAlgo.sortAsc(integerList);
        
        assertArrayEquals(sortedList.toArray(), integerList.toArray());
        
        integerList.clear();
        integerList.add(2);
        integerList.add(3);
        integerList.add(1);
        sortingAlgo.sortAsc(integerList);
        
        assertArrayEquals(sortedList.toArray(), integerList.toArray());
        
        integerList.clear();
        integerList.add(2);
        integerList.add(1);
        integerList.add(3);
        sortingAlgo.sortAsc(integerList);
        
        assertArrayEquals(sortedList.toArray(), integerList.toArray());
        
        integerList.clear();
        integerList.add(3);
        integerList.add(1);
        integerList.add(2);
        sortingAlgo.sortAsc(integerList);
        
        assertArrayEquals(sortedList.toArray(), integerList.toArray());
        
        integerList.clear();
        integerList.add(3);
        integerList.add(2);
        integerList.add(1);
        sortingAlgo.sortAsc(integerList);
        
        assertArrayEquals(sortedList.toArray(), integerList.toArray());
        
        
    }
    
    @Test
    public void sortingOnListWithMaxInt(){
        ArrayList<Integer> integerList = new ArrayList<>();
        integerList.add(2147483647);
        integerList.add(5);
        integerList.add(55);
        integerList.add(100);
        
        
        ArrayList<Integer> sortedList = new ArrayList<>();
        sortedList.add(5);
        sortedList.add(55);
        sortedList.add(100);
        sortedList.add(2147483647);
        
        
        sortingAlgo.sortAsc(integerList);
        
        assertArrayEquals(sortedList.toArray(), integerList.toArray());
        
    }
    
    @Test
    public void sortingOnListWithNegativeNumbers(){
        ArrayList<Integer> integerList = new ArrayList<>();
        integerList.add(45);
        integerList.add(-10);
        integerList.add(67);
        integerList.add(-5);
        integerList.add(100);
        integerList.add(2);
        integerList.add(0);
        integerList.add(90);
        
        
        ArrayList<Integer> sortedList = new ArrayList<>();
        sortedList.add(-10);
        sortedList.add(-5);
        sortedList.add(0);
        sortedList.add(2);
        sortedList.add(45);
        sortedList.add(67);
        sortedList.add(90);
        sortedList.add(100);
        
        
        sortingAlgo.sortAsc(integerList);
        
        assertArrayEquals(sortedList.toArray(), integerList.toArray());
        
    }
    
    @Test
    public void sortingOnAlreadySortedList(){
        ArrayList<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        integerList.add(4);
        integerList.add(5);
        integerList.add(6);
        integerList.add(7);
        integerList.add(8);
        integerList.add(9);
        integerList.add(10);
        
        
        ArrayList<Integer> sortedList = new ArrayList<>();
        sortedList.add(1);
        sortedList.add(2);
        sortedList.add(3);
        sortedList.add(4);
        sortedList.add(5);
        sortedList.add(6);
        sortedList.add(7);
        sortedList.add(8);
        sortedList.add(9);
        sortedList.add(10);
        
        
        sortingAlgo.sortAsc(integerList);
        
        assertArrayEquals(sortedList.toArray(), integerList.toArray());
        
    }
    
    @Test
    public void sortingOnReverseSortedList(){
        ArrayList<Integer> integerList = new ArrayList<>();
        integerList.add(10);
        integerList.add(9);
        integerList.add(8);
        integerList.add(7);
        integerList.add(6);
        integerList.add(5);
        integerList.add(4);
        integerList.add(3);
        integerList.add(2);
        integerList.add(1);
        
        
        ArrayList<Integer> sortedList = new ArrayList<>();
        sortedList.add(1);
        sortedList.add(2);
        sortedList.add(3);
        sortedList.add(4);
        sortedList.add(5);
        sortedList.add(6);
        sortedList.add(7);
        sortedList.add(8);
        sortedList.add(9);
        sortedList.add(10);
        
        
        sortingAlgo.sortAsc(integerList);
        
        assertArrayEquals(sortedList.toArray(), integerList.toArray());
        
    }
    
    @Test
    public void sortingOnBigNumbers(){
        ArrayList<Integer> integerList = new ArrayList<>();
        integerList.add(1111);
        integerList.add(65348);
        integerList.add(30000);
        integerList.add(999);
        integerList.add(41111);
        integerList.add(75468);
        integerList.add(45678);
        
        
        ArrayList<Integer> sortedList = new ArrayList<>();
        sortedList.add(999);
        sortedList.add(1111);
        sortedList.add(30000);
        sortedList.add(41111);
        sortedList.add(45678);
        sortedList.add(65348);
        sortedList.add(75468);

        
        
        sortingAlgo.sortAsc(integerList);
        
        assertArrayEquals(sortedList.toArray(), integerList.toArray());
        
    }
    
    @Test
    public void sortingOnListWithHighestNumberInMiddle(){
        ArrayList<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(6);
        integerList.add(8);
        integerList.add(20);
        integerList.add(44);
        integerList.add(100);
        integerList.add(5);
        integerList.add(7);
        integerList.add(0);
        integerList.add(30);
        integerList.add(22);
        
        
        ArrayList<Integer> sortedList = new ArrayList<>();
        sortedList.add(0);
        sortedList.add(1);
        sortedList.add(5);
        sortedList.add(6);
        sortedList.add(7);
        sortedList.add(8);
        sortedList.add(20);
        sortedList.add(22);
        sortedList.add(30);
        sortedList.add(44);
        sortedList.add(100);
        
        
        sortingAlgo.sortAsc(integerList);
        
        assertArrayEquals(sortedList.toArray(), integerList.toArray());
        
    }
    
    
    @Test
    public void sortingOnRandomListOf1000NumbersBetweenNeg100To2000(){
        
        Random rand = new Random();
        ArrayList<Integer> integerList = new ArrayList<>();
        
        for (int i = 0; i < 1000; i++){
            int number = rand.nextInt(Math.abs(2000) + Math.abs(-100)) + (-100);
            integerList.add(i, number);
        }
        
        ArrayList sortedList = integerList;
        Collections.sort(sortedList);
     
        
        sortingAlgo.sortAsc(integerList);
        
        assertArrayEquals(sortedList.toArray(), integerList.toArray());
        
    }
    
    @Test
    public void sortingOnListWithAllNegativeNumbers(){
        ArrayList<Integer> integerList = new ArrayList<>();
        integerList.add(-1);
        integerList.add(-6);
        integerList.add(-8);
        integerList.add(-20);
        integerList.add(-44);
        integerList.add(-100);
        integerList.add(-5);
        integerList.add(-7);
        integerList.add(-10);
        integerList.add(-30);
        integerList.add(-22);
        
        
        ArrayList<Integer> sortedList = new ArrayList<>();
        sortedList.add(-100);
        sortedList.add(-44);
        sortedList.add(-30);
        sortedList.add(-22);
        sortedList.add(-20);
        sortedList.add(-10);
        sortedList.add(-8);
        sortedList.add(-7);
        sortedList.add(-6);
        sortedList.add(-5);
        sortedList.add(-1);
        
        
        sortingAlgo.sortAsc(integerList);
        
        assertArrayEquals(sortedList.toArray(), integerList.toArray());
        
    }
    
    @Test
    public void sortingOnListWithAllNumbersEqual(){
        ArrayList<Integer> integerList = new ArrayList<>();
        integerList.add(0);
        integerList.add(0);
        integerList.add(0);
        integerList.add(0);
        integerList.add(0);
        integerList.add(0);
        integerList.add(0);
        integerList.add(0);
        integerList.add(0);
        integerList.add(0);
        integerList.add(0);
        
        
        ArrayList<Integer> sortedList = new ArrayList<>();
        sortedList.add(0);
        sortedList.add(0);
        sortedList.add(0);
        sortedList.add(0);
        sortedList.add(0);
        sortedList.add(0);
        sortedList.add(0);
        sortedList.add(0);
        sortedList.add(0);
        sortedList.add(0);
        sortedList.add(0);
        
        
        sortingAlgo.sortAsc(integerList);
        
        assertArrayEquals(sortedList.toArray(), integerList.toArray());
        
    }
    @Parameterized.Parameters
    public static Collection<Object []> instanceToTest() {
        return Arrays.asList(
                    new Object[]{ new HeapSort()},
                    new Object[]{ new QuickSort()},
                    new Object[]{ new BubbleSort()},
                    new Object[]{ new InsertionSort()}
        );
    }
    
}
