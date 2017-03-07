package dekes03_assing3.count_words;

import com.google.common.base.Utf8;
import com.sun.org.apache.xerces.internal.impl.io.UTF8Reader;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by ekerot on 2017-02-15.
 */

public class IdentyfyWordsMain {

    public static void main(String[] args) throws IOException {

        String content = "";

        try {
            content = readText("HistoryOfProgramming.txt");

        }catch(IOException e){
                System.err.println("Error: " + e);
        }

            List<String> words = Arrays.asList(content.split(""));

            Stream<String> stringStream = words.parallelStream()
                    .filter(word -> word.matches("[a-zA-Z ]")); //clean from every char but a-z
                                                                // A-Z and whitespace

            String result = stringStream
                    .map(s -> s.substring(0, 1))
                    .collect(Collectors.joining());

            try {
                PrintWriter out = new PrintWriter("words.txt"); // make new file

                out.println(result); // print result to new array
                out.flush();
                out.close();
            }
            catch(IOException e){
                System.out.println(e);
            }
        }

    public static String readText(String fileName) throws IOException {

        return new String(String.valueOf(Files.readAllLines(
                Paths.get(fileName), StandardCharsets.UTF_8))); // read file
    }
}
