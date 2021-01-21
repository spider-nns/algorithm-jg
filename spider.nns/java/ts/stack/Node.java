package java.ts.stack;

public class Node<T> {
    Node<T> next;
    T data;


    public Node(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    @Override
    public String toString() {
        return data.toString();
    }

    public Node<T> getNext() {
        return next;
    }
}
