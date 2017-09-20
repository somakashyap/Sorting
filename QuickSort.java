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
    
    private Comparator currentComparator;
    
    public void sort (ArrayList objectList, Comparator c)throws NullPointerException{
        if (objectList == null || objectList.isEmpty()){
            throw new NullPointerException("Object list is null or empty");
        }
        
        // assign the curre t comparator to be used by all methods
        currentComparator = c;
        int n = objectList.size();
        quickSort (objectList, 0, n -1);
    }
    
   /**
    * quickSort method to divide and then sort the list
    */ 
    private void quickSort (ArrayList objectList, int lowestIndex, int highestIndex){
    
        if (lowestIndex < highestIndex){
            int pivotIndex = partition(objectList, lowestIndex, highestIndex);
            quickSort(objectList, lowestIndex, pivotIndex - 1);
            quickSort(objectList, pivotIndex + 1, highestIndex);
        }
    }
    
    /**
    * partition method to divide the list returns pivot index
    *  last element is taken as pivot
    */
    private int partition (ArrayList objectList, int lowestIndex, int highestIndex){
    
        Object pivotElement = objectList.get(highestIndex);
        int lessThanIndexPosition = lowestIndex - 1;
        for (int i = lowestIndex; i <  highestIndex; i++){
            if (currentComparator.compare(objectList.get(i), pivotElement) < 0){
                lessThanIndexPosition = lessThanIndexPosition + 1;
                
                if (lessThanIndexPosition != i){
                    Object temp = objectList.get(lessThanIndexPosition);
                    objectList.set(lessThanIndexPosition, objectList.get(i));
                    objectList.set(i, temp);
                }
            }
        }
   
        if (highestIndex != lessThanIndexPosition + 1){
            objectList.set(highestIndex, objectList.get(lessThanIndexPosition + 1));
            objectList.set(lessThanIndexPosition + 1, pivotElement);
        }
        return (lessThanIndexPosition + 1);
    }
}
