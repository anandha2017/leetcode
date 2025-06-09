package Leet0203_RemoveLinkedListElements;

public class Soln {

    class Solution {
        public ListNode removeElements(ListNode head, int val) {

            // edge case - head is null
            if (head == null) {
                return head;
            }

            // edge case - head.next is null
            if (head.next == null) {
                if (head.val == val) {
                    return head.next;
                }

                return head;
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

        public ListNode removeElements_o4Mini(ListNode head, int val) {
            // DRY version using a dummy head
            ListNode dummy = new ListNode(0, head);
            ListNode prev = dummy;
            ListNode curr = head;
            while (curr != null) {
                if (curr.val == val) {
                    prev.next = curr.next;
                } else {
                    prev = curr;
                }
                curr = curr.next;
            }
            return dummy.next;
        }

        /**
         * Sonnet 4 optimized solution using dummy node pattern
         *
         * Key advantages over the original approach:
         * 1. Eliminates special head handling - dummy node simplifies all edge cases
         * 2. Cleaner, more readable code with consistent removal logic
         * 3. No complex conditional branches for head vs non-head removal
         * 4. Same optimal complexity: O(n) time, O(1) space
         *
         * Algorithm:
         * - Create dummy node pointing to head to handle head removal uniformly
         * - Use two pointers: prev (trails behind) and current (scans forward)
         * - When target found: skip node by updating prev.next
         * - When target not found: advance prev pointer
         * - Always advance current pointer
         *
         * @param head The head of the linked list
         * @param val The value to remove from the list
         * @return The new head of the modified list
         */
        public ListNode removeElements_sonnet4(ListNode head, int val) {
            // Create dummy node to eliminate special head handling
            ListNode dummy = new ListNode(0);
            dummy.next = head;

            ListNode prev = dummy;
            ListNode current = head;

            while (current != null) {
                if (current.val == val) {
                    // Remove current node by skipping it
                    prev.next = current.next;
                } else {
                    // Move prev pointer only when we keep the node
                    prev = current;
                }
                current = current.next;
            }

            // Return new head (dummy.next handles all edge cases)
            return dummy.next;
        }
    }

}
