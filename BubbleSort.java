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
public class BubbleSort implements SortingAlgorithm{
    
    // implement the ascending order sorting method
    public void sortAsc (ArrayList<Integer> numberList) throws NullPointerException{
    
        if (numberList == null || numberList.isEmpty()){
            throw new NullPointerException("Array list is null or empty");
        }
        int n = numberList.size();
        boolean swapped;
        do {
            swapped = false;
            for (int i = 0 ; i < n -1 ; i++){
                if ((int)numberList.get(i) > (int)numberList.get (i+1)){
                    int temp = (int) numberList.get(i);
                    numberList.set(i, numberList.get(i+1));
                    numberList.set(i+1, temp);
                    swapped = true;
                }
            }
        }while (swapped);
    }
    
}
