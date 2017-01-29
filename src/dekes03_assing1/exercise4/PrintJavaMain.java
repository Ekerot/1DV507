package dekes03_assing1.exercise4;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PrintJavaMain {

    public static void main(String[] args) {

        try {
            // read in the path that we want to check for .java files
            File path = new File("/Users/ekerot/Documents/workspace/");

            printAllJavaFiles(path);

        } catch (IOException e) {
            System.err.println("Your catalogue does not exist!");
        }

    }

    public static void printAllJavaFiles(File directory) throws IOException {

        File[] fileList = directory.listFiles();

        for (File f : fileList) {

            if (f.isFile()) {   // if f is a normal file(not a path for example)
                // next if statment checks the name and if the
                // file sufix is .java
                if (f.getName().endsWith(".java")) {
                    String format = "%-40s %5d\n";  // defining a format for a
                    // nice print out

                    Path path = Paths.get(f.getAbsolutePath()); // get the Absolute path and count rows
                    long lineCount = Files.lines(path).count();

                    System.out.format(format, f.getName(), lineCount);
                }

            } else {
                printAllJavaFiles(f.getAbsoluteFile());
            }
        }
    }
}