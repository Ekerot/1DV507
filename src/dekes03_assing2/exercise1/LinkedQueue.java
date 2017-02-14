package dekes03_assing2.exercise1;

import java.util.Iterator;

/**
 * An interface representing a queue.
 * It support for enqueue and dequeue object from the queue.
 * <p>
 * The class uses a head to tail method.
 * <p>
 */

/**
 * Created by Daniel Ekerot on 2017-02-01.
 */


public class LinkedQueue implements IQueue {

    private int size;               //current size
    private Node head;           //First element
    private Node tail;           //Last element

    /**
     * Constructor for class <code>LinkedQueue</code>
     * <p>
     * <code>size, head, tail</code> initialized
     */

    public LinkedQueue() {

        size = 0;
        head = null;
        tail = null;
    }

    /**
     * Method for returning <code>size</code> of queue
     *
     * @return int
     */

    @Override
    public int size() {
        return size;
    }

    /**
     * Method for determine if queue is empty
     *
     * @return boolean
     */

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Method for adding objects into the queue.
     * the enqueue method adiing the new object in its proper place in the queue.
     * Adding new size for every objects added.
     */

    @Override
    public void enqueue(Object element) {

        if (isEmpty()) {

            head = new Node(element);
            tail = head;

        } else

        {

            tail.next = new Node(element);
            tail = tail.next;
        }
        size++;

    }

    /**
     * Method returning and removing the first object in the queue.
     * <p>
     * Throws <code>IlligalArgumentException</code> if the queue is empty.
     *
     * @return Object
     */

    @Override
    public Object dequeue() {

        if (isEmpty()) {
            throw new IllegalArgumentException();

        }

        Object temp = head.value;

        head = head.next;

        return temp;
    }

    /**
     * Method returning the first object in the queue.
     * <p>
     * Throws <code>IlligalArgumentException</code> if the queue is empty.
     *
     * @return Object
     */

    @Override
    public Object first() throws IllegalArgumentException {

        if (isEmpty()) {
            throw new IllegalArgumentException();

        }
        return head.value;
    }

    /**
     * Method returning the last object in the queue.
     * <p>
     * Throws <code>IlligalArgumentException</code> if the queue is empty.
     *
     * @return Object
     */

    @Override
    public Object last() throws IllegalArgumentException {

        if (isEmpty()) throw new IllegalArgumentException();

        return tail.value;
    }

    /**
     * Iterator method returning objects int the queue iterated.
     *
     * @return Iterator
     */

    @Override
    public Iterator<Object> iterator() {
        return new QueueIterator();
    }

    /**
     * Returning the queue in a proper way.
     *
     * @return String
     */

    public String toString() {

        String str = "";
        Node current = head;

        while (current != null) {
            str = str + (current.value).toString() + "\n";
            current = current.next;
        }
        return str;
    }

    /**
     * Initializing values in the Node class for use int the LinkedQueue class.
     */

    private class Node {

        Object value;
        Node next = null;

        Node(Object v) {
            value = v;

        }
    }

    /**
     * QueueIterator class implementing Iterator.
     * Using methods hasNext() and next() to iterating the queue.
     * <p>
     * Method remove() not in use.
     * <p>
     * Throws <code>IllegalArgumentException</code>
     */

    public class QueueIterator implements Iterator {

        private Node temp = head;

        public boolean hasNext() {

            return temp != null;

        }

        public Object next() {

            if (isEmpty()) {
                throw new IllegalArgumentException("Something went wrong!");
            }

            Object element = temp.value;
            temp = temp.next;

            return element;

        }

        /**
         * Method not in use.
         * <p>
         * Throws <code>UnsupportedOperationException</code>
         */

        @Override
        public void remove() {
            throw new UnsupportedOperationException();

        }
    }
}

