package dekes03_assing2.exercise1;

import java.util.Iterator;

/**
 * Created by ekerot on 2016-06-11.
 */
public class QueueMain {

    public static void main(String[] args) {

        LinkedQueue test1 = new LinkedQueue();
        int n = 12;

        for (int i = 0; i < 4; i++) {
            test1.enqueue(n);
            n = n + 6;
        }

        System.out.println("Queue:\n" + test1);

        System.out.println("Dequeued:\n" + test1.dequeue());

        System.out.println("");

        System.out.println("Queue:\n" + test1);

        System.out.println("Last in queue: " + test1.last());

        System.out.println("First in queue: " + test1.first());

        System.out.println("");

        System.out.println("Iterate:");

        Iterator<Object> iterator = test1.iterator();

        while (iterator.hasNext()) {

            Object o = iterator.next();
            System.out.println(o);

        }


    }
}
