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

            ListNode current = head;
            ListNode prev = null;

            while (current != null) {
                if (current.val == val) {
                    if (current == head) {
                        head = head.next;
                        current = head;
                    } else {
                        prev.next = current.next;
                        current = current.next;
                    }
                } else {
                    prev = current;
                    current = current.next;
                }
            }

            return head;
        }
    }

}