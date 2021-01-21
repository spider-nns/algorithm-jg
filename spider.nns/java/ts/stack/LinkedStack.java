package java.ts.stack;

import java.util.Comparator;

/**
 * 增强自定义链式栈，通过维护一个栈来保证用O(1)的时间复杂度求栈中的最小元素，空间换时间
 * 使用额外的栈结构存储栈中的最小元素
 * 当前入栈的元素比原来栈中的最小值还小，则将其保存到最小值栈中
 * 当前出栈的元素正好是当前栈中的最小值，那么将最小值栈中的该最小值也一并弹出
 */
public class LinkedStack<E> {
    private Node<E> top;
    private int size;

    /**
     * 最小值栈
     */
    private LinkedStack<E> min;

    public LinkedStack() {
    }


    public boolean isEmpty() {
        return size == 0;
    }

    public void push(E data) {
        Node<E> node = new Node<E>(data);
        // 新加入的元素指向栈顶元素
        node.next = top;
        top = node;
        size++;
    }

    /**
     * 压栈操作, 使用最小值栈
     */
    public void push(E data, Comparator<? super E> c) {
        push(data);
        if (min == null) {
            min = new LinkedStack<E>();
        }
        if (min.peek() == null) {
            min.push(data);
        } else if (c.compare(this.peek().data, min.peek().data) < 0) min.push(data);
    }

    /**
     * 弹出并删除栈顶元素
     */
    public Node<E> pop() {
        if (isEmpty()) {
            return null;
        }

        Node<E> node = top;
        top = top.next;
        node.next = null;
        size--;
        return node;
    }

    /**
     * 弹出并删除栈顶元素, 使用最小值栈
     */
    public Node<E> pop(Comparator<? super E> c) {
        Node<E> temp = this.pop();
        if (temp != null && min.peek() != null) {
            if (c.compare(temp.data, min.peek().data) == 0) {
                min.pop();
            }
        }
        return temp;
    }

    /**
     * 弹出栈顶元素不删除
     */
    public Node<E> peek() {
        if (isEmpty()) {
            return null;
        }
        return top;
    }

    /**
     * 获取当前栈中的最小值
     */
    public Node<E> min() {
        if (min.peek() == null) {
            return null;
        } else {
            return min.peek();
        }
    }

    /**
     * 打印
     */
    public void print() {
        Node<E> index = top;
        while (index != null) {
            System.out.print(index.data + " ");
            index = index.next;
        }
        System.out.println();
    }


    public int size() {
        return size;
    }

    public LinkedStack<E> getMin() {
        return min;
    }

    public void setMin(LinkedStack<E> min) {
        this.min = min;
    }

    @Override
    public String toString() {
        Node<E> index = top;
        StringBuilder sb = new StringBuilder();
        while (index != null) {
            sb.append(index.data).append(" ");
            index = index.next;
        }
        return sb.toString();
    }
}