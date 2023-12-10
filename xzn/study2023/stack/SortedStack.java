package xzn.study2023.stack;

import java.util.Stack;

/**
 * 栈排序。 编写程序，对栈进行排序使最小元素位于栈顶。最多只能使用一个其他的临时栈存放数据，
 * 但不得将元素复制到别的数据结构（如数组）中。该栈支持如下操作：push、pop、peek 和 isEmpty。当栈为空时，peek 返回 -1。
 */
public class SortedStack {

    Stack<Integer> stack;

    public SortedStack() {
        stack = new Stack<>();
    }


    public void push(int val) {
        sort(val);
    }

    private void sort(int val) {
        if (stack.isEmpty() || stack.peek() >= val) {
            stack.push(val);
            return;
        }
        int tmp = stack.pop();
        sort(val);
        stack.push(tmp);
    }


    public void push2(int val) {
        if (!stack.isEmpty()) {
            // 始终保持栈顶元素最小
            Integer top = stack.peek();
            stack.pop();
            moveMinToTop(stack);
            if (val < top) {
                stack.push(top);
                stack.push(val);
            } else {
                stack.push(val);
                stack.push(top);
            }
        } else {
            stack.push(val);
        }
    }

    private void moveMinToTop(Stack<Integer> stack) {
        // 将最小值放在栈顶
        if (stack.isEmpty()) {
            return;
        }
        Integer top1 = stack.peek();
        stack.pop();
        if (!stack.isEmpty()) {
            moveMinToTop(stack);
            Integer top2 = stack.peek();
            if (top1 > top2) {
                stack.pop();
                stack.push(top1);
                stack.push(top2);
            }
        }
        stack.push(top1);
    }


    public void pop() {
        if (!stack.isEmpty()) {
            stack.pop();
        }
    }

    public int peek() {
        if (!stack.isEmpty()) {
            return stack.peek();
        }
        return -1;
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        SortedStack obj = new SortedStack();
        System.out.println(obj.peek());
        System.out.println(obj.peek());
        obj.pop();
        System.out.println(obj.peek());
        obj.push(40);
        obj.pop();
        obj.push(19);
        System.out.println(obj.peek());
        obj.push(44);
        System.out.println(obj.peek());
        obj.pop();
        obj.pop();
        obj.push(42);
        System.out.println(obj.isEmpty());
        System.out.println(obj.peek());
    }
}
