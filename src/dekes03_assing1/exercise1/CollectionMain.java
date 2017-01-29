package dekes03_assing1.exercise1;

public class CollectionMain {

    public static void main(String[] args) {

        ArrayIntStack intStack = new ArrayIntStack();
        try {
           for (int i = 1; i < 20; i++) { //Puts  objects into the stack.
                intStack.push(i);
            }

            System.out.println("IntStack methods:");
            System.out.println();

            System.out.println(intStack.toString());
            System.out.println(intStack.peek());
            System.out.println(intStack.pop());

            System.out.println(intStack.size());
            System.out.println(intStack.isEmpty());

            ArrayIntList intList = new ArrayIntList();

            for (int i = 1; i < 20; i++) { //Puts  objects into the list.
                intList.add(i);
            }

            System.out.println();
            System.out.println("IntList methods:");
            System.out.println();

            System.out.println(intList.toString());
            intList.addAt(1, 2);

            System.out.println(intList.toString());
            System.out.println(intList.get(3));
            System.out.println(intList.indexOf(4));

            intList.remove(1);

            System.out.println(intList.toString());

        }catch(IndexOutOfBoundsException e){

            System.err.println(e + " is out of index.");

        }
    }
}