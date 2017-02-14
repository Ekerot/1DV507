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
 * Created by Daniel Ekerot on 2017-02-08.
 */


public class CircularQueue implements IQueue {

    private int maxSize;
    private Object[] queue;
    private int first = 0, last = 0, amount = 0;

    /**
     * Constructor for class <code>CircularQueue</code>
     * <p/>
     * <code>front, rear, max, amount, queue</code> initialized
     */

    public CircularQueue() {
        maxSize = 100;
        this.queue = new Object[maxSize];
    }

    /**
     * Method for returning <code>size</code> of queue
     *
     * @return int
     */

    @Override
    public int size() {

        return amount;
    }

    /**
     * Method for determine if queue is empty
     *
     * @return boolean
     */

    @Override
    public boolean isEmpty() {
        return (amount == 0);
    }

    /**
     * Method for adding objects into the queue.
     * the enqueue method adding the new object in its proper place in the queue.
     * Adding new size for every objects added.
     */

    @Override
    public void enqueue(Object element) {

        if (last == maxSize)
            last = 0;

        if (first == last && this.isEmpty() == false) {
            throw new IllegalArgumentException("Array is full!");
        }

        queue[last] = element;
        amount++;
        last++;

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

        if(this.isEmpty()){
            throw new IllegalArgumentException("Array is Empty!");
        }

        Object temp = queue[first];
        queue[first] = null;
        amount--;
        first++;

        return temp;
    }

    /**
     * Method returning the first object in the circular queue.
     * <p/>
     * Throws <code>IlligalArgumentException</code> if the queue is empty.
     *
     * @return Object
     */

    @Override
    public Object first() throws IllegalArgumentException {

        if (isEmpty()) throw new IllegalArgumentException();

        return queue[first];
    }

    /**
     * Method returning the last object in the circular queue.
     * <p/>
     * Throws <code>IlligalArgumentException</code> if the queue is empty.
     *
     * @return Object
     */

    @Override
    public Object last() throws IllegalArgumentException {

        if (isEmpty()) throw new IllegalArgumentException();

        return queue[last-1];
    }

    /**
     * Iterator method returning objects int the circular queue iterated.
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

        for(int i = first; i < queue.length; i++){
            if(queue[i] == null){
            }
            else {
                str = str + queue[i] + "\n";
            }


        }
        if(first != 0) {
            for (int j = 0; j < first; j++) {
                if(queue[j] == null){
                }
                else {
                    str = str + queue[j] + "\n";
                }
            }
        }
        return str;
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

