/*
 * IntList.java
 * Date: 23 nov 2007
 * Author: Jonas Lundberg
 */
package dekes03_assing1.exercise1;

import java.lang.IndexOutOfBoundsException;


/* A simple interface describing an integer list. 
   Updated with exceptions 2015-09-17. */

public interface IntList extends Iterable<Integer> {
    /* Add integer n to the end of the list. */
    void add(int n);

    /* Inserts integer n at position index. Shifts the element currently at that
     * position (if any) and any subsequent elements to the right.  */
    void addAt(int n, int index) throws IndexOutOfBoundsException;

    /* Remove integer at position index. */
    void remove(int index) throws IndexOutOfBoundsException;

    /* Get integer at position index. */
    int get(int index) throws IndexOutOfBoundsException;

    /* Number of integers currently stored. */
    int size();

    /* Returns true if collection is empty. */
    boolean isEmpty();

    /* Find position of integer n, otherwise return -1 */
    int indexOf(int n);

    /* String of type "[ 7 56 -45 68 ... ]" */
    String toString();
}
