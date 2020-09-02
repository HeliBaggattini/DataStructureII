/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BinarySearchTree;

import BinaryTree.BinaryTree;
import BinaryTree.Node;

/**
 *
 * @author 1511 FOX
 */
//4. Estenda sua árvore binária já implementada em uma árvore binária de busca.
public class BinarySearchTree extends BinaryTree {

    public BinarySearchTree(String root) {
        super(root);
    }

//3. Escreva um método não-recursivo que retorne o menor valor de uma árvore binária de busca.
    public String nonRecursiveSmallNum(Node root) {
        Node n = root;
        while (n.left != null) {
            n = n.left;
        }

        return n.element;
    }

//5. Escreva um método que permita localizar um elemento em uma árvore binária de busca.
    public boolean search(Node n, String element) {
        boolean found = false;

        if (n == null) {
            return false;
        }

        if (n.element.compareTo(element) > 1) { //if smaller
            if (n.left != null) {
                found = search(n.left, element);
            } else {
                found = false;
            }
        } else if (n.element.compareTo(element) == 0) {//if equals
            found = true;
        } else if (n.element.compareTo(element) < 1) {//if bigger
            if (n.right != null) {
                found = search(n.right, element);
            } else {
                found = false;
            }
        }

        return found;
    }
//6. Escreva um método que permita inserir elementos de forma ordenada em uma árvore binária de
//busca.
    public void addNode(String element) {
        boolean ok = false;
        Node n = this.getRoot();

        while (!ok) {
            if (n.element.compareTo(element) > 1) { //if smaller
                if(n.left == null){
                    n.left = new Node(element);
                    ok = true;
                }else{
                    n = n.left;
                }
            } else if (n.element.compareTo(element) == 0) {//if equals
                if(n.left == null){
                    n.left = new Node(element);
                    ok = true;
                }else{
                    n = n.left;
                }
            } else if (n.element.compareTo(element) < 1) {//if bigger
                if(n.right == null){
                    n.right = new Node(element);
                    ok = true;
                }else{
                    n = n.right;
                }
            }
        }

    }

}
