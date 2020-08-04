/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinkedList;

/**
 *
 * @author 1511 FOX
 */
public class List {

    protected Node header;
    protected int size;

    public List() {
        this.header = null;
        this.size = 0;
    }

    public Node first() {
        return header;
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

    public Node last() {
        Node n = first();

        while (n != null && n.next != null) {
            n = n.next;
        }

        return n;
    }

    public int size() {
        return size;
    }

    public void insert(int e) {
        Node l = last();
        Node i = new Node(e, null);
        l.next = i;
        this.size++;
    }

    public void insertFirst(int e) {
        this.header = new Node(e, this.header);
        this.size++;

    }

    public void insertAfter(Node n, int e) {
        Node i = new Node(e, n.next);
        n.next = i;
        this.size++;
    }
    
    public void remove(int e){
        Node prev = null;
        Node n = first();

        while (n != null) {
            if (n.element == e) {
                if(prev == null){
                    header = n.next;
                    break;
                }else{
                    prev.next = n.next;
                    break;
                }
            } else {
                prev = n;
                n = n.next;
            }
        }
    }

    @Override
    public String toString() {
        String s = "";
        Node n = first();

        while (n != null) {
            s += n.toString();
            n = n.next;
        }

        return s;
    }

}
