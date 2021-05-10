/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExamI;

import java.util.Stack;

/**
 *
 * @author 1511 FOX
 */
public class BinaryTree {

    private Node root;

    //empty constructor
    public BinaryTree() {
    }

    //private constructor
    private BinaryTree(Node value) {
        this.root = value;
    }

    //creates a tree using a String as input
    public BinaryTree createTree(String s) {
        return new BinaryTree(treeConstructor(this.root, s));
    }

    //build the tree recursively node by node
    private Node treeConstructor(Node n, String s) {
        //Node used as cursor
        Node node = n;

        //verify the input String s
        if (s == null || s.isEmpty()) {
            return null;
        }

        //remove the parent pareteses
        if (s.charAt(0) == '(') {
            s = s.substring(1, s.length() - 1);
        }

        //create the new node
        node = new Node(s.substring(0, 1));
        node.parent = n;//set the node's parent

        //indexing the left child portion of the string
        int leftNodeStart, leftNodeEnd;
        leftNodeStart = leftNodeEnd = 2;

        if (s.length() > leftNodeStart) {//if there's value for the left node
            //tracking the opening and closing of the parenteses
            int openIndex = 1;
            int closeIndex = 0;

            //verifing the sintax integrity
            while (openIndex != closeIndex) {
                
                if (s.charAt(leftNodeEnd) == '(') {
                    openIndex++;
                } else if (s.charAt(leftNodeEnd) == ')') {
                    closeIndex++;
                }
                
                leftNodeEnd++;
            }

            //recursive for left
            node.left = treeConstructor(node, s.substring(leftNodeStart, leftNodeEnd - 1));
        }
        if (leftNodeEnd < s.length()) {//if reaches the end of the left node 
            //recursive to right
            node.right = treeConstructor(node, s.substring(leftNodeEnd + 1, s.length() - 1));
        }

        //returing the node
        return node;

    }

    //printing in a non-recursive way the binary tree in-order using a Stack
    public void inOrder() {
        Stack<Node> stack = new Stack();
        Node n = this.root;
        while (!stack.empty() || n != null) {
            if (n != null) {
                stack.push(n);
                n = n.left;
            } else {
                n = stack.pop();
                System.out.print(n.element + " ");
                n = n.right;
            }
        }
        System.out.print("\n");
    }

    public Node[] BinaryToArray(BinaryTree bt) {
        //creates an array using the tree's maximum possible size based on the it's height
        Node[] array = new Node[(int) Math.pow(2, height(bt.getRoot()) + 1)];
        
        //uses a Stack to walk on the tree in a non-recursive way
        Stack<Node> stack = new Stack();
        Node n = bt.getRoot();

        while (!stack.empty() || n != null) {
            if (n != null) {
                stack.push(n);
                n = n.left;
            } else {
                n = stack.pop();
                array[index(n)] = n;
                n = n.right;
            }
        }

        return array;
    }

    //return the root of the tree
    public Node getRoot() {
        return this.root;
    }

    //calculates the height of the tree
    public int height(Node n) {
        if (n.isExternal()) {
            return 0;
        }

        int l = 0, r = 0;
        if (n.left != null) {
            l = height(n.left);
        }
        if (n.right != null) {
            l = height(n.right);
        }
        return Math.max(l, r) + 1;
    }

    //return the index of a given Node
    public int index(Node n) {
        if (n.parent == null) {
            return 1;
        }
        if (n == n.parent.left) {
            return (2 * index(n.parent));
        } else {
            return (2 * index(n.parent) + 1);
        }
        
    }
    
}
