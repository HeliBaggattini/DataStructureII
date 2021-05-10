/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExamI.test;

import ExamI.BinaryTree;
import ExamI.Node;

/**
 *
 * @author 1511 FOX
 */
public class BTTest {

    public static void main(String[] args) {

        //initializes the tree
        BinaryTree bt = new BinaryTree();
        //creates the tree using '(A(B)(C(D(G)(H))(F(I))))' as input
        bt = bt.createTree("(A(B)(C(D(G)(H))(F(I))))");
        
        
        //prints the tree following in-order walking
        bt.inOrder();
        
        
        //converts the tree to an array
        Node[] array = bt.BinaryToArray(bt);
        //prits the tree following the template "['index';'values'] " 
        int i = 0;
        for (Node nd : array) {
            if (nd != null) {
                System.out.print("[" + i + ";" + nd.element + "] ");
            }
            i++;
        }
        
        System.out.println("");
    }
}
