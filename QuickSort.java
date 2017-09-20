/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorting;

/**
 *
 * @author somak
 */

import java.util.*;
public class QuickSort implements SortingAlgorithm{
    
    // implement the ascending order sorting method
    public void sortAsc (ArrayList<Integer> numberList) throws NullPointerException{
        if (numberList == null || numberList.isEmpty()){
            throw new NullPointerException("Array list is null or empty");
        }
        int n = numberList.size();
        quickSort (numberList, 0, n -1);  
        
    }
   /**
    * quickSort method to divide and then sort the list
    */ 
    private void quickSort (ArrayList<Integer> numberList, int lowestIndex, int highestIndex){
    
        if (lowestIndex < highestIndex){
            int pivotIndex = partition(numberList, lowestIndex, highestIndex);
            quickSort(numberList, lowestIndex, pivotIndex - 1);
            quickSort(numberList, pivotIndex + 1, highestIndex);
        }
    }
    
    /**
    * partition method to divide the list returns pivot index
    *  last element is taken as pivot
    */
    private int partition (ArrayList<Integer> numberList, int lowestIndex, int highestIndex){
    
        int pivotElement = numberList.get(highestIndex);
        int lessThanIndexPosition = lowestIndex - 1;
        for (int i = lowestIndex; i <  highestIndex; i++){
            if (numberList.get(i) < pivotElement){
                lessThanIndexPosition = lessThanIndexPosition + 1;
                if (lessThanIndexPosition != i){
                    int temp = numberList.get(lessThanIndexPosition);
                    numberList.set(lessThanIndexPosition, numberList.get(i));
                    numberList.set(i, temp);
                }
            }
        }
   
        if (highestIndex != lessThanIndexPosition + 1){
            numberList.set(highestIndex, numberList.get(lessThanIndexPosition + 1));
            numberList.set(lessThanIndexPosition + 1, pivotElement);
        }
        return lessThanIndexPosition + 1;
    }
}
