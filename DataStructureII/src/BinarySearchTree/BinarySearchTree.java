/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BinarySearchTree;

import BinaryTree.BinaryTree;
import BinaryTree.Node;
import java.util.ArrayList;

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
                if (n.left == null) {
                    n.left = new Node(element);
                    ok = true;
                } else {
                    n = n.left;
                }
            } else if (n.element.compareTo(element) == 0) {//if equals
                if (n.left == null) {
                    n.left = new Node(element);
                    ok = true;
                } else {
                    n = n.left;
                }
            } else if (n.element.compareTo(element) < 1) {//if bigger
                if (n.right == null) {
                    n.right = new Node(element);
                    ok = true;
                } else {
                    n = n.right;
                }
            }
        }

    }

    //7. Escreva um método que retorna verdadeiro se uma árvore é binária de busca e falso caso
    //contrário.
    public boolean isSearchTree(Node n) {
        boolean ok = true;

        if (n == null) {
            return false;
        }

        if (n.left != null) {
            if (n.element.compareTo(n.left.element) >= 0) {
                ok = isSearchTree(n.left);
            } else {
                return false;
            }
        }

        if (n.right != null) {
            if (n.element.compareTo(n.right.element) < 1) {
                ok = isSearchTree(n.right);
            } else {
                return false;
            }
        }

        return ok;
    }

    //8. Escreva um método que permita remover elementos de uma árvore binária de busca.
    public void removeNode(String element) {
        //unfinished
    }

    //9. Escreva um programa que converte uma árvore binária em uma árvore binária de busca.
    public BinarySearchTree toBinarySearchTree(BinaryTree binaryTree) {
        BinarySearchTree bst = null;
        ArrayList<Node> l = binaryTree.inOrderArray(binaryTree.getRoot());
        
        //for(Node n: binaryTree.inOrderArray(binaryTree.getRoot())){
        for(int i = 0; i <= (l.size() - 1); i++){
            if(bst == null){
                bst = new BinarySearchTree(l.get(i).element);
            }else{
                bst.addNode(l.get(i).element);
            }       
        }
        
        return bst;
    }

    //10. Escreva um algoritmo que cria uma imagem espelho de uma árvore binária, isto é, todos os
    //filhos à esquerda tornam-se filhos à direita, e vice-versa
    public BinarySearchTree mirror(BinarySearchTree tree) {
        return null;//unfinished
    }

}
