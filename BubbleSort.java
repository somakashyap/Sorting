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
public class BubbleSort implements SortingAlgorithm {
    
    @Override
    public void sort (ArrayList objectList, Comparator c) throws NullPointerException
    {
        if (objectList == null || objectList.isEmpty()){
            throw new NullPointerException("Object list is null or empty");
        }
        int n = objectList.size();
        boolean swapped;
        do {
            swapped = false;
            for(int i = 0; i < n-1; i++){
                if (c.compare(objectList.get(i), objectList.get(i+1)) > 0){
                    Object temp = objectList.get(i);
                    objectList.set(i, objectList.get(i+1));
                    objectList.set(i+1, temp);
                    swapped = true;
                }
            }
                
        }while (swapped);
        
    }
   
    
}
