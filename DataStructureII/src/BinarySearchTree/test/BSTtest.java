/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BinarySearchTree.test;

import BinarySearchTree.BinarySearchTree;

/**
 *
 * @author 1511 FOX
 */
public class BSTtest {
    public static void main(String[] args) {
         BinarySearchTree bst = new BinarySearchTree("h");
         bst.addNode("a");
         bst.addNode("b");
         bst.addNode("i");
         bst.addNode("j");
         bst.addNode("c");
         bst.addNode("h");
         
         System.out.println(bst.preOrder(bst.getRoot()));
         System.out.println(bst.nonRecursiveSmallNum(bst.getRoot()));
         System.out.println(bst.search(bst.getRoot(), "c"));
         System.out.println(bst.search(bst.getRoot(), "x"));
    }
}
