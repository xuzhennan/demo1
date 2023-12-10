package xzn.study2023.linkNode;

public class addTwoNumbers {

    public static void main(String[] args) {
        ListNode head1 = new ListNode();

        head1.next = new ListNode(5, new ListNode(1, new ListNode(5, null)));

        ListNode head2 = new ListNode();
        head2.next = new ListNode(5, new ListNode(9, new ListNode(5, new ListNode(1, null))));


        System.out.println(addTwoNumbers(head1, head2));
    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l1.next == null) {
            return l2;
        }

        if (l2 == null || l2.next == null) {
            return l1;
        }

        ListNode p1 = l1.next;
        ListNode p2 = l2.next;
        ListNode head = new ListNode();
        ListNode pre = head;
        // 进位
        int flag = 0;
        ListNode cur = null;
        while (p1 != null && p2 != null) {
            cur = new ListNode();
            int sum = p1.val + p2.val + flag;
            cur.val = sum % 10;
            // 进位
            flag = sum / 10;
            pre.next = cur;
            pre = cur;
            p1 = p1.next;
            p2 = p2.next;
        }

        if (p1 == null) {
            while (p2 != null) {
                cur = new ListNode();
                int sum = p2.val + flag;
                cur.val = sum % 10;
                // 进位
                flag = sum / 10;
                pre.next = cur;
                pre = cur;
                p2 = p2.next;
            }
        }

        if (p2 == null) {
            while (p1 != null) {
                cur = new ListNode();
                int sum = p1.val + flag;
                cur.val = sum % 10;
                // 进位
                flag = sum / 10;
                pre.next = cur;
                pre = cur;
                p1 = p1.next;
            }
        }

        if (flag == 1) {
            cur = new ListNode();
            cur.val = 1;
            pre.next = cur;
        }

        return head.next;
    }
}
