package dekes03_assing3.count_words;

/**
 * Created by ekerot on 2017-02-24.
 */
public interface IWordSet extends Iterable<Word> {
    void add(Word word); // Add word if not already added
    boolean contains(Word word); // Return true if word contained
    int size(); // Return current set size
    String toString(); // Print contained words
}


