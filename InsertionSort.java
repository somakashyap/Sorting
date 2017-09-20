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
    
    @Override
    public void sort (ArrayList objectList, Comparator c) throws NullPointerException{
        
        if (objectList == null || objectList.isEmpty()){
            throw new NullPointerException("Object list is null or empty");
        }
        // first element already sorted so we start from 1
        for (int sortingIndex = 1; sortingIndex < objectList.size(); sortingIndex++){
            Object elementTobeInserted = objectList.get(sortingIndex);
            int i = sortingIndex - 1;

            while ( i >= 0 && c.compare(objectList.get(i), elementTobeInserted ) > 0){
                //shift the element to make space
                objectList.set(i+1, objectList.get(i));
                i = i - 1;
            }
            objectList.set(i+1, elementTobeInserted);   
        }
    }
}
        
   
