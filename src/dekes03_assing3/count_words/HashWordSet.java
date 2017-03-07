package dekes03_assing3.count_words;

import java.util.Iterator;

/**
 * Created by ekerot on 2017-02-24.
 */

public class HashWordSet implements IWordSet {

    private int size;
    private Node[] buckets = new Node[8]; //Array with length of eight

    @Override
    public void add(Word word) {

        int position = getBucketNumber(word);
        Node node = buckets[position];

        // run as long as node is not null
        while (node != null) {
            // if the value of the node is the same as the word value return
            // else node = next node
            if (node.value.equals(word))
                return;
            else
                node = node.next;
        }

        node = new Node(word);
        node.next = buckets[position];
        buckets [position] = node;
        size++;

        //if bucket is full rehash
        if (size == buckets.length)
            rehash();
    }

    @Override
    public boolean contains(Word word) {

        int position = getBucketNumber(word);
        Node node = buckets[position];

        //run as long as node is not null
        while (node != null) {

            //if node value equals word
            // it exists in set
            // else node = next node
            if (node.value.equals(word))
                return true;
            else
                node = node.next;
        }
        return false;
    }

    // present a nice looking string
    public String toString() {

        String output = "All the words:\n";

        for (Node bucket : buckets) {
        if(bucket != null) {
                output = output + bucket.value.toString()+"\n";
            }
        }
        return output;
    }

    @Override
    public int size() {
        return size;
    }

    //method to get bucket number so that we know which bucket to insert in
    private int getBucketNumber(Word word) {

        int hashCode = word.hashCode();
        if (hashCode < 0) hashCode =- hashCode;
        return hashCode % buckets.length;
    }

    private void rehash() {

        Node[] temp = buckets; //put node array buckets into temp
        buckets = new Node[2*temp.length]; // create new node array that is double length of temp
        size = 0;
        for (Node word : temp) {
            if (word == null) continue;
            while (word != null) {
                add(word.value);
                word = word.next;
            }
        }
    }

    @Override //nested Iterator class
    public Iterator iterator() {
        return new hashIterator();
    }

    private class Node {

        public Node next = null;
        public Word value;

        public Node(Word word) {
            {
                value = word;
            }
        }
        public String string(){

            return value.toString();
        }
    }

    private class hashIterator implements Iterator<Word> {

        public int i = 0;

        public Word next() {
            i++;

            //buckets value is null run next method again
            if(buckets[i] == null) {
                next();
            }
            //return value
            return buckets[i].value;
        }

        public boolean hasNext() {
            return i < size;
        }

        public void remove() {
            throw new RuntimeException("remove() is not implemented");
        }
    }
}
