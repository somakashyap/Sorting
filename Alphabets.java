/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unitTesting;

import java.util.Comparator;

/**
 *
 * @author somak
 */
public class Alphabets implements Comparator{

    /**
     * checks if the string is a single alphabet
     * @param str 
     */
    private boolean checkAlphabet (String str){
    
        if(str.length() != 1){
            return false;
        }
        if (!str.matches("[A-Za-z]")){
            return false;
        }
        return true;
    }
    
    @Override
    public int compare(Object t, Object t1) {
        
        if (!checkAlphabet(t.toString()) || !checkAlphabet(t1.toString())){
            throw new NumberFormatException("In Alphabets comapre() : Object to compare is not an alphabet");
        }
        
        char str1 = t.toString().charAt(0);
        char str2 = t1.toString().charAt(0);
        
        int retValue = Character.getNumericValue(str1) - Character.getNumericValue(str2);
        return (retValue);
    }
    
}

