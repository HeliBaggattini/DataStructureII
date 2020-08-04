/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stack.test;

import Stack.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 1511 FOX
 */
public class StackTest {
    public static void main(String[] args) {
        
        Stack s = new Stack();
        
        System.out.println("size: " + s.size());
        
        s.push(0);
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        
        try {
            System.out.println(s.peek());
        } catch (Exception ex) {
            Logger.getLogger(StackTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(s);
        
        try {
            s.pop();
            s.pop();
        } catch (Exception ex) {
            Logger.getLogger(StackTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println(s);
        
        try {
            s.pop();
            s.pop();
            s.pop();
        } catch (Exception ex) {
            Logger.getLogger(StackTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println(s);
        System.out.println("size: " + s.size());
        
        try {
            s.pop();
        } catch (Exception ex) {
            Logger.getLogger(StackTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
