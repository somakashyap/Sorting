/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorting;

import java.util.*;

/**
 *
 * @author somak
 */


public class Sorting {

    /**
     * utility function to read an integer as user input
     * returns an integer
     */
    public static int readInteger(){
        Scanner scanner = new Scanner(System.in);
        int integer = -1;
        boolean error = true;
        do{
            try{
                integer = scanner.nextInt();
                error = false;
            }
            catch(InputMismatchException e){
                System.out.print ("Invalid Input!");
                scanner.next();
            }
        }while (error);
        return (integer);         
    }
    
    /**
     * utility function to create a integer list to be sorted
     * returns an ArrayList of integers
     */
    
    public static ArrayList inputIntegerList(){
        
        ArrayList listOfNumbers = new ArrayList <Integer>();
        int numOfItems = 0;
        System.out.print("Enter the number of integers to be sorted: ");
        numOfItems = readInteger();    
  
        System.out.println("Enter the integers: ");
        for (int i = 0; i < numOfItems; i++){
            int item = readInteger();
            listOfNumbers.add(item);
        }
        return (listOfNumbers);
    }
    /**
     * utility function to print the ArrayList
     * @param listOfIntegers
     */
    public static void printIntegerList (ArrayList listOfIntegers){
        System.out.println("NumberList: " + listOfIntegers); 
    }
    
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        
        // Create the ArrayList of integers
        ArrayList integerList = inputIntegerList();
        
        // print the unsorted list
        printIntegerList(integerList);
        
        // sorting using bubble sort
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sortAsc(integerList);
        
        // print the sorted list
        printIntegerList(integerList);
        
    }
    
}
