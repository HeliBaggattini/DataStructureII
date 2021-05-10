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
        //creating a binary tree
        BinaryTree bt = new BinaryTree("root");

        System.out.println("Populating tree...");
        //adding nodes to the tree
        try {
            Node a = bt.addChildLeft(bt.getRoot(), "a");
            Node b = bt.addChildRight(bt.getRoot(), "b");
            Node c = bt.addChildLeft(a, "c");
            Node d = bt.addChildRight(a, "d");
            Node e = bt.addChildLeft(b, "e");
            Node f = bt.addChildRight(b, "f");
            Node g = bt.addChildLeft(c, "g");
            Node h = bt.addChildRight(c, "h");
            Node i = bt.addChildRight(d, "i");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        //node count
        System.out.print("Node count:");
        System.out.println(bt.count(bt.getRoot()));

        //impossible situations
        System.out.println("Trying impossible situations...");
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
        
        //size methods
        System.out.print("tree height:");
        System.out.println(bt.height(bt.getRoot()));
        System.out.print("tree height(left branch):");
        System.out.println(bt.height(bt.getRoot().left));
        System.out.print("tree depht on node root:");
        System.out.println(bt.depht(bt.getRoot()));
        System.out.print("tree depht on first left node(left branch):");
        System.out.println(bt.depht(bt.getRoot().left));
        
        //counting methods
        System.out.print("Number of internal nodes:");
        System.out.println(bt.cores(bt.getRoot()));
        System.out.print("Number of external nodes(leafs):");
        System.out.println(bt.leafs(bt.getRoot()));
        
        //printing methods
        System.out.println("pré ordem: " + bt.preOrder(bt.getRoot()));
        System.out.println("pos ordem: " + bt.postOrder(bt.getRoot()));
        System.out.println("em ordem: " + bt.inOrder(bt.getRoot()));
        System.out.println("Binary tree: " + bt.print(bt.getRoot()));
        
        for(Node n: bt.inOrderArray(bt.getRoot())){
            System.out.print(n.element + " ");
        }
    }

}
