/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BinarySearchTree.test;

import BinarySearchTree.BinarySearchTree;
import BinaryTree.BinaryTree;
import BinaryTree.Node;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 1511 FOX
 */
public class BSTtest {

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree("h");

        System.out.println("isSearch  = " + bst.isSearchTree(bst.getRoot()));

        //forcing the tree to not be search tree
//        try {
//            bst.addChildLeft(bst.getRoot(), "x");
//        } catch (Exception ex) {
//            Logger.getLogger(BSTtest.class.getName()).log(Level.SEVERE, null, ex);
//        }
        bst.addNode("a");
        bst.addNode("b");
        bst.addNode("i");
        bst.addNode("j");
        bst.addNode("c");
        bst.addNode("h");

        System.out.println("tree: " + bst.preOrder(bst.getRoot()));
        System.out.println("Smallest number (non recursive): " + bst.nonRecursiveSmallNum(bst.getRoot()));
        System.out.println("Search for 'c': " + bst.search(bst.getRoot(), "c"));
        System.out.println("Search for 'x': " + bst.search(bst.getRoot(), "x"));
        System.out.println("isSearch  = " + bst.isSearchTree(bst.getRoot()));

        //creating a binary tree
        BinaryTree bt = new BinaryTree("root");
        //adding nodes to the tree
        try {
            Node a = bt.addChildLeft(bt.getRoot(), "a");
            Node b = bt.addChildRight(bt.getRoot(), "k");
            Node c = bt.addChildLeft(a, "c");
            Node d = bt.addChildRight(a, "d");
            Node e = bt.addChildLeft(b, "e");
            Node f = bt.addChildRight(b, "i");
            Node g = bt.addChildLeft(c, "g");
            Node h = bt.addChildRight(c, "h");
            Node i = bt.addChildRight(d, "i");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        //converting binary tree to search binary tree
        BinarySearchTree bst2 = new BinarySearchTree("a");
        bst2 = bst2.toBinarySearchTree(bt);
        System.out.println(bst2.preOrder(bst2.getRoot()));
    }

}
