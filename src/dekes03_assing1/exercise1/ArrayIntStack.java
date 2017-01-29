package dekes03_assing1.exercise1;

import java.util.EmptyStackException;

// I will not comment this alot though the comments is to find in the interfaces

public class ArrayIntStack extends AbstractIntCollection implements IntStack {


    public ArrayIntStack() {

    }

    public void push(int n) {

        if (this.values.length > this.size) {
            this.values[this.size++] = n;

        } else {  //if the array is full resize it
            super.resize();
            this.values[this.size++] = n;

        }
    }

    public int pop() throws IndexOutOfBoundsException {

        if (super.isEmpty())  // lets throw an exception if if the stack is empty
            throw new EmptyStackException();

        int position = size--;
        int temp = this.values[size];

        for (int i = 0; i < size; i++) { //remove from array
            if(i == position) {
                this.values[i] = this.values[size];
            }
        }

        return temp;
    }

    public int peek() throws IndexOutOfBoundsException {

        if (super.isEmpty())
            throw new EmptyStackException();

        return this.values[this.size() - 1]; // lets peek
    }
}
