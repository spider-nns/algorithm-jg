package java.ts.list;

public class Node<T> {

    Node<T> next;

    T data;

    public Node(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
