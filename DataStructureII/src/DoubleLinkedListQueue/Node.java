/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DoubleLinkedListQueue;
/**
 *
 * @author 1511 FOX
 */
public class Node {
    
    public Node prev;
    public int element;
    public Node next;

    public Node(Node p, int e, Node n) {
        this.prev = p;
        this.element = e;
        this.next = n;
    }
    
    public String toString(){
        String s = "";
        if (this.prev != null) {
            s += " <- ";
        }
        s += "[" + this.element + "]";
        if (this.next != null) {
            s += " -> ";
        }

        return s;
    }
}
