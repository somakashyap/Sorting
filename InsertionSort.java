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
public class InsertionSort implements SortingAlgorithm{
    
    // implement the ascending order sorting method
    public void sortAsc (ArrayList<Integer> numberList){
        
        if (numberList == null || numberList.isEmpty()){
            return;
        }
        // first element already dorted so we start from 1
        for (int sortingIndex = 1; sortingIndex < numberList.size(); sortingIndex++){
            int elementTobeInserted = numberList.get(sortingIndex);
            int i = sortingIndex - 1;

            while ( i >= 0 && numberList.get(i) > elementTobeInserted){
                //shift the element to make space
                numberList.set(i+1, numberList.get(i));
                i = i - 1;
            }
            numberList.set(i+1, elementTobeInserted);   
        }
    }
    
}
