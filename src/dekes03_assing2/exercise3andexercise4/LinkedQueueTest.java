package dekes03_assing2.exercise3andexercise4;

import dekes03_assing2.exercise1.LinkedQueue;
import dekes03_assing2.exercise2.CircularQueue;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.assertEquals;

/**
 * Created by ekerot on 2017-02-10.
 */

// I will not comment the test though they are self explanatory
// If switching between LinkedQueue test and CicularQueue test just comment out
// and uncomment the tests you want to perform

public class LinkedQueueTest {

    @Test
    public void testSize() {

        LinkedQueue test = new LinkedQueue();
        //CircularQueue test = new CircularQueue();

        assertEquals(0, test.size());

        test = build(100);
        //test = buildQueue(100);

        assertEquals(100, test.size());

        //------ Only Linked queue ------

        test = build(99999);

        assertEquals(99999, test.size());
    }

    @Test
    public void testIsEmpty() {

        LinkedQueue test = new LinkedQueue();
        //CircularQueue test = CircularQueue();

        assertEquals(true, test.isEmpty());

    }

    @Test
    public void testEnqueue() {

        LinkedQueue test = new LinkedQueue();
        //CircularQueue test = new CircularQueue();

        test.enqueue(123);

        assertEquals(123, test.first());


        test = build(10);
        //test = buildQueue(10);

        assertEquals(0, test.first());
        assertEquals(9, test.last());

        test.enqueue(999999999);

        assertEquals(0, test.first());
        assertEquals(999999999, test.last());

        //------------Only for LinkedQueue ----------

        test = build(1000);

        assertEquals(0, test.first());
        assertEquals(999, test.last());

    }

    @Test
    public void testDequeue(){

        LinkedQueue test = build(10);
        //CircularQueue test = buildQueue(10);

        test.dequeue();
        assertEquals(1, test.first());

        test.dequeue();
        assertEquals(2, test.first());

        //-------Only Linked Queue ------

        test = build(1000);

        test.dequeue();
        assertEquals(999, test.last());

    }

    @Test
    public void testIterator(){

        LinkedQueue test = build(10);
        //CircularQueue test = buildQueue(10);

        Iterator<Object> iterator = test.iterator();

        int testNumbers = 0;

        while (iterator.hasNext()) {

            Object o = iterator.next();
            assertEquals(testNumbers++, o);

        }

    }

    @Test
    public void testToString()
    {
        LinkedQueue test = new LinkedQueue();
        //CircularQueue test = new CircularQueue();

        for(int i = 1; i < 6; i++){
            test.enqueue(i);
        }

        String expected = "1\n2\n3\n4\n5\n";
        assertEquals(expected, test.toString());
    }

    @Test (expected = IllegalArgumentException.class)
    public void forceExceptionLastInt(){

        LinkedQueue test = new LinkedQueue();
        //CircularQueue test = new CircularQueue();

        test.last();
    }

    @Test (expected = IllegalArgumentException.class)
    public void forceExceptionFirstInt(){

        LinkedQueue test = new LinkedQueue();
        //CircularQueue test = new CircularQueue();
        test.first();

    }

    @Test (expected = IllegalArgumentException.class)
    public void forceExceptionDequeueInt(){

        LinkedQueue test = new LinkedQueue();
        //CircularQueue test = new CircularQueue();
        test.dequeue();

    }

    //--------------- Test only for Circular Queue comment out when testing LinkedQueue----------------

    /*
    @Test (expected = IllegalArgumentException.class)
    public void forceExceptionEnqueueInt(){


        CircularQueue test = buildQueue(100);
        test.enqueue(12);

    }
    */

    //--------------------- Help methods ------------------------------------

    private LinkedQueue build(int size) {
        LinkedQueue linkedQueue = new LinkedQueue();
        for (int i=0;i<size;i++)
            linkedQueue.enqueue(i);
        return linkedQueue;
    }

    private CircularQueue buildQueue(int size) {
        CircularQueue circularQueue = new CircularQueue();
        for (int i=0;i<size;i++) {
            circularQueue.enqueue(i);
        }
        return circularQueue;
    }
}



