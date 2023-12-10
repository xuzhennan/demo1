package xzn.study2023.linkNode;

public class RemoveDuplicateNode {

    public static void main(String[] args) {
        ListNode temp;
        ListNode head = new ListNode();
        ListNode cur = head;
        for (int i = 1; i < 7; i++) {
            temp = new ListNode();
            if (i % 2 == 0) {
                temp.val = i + 1;
            } else if (i % 3 == 0) {
                temp.val = i - 2;
            } else {
                temp.val = i;
            }

            cur.next = temp;
            cur = temp;
        }

        for (cur = head.next; cur != null; cur = cur.next) {
            System.out.print(cur.val + " ");
        }
        removeDuplicateNode(head);
        System.out.println();
        for (cur = head.next; cur != null; cur = cur.next) {
            System.out.print(cur.val + " ");
        }
    }

    public static void removeDuplicateNode(ListNode node) {
        if (node == null || node.next == null) {
            return;
        }

        ListNode outerNode = node.next;
        ListNode innerNode;
        for (; outerNode != null; outerNode = outerNode.next) {
            ListNode innerPre = outerNode;
            for (innerNode = outerNode.next; innerNode != null; innerNode = innerNode.next) {
                if (outerNode.val == innerNode.val) {
                    // 相同 删除
                    innerPre.next = innerNode.next;
                } else {
                    innerPre = innerNode;
                }
            }
        }
    }
}
