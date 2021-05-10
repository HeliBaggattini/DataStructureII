/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArithmeticTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 *
 * @author 1511 FOX
 */
// ArithmeticTree at = ArithmeticTree.createFormula("* a 2");
// at.define("a", 3.2);
// double e = at.evaluate();
// System.out.println(at.serialize());
public class ArithmeticTree {

    private HashMap<String, Double> values = new HashMap<>();
    private Node root;

    // private constructor: cannot be called outside of this class
    private ArithmeticTree(Node value) {
        this.root = value;
    }

    // creates the default arithmetic tree: "+ * a 2.1 - 3 b"
    public static ArithmeticTree createDefault() {

        //default expression
        String def = "+ * a 2.1 - 3 b";

        //reusing the method that creates a tree based on a given expression
        return createFormula(def);
    }

    //auxiliar method that populates the tree
    private Node populateTree(Node n, ArrayList<String> list) {
        //node used as cursor
        Node node = n;

        //verify if the list  is not empty
        if (!list.isEmpty()) {

            //creating the new node
            node = new Node(list.get(0));
            node.parent = n;
            list.remove(0);

            //verify if the node is a number(if will be a leaf)
            if (!isOperator(node.element)) {
                return node;
            }

            node.left = populateTree(node, list);//recursive to left
            node.right = populateTree(node, list);//recursive to right

        }

        //returnin the node
        return node;
    }

    //verify if the given simbol is or not an operator
    private static boolean isOperator(String op) {
        boolean ok = false;

        if (op.equals("+") || op.equals("-") || op.equals("*") || op.equals("/") || op.equals("^")) {
            ok = true;
        }

        return ok;
    }

    // deserializes the string "s" and returns a new tree
    public static ArithmeticTree createFormula(String s) {

        ArrayList<String> list = new ArrayList<>(Arrays.asList(s.split(" ")));
        ArithmeticTree at = new ArithmeticTree(null);

        return new ArithmeticTree(at.populateTree(at.root, list));
    }

    // serializes tree into a string
    public String serialize() {
        return inOrder(this.root);
    }

    // defines a variable "var" with value "val"
    public void define(String var, double val) {
        if (!this.values.containsKey(var)) {
            this.values.put(var, val);
        } else {
            this.values.replace(var, this.values.get(var), val);
        }
    }

    // evaluates the tree
    public double evaluate(Node n) throws Exception {

        double left, right;

        //empty tree
        if (n == null) {
            throw new Exception("Empty tree");
        }

        //only one node
        if (n.left == null && n.right == null) {
            try {
                if (this.values.get(n.element) != null) {
                    return this.values.get(n.element);
                } else {
                    return Double.parseDouble(n.element);
                }
            } catch (NumberFormatException e) {
                throw e;
            }
        }

        //evaluate left tree 
        left = evaluate(n.left);

        //evaluate right tree 
        right = evaluate(n.right);

        //check which operation to apply
        switch (n.element) {
            case "+":
                return left + right;
            case "-":
                return left - right;
            case "*":
                return left * right;
            case "/":
                return left / right;
            default:
                return Math.pow(left, right);
        }

    }

    //return the root element
    public Node getRoot() {
        return this.root;
    }

    //pre order impression (for test only)
    public String preOrder(Node n) {
        String s = "";

        if (n != null) {
            s = n.element + "  ";

            if (n.left != null) {
                s += preOrder(n.left);
            }

            if (n.right != null) {
                s += preOrder(n.right);
            }
        }
        return s;

    }

    //return the tree in form of a string with the given expression
    private String inOrder(Node n) {
        String s = "";

        if (n != null) {
            if (n.left != null) {
                s = inOrder(n.left);
            }

            s += n.element + "  ";

            if (n.right != null) {
                s += inOrder(n.right);
            }
        }

        return s;
    }

}
