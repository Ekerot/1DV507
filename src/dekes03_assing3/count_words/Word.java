package dekes03_assing3.count_words;

/**
 * Created by ekerot on 2017-02-23.
 */
public class Word implements Comparable<Word> {
    private String word;

    // make string into lowercase
    public Word(String str) {

        word = str.toLowerCase();
    }

    public String toString() {

        return this.word;
    }

    public int hashCode() {

        return word.hashCode();
    }


    // equal method
    public boolean equals(Object other) {

        if (other instanceof Word) {
            Word temp = (Word) other;
            return word.equals(temp.word);
        }
        return false;
    }

    //compare method
    public int compareTo(Word w) {

        return this.word.compareTo(w.toString());
    }
}
