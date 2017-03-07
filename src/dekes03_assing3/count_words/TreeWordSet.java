package dekes03_assing3.count_words;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by ekerot on 2017-02-26.
 */
public class TreeWordSet implements IWordSet{

    private BinarySearchTree root = null;
    public int size = 0;

    // add word object
    public void add(Word word){
        // root is null create new root  else run add BTS method
        if(root == null){
            root = new BinarySearchTree(word);
        }
        else{
            root.add(word);
        }
    }

    // run contains method in BTS if root is null return false
    public boolean contains(Word word){
        if(root.value == null)
            return false;

        return root.contains(word);
    }

    // run BTS size method
    public int size()
    {
        return size(root);
    }

    public String toString() {

        return toString(root);
    }

    public Iterator iterator() {
        return new TreeIterator();
    }


    private class BinarySearchTree {

        public Word value;
        public BinarySearchTree left = null, right = null, parent = null;

        BinarySearchTree(Word word) {
            value = word;
        }

        void add(Word word) {

            // compare latest value with word input if lower then 0
            // add word into left branch
            if (word.compareTo(value) < 0) {
                if (left == null)
                    left = new BinarySearchTree(word);

                else
                    left.add(word);

            }

            // compare latest value with word input if higher then 0
            // add word into right branch
            if (word.compareTo(value) > 0) {
                if (right == null)
                    right = new BinarySearchTree(word);

                else
                    right.add(word);
            }
        }

        public boolean contains(Word word) {

            // get value of word compared to value
            int comp = word.compareTo(value);

            if(comp  == 0)
                return true;

            //search through leftbranch
            if(comp < 0 && left != null && left.contains(word))
                return true;

            //search through right branch
            if(comp > 0 && right != null && right.contains(word))
                return true;

            return false;
        }
    }

    // helper
    public static String toString(BinarySearchTree binary){

        // recursive method traversing through the left and right side of the tree
        // to present a nice looking string
        if(binary!=null)
            return toString(binary.left) + "\n" + binary.value  + toString(binary.right) + "";

        else
            return "";
    }
    //helper
    public static int size(BinarySearchTree binary){

        // recursive method traversing through the left and right side of the tree
        // to count size of tree
        if(binary!=null)
            return size(binary.left)  + 1 + size(binary.right);

        else
            return 0;
    }

    private class TreeIterator implements Iterator<Word> {

        private BinarySearchTree[] words;
        private int counter;
        private int endCounter = 0;

        public TreeIterator(){
            words = new BinarySearchTree[size()];
            counter = 0;
            endCounter = 0;
        }

        public boolean hasNext() {
            return endCounter < size();
        }

        public Word next() { // tis one was a bit tricky, yet simple when solved :-)

            if(counter == 0){
                inOrderTraversal(root);
            }

            Word result = words[endCounter].value;
            endCounter++;
            return result;

        }

        // when travers through the tree and get each next() we need this helper
        // class to get the array with all the values in order
        private void inOrderTraversal(BinarySearchTree current) {

            //traverse it self until lowest leaf
            if (current.left != null)
                inOrderTraversal(current.left);

            words[counter] = current; // add then current value from lowest and then upwards
            counter++;

            //traverse through right branch to find lowest leaf
            if (current.right != null)
                inOrderTraversal(current.right);

        }

        public void remove() {
            throw new RuntimeException("remove() is not implemented");
        }
    }
}

