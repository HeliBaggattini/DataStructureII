/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stack;

/**
 *
 * @author 1511 FOX
 */
public class Stack {

    private Node top;
    private int size;

    public Stack() {
        this.top = null;
    }

    public Node peek() {
        return top;
    }

    public Node pop() throws Exception {

        if (this.top != null) {
            this.top = this.top.next;
            this.size--;

            return top;
        }
        throw new Exception("cannot remove (empty stack)");

    }

    public void push(int n) {

        this.top = new Node(n, this.top);
        
        this.size++;

    }
    
    public int size(){
        return this.size;
    }

    @Override
    public String toString() {
        String s = "";
        Node n = this.top;

        while (n != null) {
            s += n.toString();
            n = n.next;
        }

        return s;
    }

}
