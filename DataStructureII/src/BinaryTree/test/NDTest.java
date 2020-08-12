/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BinaryTree.test;
import BinaryTree.Node;

/**
 *
 * @author 1511 FOX
 */
public class NDTest {
    public static void main(String[] args) {
        
        Node a = new Node("a");
        Node b = new Node("b");
        Node c = new Node("c");
        Node d = new Node("d");
        
        a.right = c;
        c.parent = a;
        
        a.left = b;
        b.parent = a;
        
        b.right = d;
        d.parent = b;
        
        System.out.println(a.isExternal());
        System.out.println(a.isInternal());
        System.out.println(a.isRoot());
        System.out.println(c.isExternal());
        System.out.println(b.isExternal());
        
    }
}
