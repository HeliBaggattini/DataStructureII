/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Queue;

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
        return header;
    }

    public Node last() {
        return trailer;
    }

    public int size() {
        return size;
    }

    public void enqueue(int e) {
       
        if (size != 0) {
            Node l = last();
            Node i = new Node(e, null);
            l.next = i;
            this.trailer = i;
        } else {
            this.header = this.trailer = new Node(e, this.header);
        }
        this.size++;
    }

    public void dequeue() {
        this.header = first().next;
        this.size--;
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
