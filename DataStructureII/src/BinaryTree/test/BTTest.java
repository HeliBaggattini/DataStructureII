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
            System.out.println(b);
            Node c = bt.addChildRight(b, "c");
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
    }

}
