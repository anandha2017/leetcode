package Leet203_RemoveLinkedListElements;

public class Soln {

    class Solution {
        public ListNode removeElements(ListNode head, int val) {

            // edge case - head is null
            if (head == null) {
                return head;
            }

            // edge case - head.next is niull
            if (head.next == null) {
                if (head.val == val) {
                    return head.next;
                }
            }

            ListNode prev = head;
            ListNode next = head.next;

            while (prev != null) {
                if (next.val == val) {
                    prev.next = next.next;
                    next = next.next.next;

                } else {
                    prev = next;
                    next = next.next;
                }
            }

            return head;
        }
    }

}