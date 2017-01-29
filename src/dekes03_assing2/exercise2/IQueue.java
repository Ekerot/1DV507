package dekes03_assing2.exercise2;

import java.util.Iterator;

/**
 * Created by ekerot on 2016-05-31.
 */
public interface IQueue {

    int size();                     // current queue size

    boolean isEmpty();              // true if queue is empty

    void enqueue(Object element);   // add element at end of queue

    Object dequeue();               // return and remove first element.

    Object first() throws IllegalArgumentException;                 // return (without removing) first element

    Object last() throws IllegalArgumentException;                  // return (without removing) last element

    String toString();              // return a string representation of the queue content

    Iterator iterator();            // element iterator
}

