/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExamI;

/**
 *
 * @author 1511 FOX
 */
public class Node {
    public String element;
    public Node parent;
    public Node right = null;
    public Node left = null;

    public Node(String value) {
        this.element = value;
    }

    public boolean isInternal() {
        boolean ok = false;
        if (this.right != null || this.left != null) {
            ok = true;
        }
        return ok;
    }

    public boolean isExternal() {
        boolean ok = false;
        if (this.right == null && this.left == null) {
            ok = true;
        }
        return ok;
    }

    public boolean isRoot() {
        boolean ok = false;
        if (this.parent == null) {
            ok = true;
        }
        return ok;
    }

    @Override
    public String toString() {
        return this.element;
    }
}
