/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorting;

import java.util.*;
import java.lang.Math;

/**
 *
 * @author somak
 */
public class HeapSort implements SortingAlgorithm{
    
    private Comparator currentComparator;
    /**
     * utility function to get parent index
     * @param index
     * @return parent index
     */
    private double getParent (int index){
        
        double doubleIndex = 1.0 * index;
        return (Math.floor((doubleIndex - 1)/2));
    }
    
    /**
     * utility function to get left child index
     * @param index
     * @return parent index
     */
    private int getLeftChildIndex (int index){
        
        return ((2*index) + 1);
    }
    
    /**
     * utility function to get right child index
     * @param index
     * @return parent index
     */
    private int getRightChildIndex (int index){
        
        return ((2*index) + 2);
    }
    
    /**
     * utility function to swap elements in two indexes
     */
    
    private void swapElements(ArrayList objectList, int firstIndex, int secondIndex){
        Object temp = objectList.get(firstIndex);
        objectList.set(firstIndex, objectList.get(secondIndex));
        objectList.set(secondIndex, temp);
    }
    
    /**
     * utility function to shiftdown elements to maintain heap order at startIndex
     */
    private void shiftDown(ArrayList objectList, int startIndex, int endIndex){
    
        int rootIndex = startIndex;
        
        int leftChildIndex = getLeftChildIndex (rootIndex);
        int rightChildIndex = getRightChildIndex (rootIndex);
        
        while (leftChildIndex <= endIndex){
            
            int swapNodeIndex = rootIndex;
            
            if (currentComparator.compare(objectList.get(leftChildIndex),
                                               objectList.get(swapNodeIndex)) > 0 ){
                swapNodeIndex = leftChildIndex;
            }
            
            // check for the right child
            if (rightChildIndex <= endIndex && 
                    currentComparator.compare(objectList.get(rightChildIndex),
                                                   objectList.get(swapNodeIndex)) > 0 ){
                swapNodeIndex = rightChildIndex;
            }
            
            
            // if there is no change then it is in heap order
            if (swapNodeIndex == rootIndex){
                return;
            }
            
            // swap the element such that highest is at root
            swapElements(objectList, rootIndex, swapNodeIndex);

            // check further down 
            rootIndex = swapNodeIndex;
            leftChildIndex = getLeftChildIndex (rootIndex);
            rightChildIndex = getRightChildIndex (rootIndex);
        }
        
    }
    /**
     * utility function to create max heap
     * @param numberList 
     */
    private void heapify(ArrayList objectList){
        
        // start at the parent of leaf node (last node is leaf node)
        int startIndex = (int) getParent(objectList.size() - 1);
        
        while (startIndex >= 0){
            // shift the nodes such that all nodes below start index are in heap order
            shiftDown (objectList, startIndex, objectList.size() - 1);
            
            // move to next node
            startIndex = startIndex - 1;
        }
    }    
        
    
    public void sortAsc(ArrayList<Integer> numberList) throws NullPointerException {
        
        if (numberList == null || numberList.isEmpty()){
            throw new NullPointerException("Array list is null or empty");
        }
        // create the max heap out of the array
        
        heapify(numberList);
        
        // max element is at root index 0
        int endIndex = numberList.size() - 1;
        while (endIndex > 0){
            swapElements(numberList, 0, endIndex);
            
            // heap is now reduced by size 1
            endIndex = endIndex - 1;
            
            //swap might break the heap property so arrange it again
            shiftDown(numberList, 0, endIndex);
            
        }
    }
    
    @Override
    public void sort (ArrayList objectList, Comparator c) throws NullPointerException{
        
        if (objectList == null || objectList.isEmpty()){
            throw new NullPointerException("Object list is null or empty");
        }
        // assign the comparator so that all methods can use it
        currentComparator = c;
        // create the max heap out of the array
        
        heapify(objectList);
        
        // max element is at root index 0
        int endIndex = objectList.size() - 1;
        while (endIndex > 0){
            swapElements(objectList, 0, endIndex);
            
            // heap is now reduced by size 1
            endIndex = endIndex - 1;
            
            //swap might break the heap property so arrange it again
            shiftDown(objectList, 0, endIndex);
            
        }    
    }
    
}
