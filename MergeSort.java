/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorting;

import java.util.ArrayList;
import java.util.Comparator;

/**
 *
 * @author somak
 */
public class MergeSort implements SortingAlgorithm {
    
    private Comparator currentComparator;
    @Override
    public void sort(ArrayList objectList, Comparator c) throws NullPointerException {
        if (objectList == null || objectList.isEmpty()){
            throw new NullPointerException("Object list is null or empty");
        }
        // assign the comparator so that all methods can use it
        currentComparator = c;
        
        ArrayList sortedList = mergeSort(objectList);
        
        // copy sortedlist into objectList
        for(int i = 0; i < sortedList.size() ; i++){
            objectList.set(i, sortedList.get(i));
        }
    }
    
    private ArrayList mergeSort(ArrayList objectList){
        // 1 element list is already sorted
        if (objectList.size() == 1){
            return objectList;
        }
        
        // get the middle index
        int midIndex = objectList.size()/2;
        
        // divide the list into left and right list
        
        ArrayList leftList = new ArrayList();
        ArrayList rightList = new ArrayList();
        
        for (int i = 0; i < midIndex; i++){
            leftList.add(i, objectList.get(i));
        }
        
        for (int j = 0, i = midIndex; i < objectList.size(); i++, j++){
            rightList.add(j, objectList.get(i)); 
        }
        
        // sort the two lists and then merge
        leftList = mergeSort(leftList);
        rightList = mergeSort(rightList);
        
        return (merge(leftList, rightList));
        
    }
    
    private ArrayList merge (ArrayList leftList, ArrayList rightList){
        
        ArrayList mergedList = new ArrayList();
        
        while (leftList.size() != 0 && rightList.size() != 0){
            
            if (currentComparator.compare(leftList.get(0), rightList.get(0)) > 0){
               mergedList.add(rightList.get(0));
               rightList.remove(0);
            }
            else{
                mergedList.add(leftList.get(0));
                leftList.remove(0);
            }
        }
        
        // add the remaining elements in any list
        while (leftList.size() != 0){
            mergedList.add(leftList.get(0));
            leftList.remove(0);
        }
        
        // add the remaining elements in any list
        while (rightList.size() != 0){
            mergedList.add(rightList.get(0));
            rightList.remove(0);
        }
        
        return (mergedList);
    }
    
}
