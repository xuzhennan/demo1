package xzn.study2023.linkNode;

public class ListNode {
    int val;

    ListNode next;

    public ListNode() {
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }


    @Override
    public String toString() {
        return "LinkNode{" +
                "data=" + val +
                ", next=" + next +
                '}';
    }
}
