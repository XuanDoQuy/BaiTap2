package objects;

public class StackOfIntegers {
    private int[] elements;
    private int size;

    public StackOfIntegers() {
        size = 0;
        elements = new int[16];
    }
    public StackOfIntegers(int capacity){
        size = 0;
        this.elements = new int[capacity];
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public boolean isFull(){
        return size == elements.length;
    }
    public int peek(){
        if (isEmpty()) throw new NullPointerException("Stack empty: Can't peek !");
        return elements[size-1];
    }
    public void push(int value){
        if (!isFull()){
            size++;
            elements[size-1] = value;
        }else {
            throw new IndexOutOfBoundsException("Stack full : Can't push !");
        }
    }
    public void pop(){
        if (size==0) throw new NullPointerException("Stack empty : Can't pop ");
        size--;
    }

    public int getSize(){
        return size;
    }
}
