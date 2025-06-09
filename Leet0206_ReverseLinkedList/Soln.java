package Leet0206_ReverseLinkedList;

/*
FUNCTION reverseList(head):
    SET previous = null
    SET current = head

    WHILE current is not null:
        SET nextTemp = current.next     // Store the next node
        SET current.next = previous     // Reverse the link
        SET previous = current          // Move previous forward
        SET current = nextTemp          // Move current forward

    RETURN previous  // previous is now the new head
END FUNCTION
*/
/*
FUNCTION reverseList(head):
    // Base case: empty list or single node
    IF head is null OR head.next is null:
        RETURN head

    // Recursively reverse the rest of the list
    SET reversedHead = reverseList(head.next)

    // Reverse the current connection
    SET head.next.next = head
    SET head.next = null

    RETURN reversedHead
END FUNCTION
*/

public class Soln {
    class Solution {
        public ListNode reverseList(ListNode head) {
            ListNode previous = null;
            ListNode current = head;

            while (current != null) {
                ListNode next = current.next;
                current.next = previous;
                previous = current;
                current = next;
            }

            return previous;
        }

        public ListNode reverseListRecursive(ListNode head) {
            if ((head == null) || (head.next == null)) {
                return head;
            }

            ListNode reverseHead = reverseListRecursive(head.next);
            head.next.next = head;
            head.next = null;

            return reverseHead;
        }
    }
}