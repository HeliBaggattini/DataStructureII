/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DoubleLinkedListQueue.test;

import DoubleLinkedListQueue.Queue;


/**
 *
 * @author 1511 FOX
 */
public class Qtest {

    public static void main(String[] args) {
        Queue q = new Queue();

        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);
        q.enqueue(6);
        
        System.out.println("queue: " + q);
        System.out.println("fist: " + q.first());
        System.out.println("last: " + q.last());
        System.out.println("find(3): " + q.find(3));
        
        q.enqueue(10);
        
        System.out.println("queue: " + q);
        
        q.dequeue();
        q.dequeue();
        q.dequeue();
        q.dequeue();
        q.dequeue();
        q.dequeue();
        q.dequeue();

        System.out.println("queue: " + q);
    }

}
