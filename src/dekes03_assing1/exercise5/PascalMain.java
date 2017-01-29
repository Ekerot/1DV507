package dekes03_assing1.exercise5;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PascalMain {

    public static void main(String[] args){

        try {

            //Scan the number has to be a int int the span of 0-10
            Scanner scan = new Scanner(System.in);
            System.out.println("Write a prime number between 0 and 10: ");
            int number = scan.nextInt();

            scan.close();

            if (number > 10) { //throw exception if mismatch
                throw new InputMismatchException();
            }

            int[] row = pascalRow(number);

            System.out.println(toString(row));

        } catch(InputMismatchException e){ //throw exception if mismatch

            System.err.println(e + " : Something is wrong with your input, please correct it!");
        }
    }

    private static int[] pascalRow(int n) { //recursive method computing the sum

        if (n == 0) { //
            int[] pascalArrayOne = new int[1];
            pascalArrayOne[0] = 1;   //setting index 0 to 1 as the first number

            return pascalArrayOne;

        } else {

            int[] lastNumber = pascalRow(n - 1);
            int[] nextNumber = calculateArray(lastNumber);

            return nextNumber;
        }
    }

    public static int[] calculateArray(int[] m) { //computing the next line int the pascalrow
        int[] array = new int[m.length + 1];

        array[0] = 1;       //first and last is always 1
        array[m.length] = 1;

        for (int i = 1; i < m.length; i++) { //always need to start with index 1
            array[i] = m[i - 1] + m[i];
        }

        return array;
    }

    public static String toString(int[] in) { //nice print out, Im only showing the last row though
        StringBuffer buf = new StringBuffer();

        for (int i = 0; i < in.length; i++) {
            buf.append(" " + in[i]);
        }

        return buf.toString();
    }
}
