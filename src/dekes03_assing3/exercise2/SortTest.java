package dekes03_assing3.exercise2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Comparator;

/**
 * Created by ekerot on 2017-02-14.
 */

public class SortTest {

    int[] intTest;
    String[] alphabeticalTest;
    Comparator<String> alphabetical;
    SortingAlgorithms test;

    @Before  // before test create Comparable method and arrays to use in test
    public void initialize() {
        intTest = new int[]{4, 56, 2, 7, 56, 9, 5, 2, 7, 45, 1, 1, 3, 5, 12, 65, 3, 4};

        alphabeticalTest = new String[]{"d", "a", "h", "f", "b"};

        alphabetical = (String firstChar, String secondChar)
                -> Character.compare(secondChar.charAt(0), firstChar.charAt(0));

        test = new SortingAlgorithms();
    }

    @Test
    public void testInsertionSort(){  //test both insertion sorts

        int[] sorted = {1,1,2,2,3,3,4,4,5,5,7,7,9,12,45,56,56,65};

        Assert.assertArrayEquals(sorted, test.insertionSort(intTest));

        String[] alphabeticalSorted = {"a", "b", "d", "f", "h"};

        Assert.assertArrayEquals(alphabeticalSorted, test.insertionSort(alphabeticalTest, alphabetical));
    }

    @Test
    public void testMergeSort(){ // test the two merge sorts

        int[] sorted = {1,1,2,2,3,3,4,4,5,5,7,7,9,12,45,56,56,65};

        Assert.assertArrayEquals(sorted, test.mergeSort(intTest));

        String[] alphabeticalSorted = {"a", "b", "d", "f", "h"};

        Assert.assertArrayEquals(alphabeticalSorted, test.mergeSort(alphabeticalTest, alphabetical));

    }
}
