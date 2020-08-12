/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BinaryTree;

/**
 *
 * @author 1511 FOX
 */
public class BinaryTree {

    Node root;

    public BinaryTree(String root) {
        this.root = new Node(root);
    }

    public Node addChildRight(Node parent, String value) throws Exception {
        if (parent.right == null) {
            Node n = new Node(value);
            n.parent = parent;
            parent.right = n;

            return n;
        } else {
            throw new Exception("cannot add (right child already exists)");
        }
    }

    public Node addChildLeft(Node parent, String value) throws Exception {
        if (parent.left == null) {
            Node n = new Node(value);
            n.parent = parent;
            parent.left = n;

            return n;
        } else {
            throw new Exception("cannot add (left child already exists)");
        }
    }

    public Node getRoot() {
        return this.root;
    }
    
    public int count(Node n){
        int count = 1;
        
        if(n == null){
            return 0;
        }else{
            count += count(n.left);
            count += count(n.right);
            return count;
        }
    }

}
