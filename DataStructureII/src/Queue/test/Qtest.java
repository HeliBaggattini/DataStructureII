/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Queue.test;

import Queue.Queue;

/**
 *
 * @author 1511 FOX
 */
public class Qtest {
    public static void main(String[] args) {
        Queue q = new Queue();
        
        System.out.println(q + "\n");
        
        q.enqueue(0);
        q.enqueue(1);
        q.enqueue(2);
        
        System.out.println("adding the 3 fist elements...");
        System.out.println(q + "\n");
        
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);
        
        System.out.println("adding the next 3 elements...");
        System.out.println(q + "\n");
        
        q.dequeue();
        q.dequeue();
        q.dequeue();
        
        System.out.println("removing the 3 fist elements...");
        System.out.println(q + "\n");
        
        q.dequeue();
        q.dequeue();
        q.dequeue();
        
        System.out.println("removing the next 3 elements...");
        System.out.println(q + "\n");

    }
}
