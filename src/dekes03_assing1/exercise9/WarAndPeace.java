package dekes03_assing1.exercise9;

import java.io.*;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by ekerot on 2017-01-23.
 */

public class WarAndPeace {

    public static void main(String[] args) throws IOException {

        String text = null;   // My own method

        try {
            text = readText("WarAndPeace.txt"); //dont forget to put the WarAndPeace.txt in project folder:root
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<String> words = Arrays.asList(text.split(" "));  // Simple split, will be cleaned up later on
        System.out.println("Initial word count: "+words.size());   // We found 577091

        /* My approach was to use regex to filter out all the chars we don´
        want to count in as words or that should not be inside any word.
        Lets explain the regex: my regex says all words not starting och
        ending with digits, white space characters or none word characters, but except the characters - and ´
        Ofc I started out with making all letters to lower case.
        */

        Stream<String> amount = words.parallelStream().map(String::toLowerCase)
                .filter(word -> word.matches("^[^\\\\d\\\\s\\\\W[-’]]*$"))
                .distinct();

        System.out.printf("Word count, unique words: %d", amount.count());
    }

    public static String readText(String fileName) throws IOException {

        return new String(String.valueOf(Files.readAllLines(
                Paths.get(fileName))));
    }
}