package objects;

public class StackOfChars {
    private char[] elements;
    private int size;

    public StackOfChars() {
        size = 0;
        elements = new char[16];
    }

    public StackOfChars(int capacity) {
        size = 0;
        elements = new char[capacity];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == elements.length;
    }

    public char peek() {
        if (size == 0) throw new NullPointerException("Stack empty: Can't peek!.");
        else return elements[size - 1];
    }

    public void push(char ch) {
        if (!isFull()) {
            size++;
            elements[size - 1] = ch;
        } else {
            throw new IndexOutOfBoundsException("Stack full: Can't push!.");
        }
    }

    public void pop() {
        if (size == 0) throw new NullPointerException("Stack empty: Can't pop");
        size--;
    }

    public int getSize() {
        if (isFull()) return -1;
        if (isEmpty()) return 0;
        return size;
    }
}

