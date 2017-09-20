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
public class IntegerNumbers implements Comparator{

    @Override
    public int compare(Object t, Object t1) {
        int n1 = 0;
        int n2 = 0;
        try{
            n1 = Integer.parseInt(t.toString());
            n2 = Integer.parseInt(t1.toString());
        }
        catch (NumberFormatException e){
            throw new NumberFormatException("In Integer comapre() : Object to compare is not an integer");
        }
        
        return (n1 - n2);
            
    }    
}
