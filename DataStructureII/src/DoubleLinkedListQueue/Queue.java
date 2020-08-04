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
public class Queue {

    protected Node header, trailer;
    protected int size;

    public Queue() {
        this.header = this.trailer = null;
        this.size = 0;
    }

    public Node first() {
        return this.header;
    }

    public Node last() {
        return this.trailer;
    }

    public void enqueue(int e) {
        if (this.size == 0) {
            Node n = new Node(null, e, null);
            this.header = this.trailer = n;
        } else {
            Node old = this.trailer;
            Node n = new Node(old, e, null);
            old.next = n;
            this.trailer = n;
        }

        this.size++;

    }

    public void dequeue() {
        if (this.size == 0) {
            System.out.println("empty queue");
        } else if (this.size == 1) {
            this.header = this.trailer = null;
        } else {
            Node old = this.header;
            this.header = old.next;
            this.header.prev = old.prev;
        }

        this.size--;
    }

    public Node find(int e) {
        Node n = first();

        while (n != null) {
            if (n.element == e) {
                break;
            } else {
                n = n.next;
            }
        }

        return n;

    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        String s = "";
        Node n = first();

        if (this.size == 0) {
            s = "empty queue";
        } else {

            while (n != null) {
                s += n.toString();
                n = n.next;
            }
        }

        return s;

    }
}
