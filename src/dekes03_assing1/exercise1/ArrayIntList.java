package dekes03_assing1.exercise1;

import java.util.NoSuchElementException;

// I will not comment this alot though the comments is found in the interfaces

public class ArrayIntList extends AbstractIntCollection implements IntList {

    public ArrayIntList() {

    }

    @Override
    public void add(int n) {

        this.values[this.size++] = n;

        if (this.size + 1 == this.values.length) {

            super.resize();
        }
    }

    @Override
    public void addAt(int n, int index) throws IndexOutOfBoundsException {

        this.size++;

        if (this.size + 1 < this.values.length) {

            for (int i = 0; i < this.size; i++)

                if (i == index);

            for (int j = this.size + 1; j > index; j--) { //we need to ad the value to the right index
                int temp = this.values[j - 1];
                this.values[j] = temp;

            }

            this.values[index] = n;

        } else {

            super.resize();

            for (int i = 0; i < this.size; i++)

                if (i == index)
                    ;

            for (int j = this.size + 1; j > index; j--) {
                int temp = this.values[j - 1];
                this.values[j] = temp;
            }
            this.values[index] = n;
        }
    }

    @Override
    public void remove(int index) throws IndexOutOfBoundsException {
        if (super.size() == 0)
            throw new NoSuchElementException(); //throw exception if list is empty

        for (int i = 0; i < this.size; i++) { //remove element
            if (i == index) {
                for (int j = index; j < this.size; j++) {
                    int temp = this.values[j + 1];
                    this.values[j] = temp;
                }
            }
        }
        this.size--;
    }

    @Override
    public int get(int index) throws IndexOutOfBoundsException {
        if (super.size() == 0)
            throw new NoSuchElementException();

        return this.values[index]; //return element
    }

    @Override
    public int indexOf(int n) {

        if (super.size() == 0)
            throw new NoSuchElementException();

        for (int i = 0; i < this.size; i++) { // find the index of the value n
            if (this.values[i] == n) {
                return i;
            }
        }
        return -1;
    }
}
