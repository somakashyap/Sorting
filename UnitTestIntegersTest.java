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

import sorting.*;
import java.util.*;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 *
 * @author somak
 */
@RunWith(Parameterized.class)
public class UnitTestIntegersTest {
    
    private final SortingAlgorithm sortingAlgo;
    private final Comparator c;
   
    
    private boolean checkArraySorted(ArrayList array){
        if (array.size() == 1)
            return true;
        for (int i = 0; i < array.size() - 1 ; i++){
            if (c.compare(array.get(i), array.get(i+1)) > 0){
                return false;
            }
        }
        return true;
    }
    
    
    public UnitTestIntegersTest(SortingAlgorithm sortingAlgo) {
        this.sortingAlgo = sortingAlgo;
        c = new IntegerNumbers();
        
    }
    
    @Parameterized.Parameters
    public static Collection<Object []> instanceToTest() {
        return Arrays.asList(
                    new Object[]{ new QuickSort()},
                    new Object[]{ new HeapSort()},
                    new Object[]{ new QuickSort()},
                    new Object[]{ new BubbleSort()}                   
        );
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
    // @Test
    // public void hello() {}
    
    @Rule public ExpectedException thrown = ExpectedException.none();
    
    @Test
    public void sortingOnEmptyList(){
        
        // expectations
        thrown.expect(java.lang.NullPointerException.class);
        thrown.expectMessage("Object list is null or empty");
        
        // create an empty array list
        ArrayList list = new ArrayList();
        // no element added should thrown an exception
        sortingAlgo.sort(list, c);
       
                
    }
    
    
    @Test
    public void sortingOnIntegerListWithNonIntegerValue(){
        
        // expectations
        thrown.expect(java.lang.NumberFormatException.class);
    
        ArrayList nonintegerList = new ArrayList ();
        nonintegerList.add(2);
        nonintegerList.add('a');
        nonintegerList.add('b');
        sortingAlgo.sort(nonintegerList, c);             
    }
    
    
    @Test
    public void sortingOnNullList(){
        
        // expectations
        thrown.expect(java.lang.NullPointerException.class);
        thrown.expectMessage("Object list is null or empty");
        
        ArrayList integerList = null;
        
        sortingAlgo.sort(integerList, c);
       
                
    }
    
        
    @Test
    public void sortingOneElementList(){
        ArrayList  objectList = new ArrayList<>();
        objectList.add(1);
        
        ArrayList input = objectList;
        sortingAlgo.sort(objectList, c);
        
        assertTrue(checkArraySorted(input));
        
        
    }
    
     
    
    
    @Test
    public void sortingOnTwoIdenticalElements(){
        ArrayList<Integer> integerList = new ArrayList<>();
        integerList.add(5);
        integerList.add(2);
        integerList.add(2);
        integerList.add(3);
        integerList.add(1);
       
        
        sortingAlgo.sort(integerList, c);
        
        assertTrue(checkArraySorted(integerList));
        
        
        
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
       
        sortingAlgo.sort(integerList , c);
        
        assertTrue(checkArraySorted(integerList));
        
    }
    
    @Test
    public void sortingOnTwoElementsInCorrectOrder(){
        ArrayList<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(2);
        
        
        sortingAlgo.sort(integerList , c);
        
        assertTrue(checkArraySorted(integerList));
        
    }
    
    @Test
    public void sortingOnTwoElementsInReverseOrder(){
        ArrayList<Integer> integerList = new ArrayList<>();
        integerList.add(2);
        integerList.add(1);
        
        sortingAlgo.sort(integerList , c);
        assertTrue(checkArraySorted(integerList));
        
    }
    
    @Test
    public void sortingOnThreeElementsInDifferentPermutation(){
        ArrayList<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        
        sortingAlgo.sort(integerList, c);
        
        assertTrue(checkArraySorted(integerList));
        
        integerList.clear();
        integerList.add(1);
        integerList.add(3);
        integerList.add(2);
        sortingAlgo.sort(integerList , c);
        
        assertTrue(checkArraySorted(integerList));
        
        integerList.clear();
        integerList.add(2);
        integerList.add(3);
        integerList.add(1);
        sortingAlgo.sort(integerList, c);
        
        assertTrue(checkArraySorted(integerList));
        
        integerList.clear();
        integerList.add(2);
        integerList.add(1);
        integerList.add(3);
        sortingAlgo.sort(integerList, c);
        
        assertTrue(checkArraySorted(integerList));
        
        integerList.clear();
        integerList.add(3);
        integerList.add(1);
        integerList.add(2);
        sortingAlgo.sort(integerList, c);
        
        assertTrue(checkArraySorted(integerList));
        
        integerList.clear();
        integerList.add(3);
        integerList.add(2);
        integerList.add(1);
        sortingAlgo.sort(integerList, c);
        
        assertTrue(checkArraySorted(integerList));
        
        
    }
    
    @Test
    public void sortingOnListWithMaxInt(){
        ArrayList<Integer> integerList = new ArrayList<>();
        integerList.add(2147483647);
        integerList.add(5);
        integerList.add(55);
        integerList.add(100);
        
        sortingAlgo.sort(integerList, c);
        
        assertTrue(checkArraySorted(integerList));
        
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
                
        sortingAlgo.sort(integerList, c);
        
        assertTrue(checkArraySorted(integerList));
        
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
        
        sortingAlgo.sort(integerList, c);
        
        
        assertTrue(checkArraySorted(integerList));
        
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
        
        sortingAlgo.sort(integerList, c);
        
        assertTrue(checkArraySorted(integerList));
        
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
        
        sortingAlgo.sort(integerList, c);
        
        assertTrue(checkArraySorted(integerList));
        
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
        
        sortingAlgo.sort(integerList, c);
        
        assertTrue(checkArraySorted(integerList));
        
    }
    
    
    @Test
    public void sortingOnRandomListOf1000NumbersBetweenNeg100To2000(){
        
        Random rand = new Random();
        ArrayList<Integer> integerList = new ArrayList<>();
        
        for (int i = 0; i < 1000; i++){
            int number = rand.nextInt(Math.abs(2000) + Math.abs(-100)) + (-100);
            integerList.add(i, number);
        }
        
       
        sortingAlgo.sort(integerList, c);
        
        assertTrue(checkArraySorted(integerList));
        
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
       
        sortingAlgo.sort(integerList, c);
        
        assertTrue(checkArraySorted(integerList));
        
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
        
        
        sortingAlgo.sort(integerList, c);
        
        assertTrue(checkArraySorted(integerList));
        
    }

}
