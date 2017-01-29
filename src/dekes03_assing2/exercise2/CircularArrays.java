package dekes03_assing2.exercise2;

import java.util.Iterator;

/**
 * An interface representing a queue.
 * It support for enqueue and dequeue object from the queue.
 * <p/>
 * The class uses a head to tail method.
 * <p/>
 */

/**
 * Created by Daniel Ekerot on 2016-05-30.
 */


public class CircularArrays implements IQueue {

    public Object[] buff;
    public int read, write;

    /**
     * Constructor for class <code>LinkedQueue</code>
     * <p/>
     * <code>size, head, tail</code> initialized
     */

    public CircularArrays() {

        buff = new Object[100];
        write = 0;
        read = 0;

    }

    /**
     * Method for returning <code>size</code> of queue
     *
     * @return int
     */

    @Override
    public int size() {
        return buff.length;
    }

    /**
     * Method for determine if queue is empty
     *
     * @return boolean
     */

    @Override
    public boolean isEmpty() {
        return false;
    }

    /**
     * Method for adding objects into the queue.
     * the enqueue method adiing the new object in its proper place in the queue.
     * Adding new size for every objects added.
     */

    @Override
    public void enqueue(Object element) {


            if ( read == ( write + 1 ) % (buff.length) )
            {
                throw new ArrayIndexOutOfBoundsException();
            }

            buff[write] = element;                 // Store x in buf at write pointer
            write = (write+1)%(buff.length); // Advance the write pointer


    }

    /**
     * Method returning and removing the first object in the queue.
     * <p/>
     * Throws <code>IlligalArgumentException</code> if the queue is empty.
     *
     * @return Object
     */

    @Override
    public Object dequeue() {

        Object r;   // Variable used to save the return value

        if ( read == write ) {
        }

        r = buff[read];                 // Save return value
        read = (read+1)%(buff.length);  // Advance the read pointer

        return r;

    }

    /**
     * Method returning the first object in the queue.
     * <p/>
     * Throws <code>IlligalArgumentException</code> if the queue is empty.
     *
     * @return Object
     */

    @Override
    public Object first() throws IllegalArgumentException {

        if (isEmpty()) {
            throw new IllegalArgumentException();

        }

        return null;

    }

    /**
     * Method returning the last object in the queue.
     * <p/>
     * Throws <code>IlligalArgumentException</code> if the queue is empty.
     *
     * @return Object
     */

    @Override
    public Object last() throws IllegalArgumentException {

        if (isEmpty()) throw new IllegalArgumentException();

        return null;
    }

    /**
     * Iterator method returning objects int the queue iterated.
     *
     * @return Iterator
     */

    @Override
    public Iterator iterator() {
        return new QueueIterator();
    }

    /**
     * Returning the queue in a proper way.
     *
     * @return String
     */

    public String toString() {

        String str = "";

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
     * <p/>
     * Method remove() not in use.
     * <p/>
     * Throws <code>IllegalArgumentException</code>
     */

    public class QueueIterator implements Iterator {


        public boolean hasNext() {

            return false;


        }

        public Object next() {

            if (isEmpty()) {
                throw new IllegalArgumentException();
            }

            return null;

        }

        /**
         * Method not in use.
         * <p/>
         * Throws <code>UnsupportedoperationException</code>
         */

        @Override
        public void remove() {
            throw new UnsupportedOperationException();

        }

    }
}

