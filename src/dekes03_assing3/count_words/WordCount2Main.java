package dekes03_assing3.count_words;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by ekerot on 2017-02-27.
 */
public class WordCount2Main {

    public static void main(String[] args){

        HashWordSet HWS  = new HashWordSet();
        TreeWordSet TWS = new TreeWordSet();

        Scanner scan = null;
        try {
            scan = new Scanner(new FileReader("words.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while(scan.hasNext()){

            Word word = new Word(scan.next());

            TWS.add(word);
            HWS.add(word);
        }

        Word word = new Word("programming");

        System.out.println(HWS.size());
        System.out.println(HWS.contains(word));
        System.out.println();
        Iterator<Word> iteratorHWS = HWS.iterator();
        while (iteratorHWS.hasNext()) {

            Word w = iteratorHWS.next();
            System.out.println(w);
        }

        System.out.println();
        System.out.println();

        System.out.println(TWS.size());
        System.out.println(TWS.contains(word));
        System.out.println();

        Iterator<Word> iteratorTWS = TWS.iterator();

        while (iteratorTWS.hasNext()) {

           Word w = iteratorTWS.next();
            System.out.println(w);
        }
    }
}
