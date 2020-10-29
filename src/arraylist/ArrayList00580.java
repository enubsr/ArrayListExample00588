/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arraylist;

import arraylist.ArrayList.ArrayIterator;
import java.util.Iterator;

/**
 *
 * @author Enubs
 */
public class ArrayList00580 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<String> strList = new ArrayList<>(10);
        strList.add(0, "dog");
        strList.add(1, "cat");
        strList.add(2, "lion");
        strList.add(3, "tiger");
        
        ArrayIterator iter = strList.new ArrayIterator();
        
        Iterator<String> iter1 = iter.iterator();
        while(iter.hasNext()){
            System.out.print(iter.next() + " ");
        }
        

    }
    
}
