/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinkedList.test;

import LinkedList.OrderedList;

/**
 *
 * @author 1511 FOX
 */
public class OLSTest {

    public static void main(String[] args) {

        OrderedList ol = new OrderedList();

        ol.insert(0);
        ol.insert(1);
        ol.insert(2);
        ol.insert(5);
        ol.insert(4);
        ol.insert(7);
        ol.insert(6);
        ol.insert(-1);
        ol.insert(9);
        
        System.out.println(ol.size());
        System.out.println(ol);
    }

}
