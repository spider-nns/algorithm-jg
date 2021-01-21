package java.ts.stack;

import java.util.Arrays;

/**
 * 顺序栈
 *
 * @param <E>
 */
public class SeqStack<E> {

    private Object[] stack;    // 支撑数组
    private int top;    // 栈顶
    private int maxSize;    // 最大容量

    public SeqStack() {
        this(10);
    }

    public SeqStack(int maxSize) {
        this.stack = new Object[maxSize];
        this.top = -1;
        this.maxSize = maxSize;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    // 弹出并删除栈顶元素
    @SuppressWarnings("unchecked")
    public E pop() throws Exception {
        if (top == -1) {
            throw new Exception("栈为空...");
        }
        E element = (E) stack[top];
        stack[top--] = null;    // 删除该元素
        return element;
    }

    public void push(E e) throws Exception {
        if (top == maxSize - 1) {
            throw new Exception("栈已满...");
        }
        stack[++top] = e;
    }

    @Override
    public String toString() {
        return Arrays.toString(stack);
    }
}
