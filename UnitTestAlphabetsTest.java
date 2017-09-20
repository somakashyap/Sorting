/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unitTesting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Random;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import sorting.BubbleSort;
import sorting.HeapSort;
import sorting.QuickSort;
import sorting.SortingAlgorithm;

/**
 *
 * @author somak
 */

@RunWith(Parameterized.class)
public class UnitTestAlphabetsTest {
    
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
    
    public UnitTestAlphabetsTest(SortingAlgorithm sortingAlgo) {
        this.sortingAlgo = sortingAlgo;
        c = new Alphabets();
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
    public void sortingOnIntegerListWithNonAlphabetValue(){
        
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
        objectList.add('a');
        
        ArrayList input = objectList;
        sortingAlgo.sort(objectList, c);
        
        assertTrue(checkArraySorted(input));
        
        
    }
    
     
    
    
    @Test
    public void sortingOnTwoIdenticalElements(){
        ArrayList<Character> alphabetList = new ArrayList<>();
        alphabetList.add('g');
        alphabetList.add('i');
        alphabetList.add('i');
        alphabetList.add('b');
        alphabetList.add('a');
       
        
        sortingAlgo.sort(alphabetList, c);
        
        assertTrue(checkArraySorted(alphabetList));
        
        
        
    }
    
    @Test
    public void sortingOnThreeIdenticalElements(){
        ArrayList<Character> list = new ArrayList<>();
        list.add('r');
        list.add('e');
        list.add('t');
        list.add('e');
        list.add('w');
        list.add('a');
        list.add('e');
        list.add('b');
       
        sortingAlgo.sort(list , c);
        
        assertTrue(checkArraySorted(list));
        
    }
    
    @Test
    public void sortingOnTwoElementsInCorrectOrder(){
        ArrayList<Character> list = new ArrayList<>();
        list.add('a');
        list.add('b');
        
        
        sortingAlgo.sort(list , c);
        
        assertTrue(checkArraySorted(list));
        
    }
    
    @Test
    public void sortingOnTwoElementsInReverseOrder(){
        ArrayList<Character> list = new ArrayList<>();
        list.add('b');
        list.add('a');
        
        sortingAlgo.sort(list , c);
        assertTrue(checkArraySorted(list));
        
    }
    
    @Test
    public void sortingOnThreeElementsInDifferentPermutation(){
        ArrayList<Character> list = new ArrayList<>();
        list.add('a');
        list.add('b');
        list.add('c');
        
        sortingAlgo.sort(list, c);
        
        assertTrue(checkArraySorted(list));
        
        list.clear();
        list.add('a');
        list.add('c');
        list.add('b');
        sortingAlgo.sort(list , c);
        
        assertTrue(checkArraySorted(list));
        
        list.clear();
        list.add('b');
        list.add('c');
        list.add('a');
        sortingAlgo.sort(list, c);
        
        assertTrue(checkArraySorted(list));
        
        list.clear();
        list.add('b');
        list.add('a');
        list.add('c');
        sortingAlgo.sort(list, c);
        
        assertTrue(checkArraySorted(list));
        
        list.clear();
        list.add('c');
        list.add('a');
        list.add('b');
        sortingAlgo.sort(list, c);
        
        assertTrue(checkArraySorted(list));
        
        list.clear();
        list.add('c');
        list.add('b');
        list.add('a');
        sortingAlgo.sort(list, c);
        
        assertTrue(checkArraySorted(list));
        
        
    }
    
    
        
    @Test
    public void sortingOnAlreadySortedList(){
        ArrayList<Character> list = new ArrayList<>();
        list.add('a');
        list.add('b');
        list.add('c');
        list.add('d');
        list.add('e');
        list.add('f');
        list.add('g');
        list.add('h');
        list.add('i');
        list.add('j');
        
        sortingAlgo.sort(list, c);
        
        
        assertTrue(checkArraySorted(list));
        
    }
    
    @Test
    public void sortingOnReverseSortedList(){
        ArrayList<Character> list = new ArrayList<>();
        list.add('j');
        list.add('i');
        list.add('h');
        list.add('g');
        list.add('f');
        list.add('e');
        list.add('d');
        list.add('c');
        list.add('b');
        list.add('a');
        
        sortingAlgo.sort(list, c);
        
        
        assertTrue(checkArraySorted(list));
        
    }
    
    
    
        
    
    @Test
    public void sortingOnRandomListOf26UppercaseAlphabets(){
        
        Random rand = new Random();
        ArrayList<Character> list = new ArrayList<>();
        
        for (int i = 0; i < 26; i++){
            int number = rand.nextInt((int)('Z') - (int)('A')) + (int)('A');
            list.add(i, (char)number);
        }
        
       
        sortingAlgo.sort(list, c);
        
        assertTrue(checkArraySorted(list));
        
    }
    
    @Test
    public void sortingOnRandomListOf26LowercaseAlphabets(){
        
        Random rand = new Random();
        ArrayList<Character> list = new ArrayList<>();
        
        for (int i = 0; i < 26; i++){
            int number = rand.nextInt((int)('z') - (int)('a')) + (int)('a');
            list.add(i, (char)number);
        }
        
       
        sortingAlgo.sort(list, c);
        
        assertTrue(checkArraySorted(list));
        
    }
    
    
}

