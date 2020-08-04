/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinkedList.test;

import LinkedList.Node;
import LinkedList.List;

/**
 *
 * @author 1511 FOX
 */
public class LStest {
    
    public static void main(String[] args) {
        
        List sl = new List();
        
        sl.insertFirst(0);
        sl.insertFirst(1);
        sl.insertFirst(2);
        sl.insertFirst(3);
        sl.insertFirst(4);
    
        //ipressao com toString
        System.out.println(sl);
        
        Node a = sl.find(0);
        sl.insertAfter(a, 8);
        
        if(a.next.equals(8)){
            System.out.println("fail");
        }
        
        sl.insert(10);
        
        //impressao teste
        System.out.println(sl);
        System.out.println(sl.last());
        
        sl.remove(10);
        sl.remove(2);
        sl.remove(4);
        
        //fim do teste
        System.out.println(sl);
        System.out.println(sl.last());
    }
    
}
