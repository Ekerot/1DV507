package dekes03_assing3.exercise2;

import java.util.Comparator;

/**
 * Created by ekerot on 2017-02-14.
 */
public class SortingAlgorithms {

    // I had to make a insertsort in another course but in Phyton,
    // I used that algorithm and translated it into java.
    public int[] insertionSort(int[] in){

        for(int i = 0; i < in.length; i++){
            int temp = in[i];
            int j = i;

            //while j is higher then 0 and in[j-1 is hight then in[i]
            //iterate throw array and sort it
            while(j > 0 && in[j-1] > temp){

                in[j] = in[j-1];
                j = j-1;
                in[j] = temp;
            }
        }
        return in;
    }

    // fo the merge sort i looked in the book
    public int[] mergeSort(int[] in){

        // split into left and right
        int[] left = new int[in.length / 2];
        int[] right = new int[in.length - left.length];

        if(in.length <= 1) return null;

        for (int i = 0; i < left.length; i++) {
            left[i] = in[i];
        }

        for (int i = 0; i < right.length; i++) {
            right[i] = in[left.length + i]; //starts where the left branch ends
        }

        // run them through mergeSort and merge
        mergeSort(left);
        mergeSort(right);

        mergeInt(left, right, in);

        return in;
    }

    public String[] insertionSort(String[] in, Comparator<String> c) {

        String[] list = in;

        for (int j = 1 ; j < list.length ; j++) {
            String item = list[j];
            int i = j;

            // use comparator instad of the "traditional" way
            // run aslong as i is bigger then 0 and
            // the int value gotten from comparing the two words is negative
            while (i > 0 && c.compare(list[i - 1],list[i]) < 0) {

                list[i] = list[i - 1];
                i--;
                list[i] = item;
            }
        }
        return list;
    }

    public String[] mergeSort(String[] in, Comparator<String> c){

        String[] left = new String[in.length / 2];
        String[] right = new String[in.length - left.length];

        if(in.length <= 1) return null;

        for (int i = 0; i < left.length; i++) {
            left[i] = in[i];
        }

        for (int i = 0; i < right.length; i++) {
            right[i] = in[left.length + i];
        }

        //send in the comparator as well
        mergeSort(right, c);
        mergeSort(left, c);

        mergeAlphabetical(left, right, in, c);

        return in;
    }

    public String toString(String[] in) {

        String str = "";

        for (int i = 0; i < in.length; i++) {

            str = str + in[i] + " ";
        }
        return str;
    }

    public void mergeInt(int left[], int[] right, int in[]) {

        int indexLeft = 0;
        int indexRight = 0;
        int i = 0;

        //if both index is smaller then the length of the arrays keep insert values in array
        while (indexLeft < left.length && indexRight < right.length) {
            // if left value is smaller then right insert from left
            // else insert from right array
            if (left[indexLeft] < right[indexRight]) {
                in[i] = left[indexLeft];
                indexLeft++;
            } else {
                in[i] = right[indexRight];
                indexRight++;
            }
            i++;
        }

        // if only indexLeft is smaller then left array run til false
        while (indexLeft < left.length) {
            in[i] = left[indexLeft];
            indexLeft++;
            i++;
        }

        // if only indexLeft is smaller then right array run til false
        while (indexRight < right.length) {
            in[i] = right[indexRight];
            indexRight++;
            i++;
        }
    }

    public void mergeAlphabetical(String[] left, String[] right, String in[], Comparator<String> c) {

        int indexLeft = 0;
        int indexRight = 0;
        int i = 0;

        //if both index is smaller then the length of the arrays keep insert values in array
        while (indexLeft < left.length && indexRight < right.length) {

            // compare left value with right value, if higher compare value
            // then right value compared with left insert left value
            // else insert right value
            if (c.compare(left[indexLeft],right[indexRight])
             > c.compare(right[indexRight],left[indexLeft])) {
                in[i] = left[indexLeft];
                indexLeft++;
            } else {
                in[i] = right[indexRight];
                indexRight++;
            }
            i++;
        }

        while (indexLeft < left.length) {
            in[i] = left[indexLeft];
            indexLeft++;
            i++;
        }

        while (indexRight < right.length) {
            in[i] = right[indexRight];
            indexRight++;
            i++;
        }
    }

}
