package dekes03_assing3.count_words;

import javax.xml.soap.Node;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

/**
 * Created by ekerot on 2017-02-23.
 */
public class WordCount1Main {

   public static void main(String[] args){

       Set<Word> hashSet = new HashSet<>(); // Create empty set
       Set<Word> treeSet = new TreeSet<>(); // Alternative

       Scanner scan = null;

       //scan the words.txt file
       try {
           scan = new Scanner(new FileReader("words.txt"));
       } catch (FileNotFoundException e) {
           e.printStackTrace();
       }

       //add to treeSet and hashSet
       while(scan.hasNext()){

           Word word = new Word(scan.next());

           treeSet.add(word);
           hashSet.add(word);
       }

       Word word = new Word("symBolic");

       System.out.println(treeSet);
       System.out.println(hashSet);

       //expected false
       System.out.println(treeSet.contains(word));
       System.out.println(hashSet.contains(word));

       //expected 349
       System.out.println(treeSet.size());
       System.out.println(hashSet.size());



   }
}
