package dekes03_assing2.exercise3;

import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

/**
 * Created by ekerot on 2016-06-13.
 */
public class LinkedQueueTest {

    @Test
    public void testIsEmpty() {

        IQueue queInt = new LinkedQueue();

        assertEquals(true, queInt.isEmpty());
        assertEquals(0, queInt.size());

    }

    @Test
    public void testQueueOneValue() {

        IQueue queInt = new LinkedQueue();

        queInt.enqueue(123);

        assertEquals(123, queInt.first());
        assertEquals(123, queInt.last());


        Iterator iterator = queInt.iterator();
        while(iterator.hasNext()){

            assertEquals(123, iterator.next());

        }

        assertEquals(123, queInt.dequeue());

    }

    @Test
    public void testQueueSeveralValues() {

        IQueue queInt = new LinkedQueue();
        int[] values = {123,432,345,432,456};

        for(int i = 0; i < values.length; i++){

            queInt.enqueue(values[i]);

        }

        assertEquals(123, queInt.first());
        assertEquals(456, queInt.last());


        Iterator iterator = queInt.iterator();
        int j = 0;

        while(iterator.hasNext()){

            assertEquals(values[j], iterator.next());
            j++;

        }

        for(int i = 0; i < values.length; i++){

            assertEquals(values[i], queInt.dequeue());

        }

    }


    @Test (expected = IllegalArgumentException.class)
    public void forceExceptionLastInt(){

        IQueue queInt = new LinkedQueue();

        int foo = (int) queInt.last();


    }

    @Test (expected = IllegalArgumentException.class)
    public void forceExceptionFirstInt(){

        IQueue queInt = new LinkedQueue();

        int foo = (int) queInt.first();

    }

    @Test (expected = IllegalArgumentException.class)
    public void forceExceptionDequeueInt(){

        IQueue queInt = new LinkedQueue();

        int foo = (int) queInt.dequeue();

    }

}

