/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BinaryTree.test;

import BinaryTree.BinaryTree;
import BinaryTree.Node;

/**
 *
 * @author 1511 FOX
 */
public class BTTest {

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree("root");

        try {
            Node a = bt.addChildLeft(bt.getRoot(), "a");
            Node b = bt.addChildRight(bt.getRoot(), "b");
            Node c = bt.addChildLeft(a, "c");
            Node d = bt.addChildRight(a, "d");
            Node e = bt.addChildLeft(b, "e");
            Node f = bt.addChildRight(b, "f");
            Node g = bt.addChildLeft(c, "g");
            Node h = bt.addChildRight(c, "h");
            Node i = bt.addChildRight(d, "h");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println(bt.count(bt.getRoot()));

        try {
            Node d = bt.addChildLeft(bt.getRoot(), "d");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        try {
            Node d = bt.addChildRight(bt.getRoot(), "d");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
        System.out.println(bt.height(bt.getRoot()));
        System.out.println(bt.height(bt.getRoot().left));
        System.out.println(bt.depht(bt.getRoot()));
        System.out.println(bt.depht(bt.getRoot().left));
        
        System.out.println(bt.cores(bt.getRoot()));
        System.out.println(bt.leafs(bt.getRoot()));
        
        bt.print(bt.getRoot());
    }

}
