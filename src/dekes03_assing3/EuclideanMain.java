package dekes03_assing3;

/**
 * Created by ekerot on 2017-02-14.
 */
public class EuclideanMain {

    public static void main(String[] args){

        System.out.println(euclideanRecursion(18, 12));
        System.out.println(euclideanRecursion(42, 56));
        System.out.println(euclideanRecursion(9, 28));
    }

    public static int euclideanRecursion(int a, int b){     // I think this is self explainable
                                                            // The program runs the recursive method
                                                            // until b is equal to 0
                                                            // return int a

        if(b == 0){
            return a;
        }
        return euclideanRecursion(b, a %b);
    }
}
