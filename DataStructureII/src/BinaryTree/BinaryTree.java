/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BinaryTree;

import java.util.ArrayList;

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

    public int count(Node n) {
        int count = 1;

        if (n == null) {
            return 0;
        } else {
            count += count(n.left);
            count += count(n.right);
            return count;
        }
    }

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

    public String print(Node n) {
        String s = "";
        if (n != null) {
            s = n.toString() + " ";
            if (n.left != null) {
                s += print(n.left);
            }
            if (n.right != null) {
                s += print(n.right);
            }
        }
        return s;
    }

    public int depht(Node n) {
        if (n.isRoot()) {
            return 0;
        } else {
            return 1 + depht(n.parent);
        }
    }

    public int leafs(Node n) {
        int count = 0;
        if (n.isExternal()) {
            return 1;
        } else {
            if (n.left != null) {
                count += leafs(n.left);
            }
            if (n.right != null) {
                count += leafs(n.right);
            }
        }

        return count;
    }

    public int cores(Node n) {
        int count = 0;

        if (n.isExternal()) {
            return 0;
        } else {
            if (!n.isRoot()) {
                count++;
            }
            if (n.left != null) {
                count += cores(n.left);
            }
            if (n.right != null) {
                count += cores(n.right);
            }
            return count;
        }
    }

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

    public String postOrder(Node n) {
        String s = "";

        if (n != null) {
            if (n.left != null) {
                s = postOrder(n.left);
            }

            if (n.right != null) {
                s += postOrder(n.right);
            }

            s += n.element + " ";
        }

        return s;
    }

    public String inOrder(Node n) {
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
    
    public ArrayList<Node> inOrderArray(Node n) {
        ArrayList<Node> s = new ArrayList<Node>();

        if (n != null) {
            if (n.left != null) {
                s.addAll(inOrderArray(n.left));
            }

            s.add(n);

            if (n.right != null) {
                s.addAll(inOrderArray(n.right));
            }
        }

        return s;
    }
}
