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
    
    private void swapElements(ArrayList<Integer> numberList, int firstIndex, int secondIndex){
        int temp = numberList.get(firstIndex);
        numberList.set(firstIndex, numberList.get(secondIndex));
        numberList.set(secondIndex, temp);
    }
    
    /**
     * utility function to shiftdown elements to maintain heap order at startIndex
     */
    private void shiftDown(ArrayList<Integer> numberList, int startIndex, int endIndex){
    
        int rootIndex = startIndex;
        
        int leftChildIndex = getLeftChildIndex (rootIndex);
        int rightChildIndex = getRightChildIndex (rootIndex);
        
        while (leftChildIndex <= endIndex){
            //int childNode = numberList.get(leftChildIndex);
            int swapNodeIndex = rootIndex;
            
            if (numberList.get(leftChildIndex) > numberList.get(swapNodeIndex)){
                swapNodeIndex = leftChildIndex;
            }
            
            // check for the right child
            if (rightChildIndex <= endIndex && 
                    numberList.get(rightChildIndex) > numberList.get(swapNodeIndex)){
                swapNodeIndex = rightChildIndex;
            }
            
            
            // if there is no change then it is in heap order
            if (swapNodeIndex == rootIndex){
                return;
            }
            
            // swap the element such that highest is at root
            swapElements(numberList, rootIndex, swapNodeIndex);

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
    private void heapify(ArrayList<Integer> numberList){
        
        // start at the parent of leaf node (last node is leaf node)
        int startIndex = (int) getParent(numberList.size() - 1);
        
        while (startIndex >= 0){
            // shift the nodes such that all nodes below start index are in heap order
            shiftDown (numberList, startIndex, numberList.size() - 1);
            
            // move to next node
            startIndex = startIndex - 1;
        }
    }    
        
    @Override
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
    
}
