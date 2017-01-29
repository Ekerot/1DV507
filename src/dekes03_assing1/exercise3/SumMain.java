package dekes03_assing1.exercise3;

public class SumMain {

    //recursive is more costly for the memory witch is a downer but can be more readable
    //There is always a performance drawback when using recursions
    //But in this case I think it is a good solution though it´s elegant and we are not handling
    //that much data in this little program so that we will notice

    public static void main(String[] args) {

        int number = 0;
        int limiter = 8;

        int run = sum(number, limiter); // calling the method

        System.out.println(run);

    }

    public static int sum(int n, int l) {

        if (n == l) { // if the limiter and the number is equal return the
            // limiter, you can´t count up to the same number
            return l;

        } else { // if the limiter and the number is not the same

            return sum(n, ((n + l) / 2)) + sum((((n + l) / 2) + 1), l);

        }
    }
}
