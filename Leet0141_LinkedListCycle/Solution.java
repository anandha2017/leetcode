/**
 * Solution for LeetCode problem 141: Linked List Cycle
 * This is the file you would submit to LeetCode
 */
public class Solution {
    /**
     * Determines if the linked list has a cycle in it.
     *
     * @param head The head of the linked list
     * @return true if there is a cycle in the linked list, otherwise false
     */
    public boolean hasCycle(ListNode head) {

        if (head == null) {
            return false;
        }

        java.util.Set<ListNode> visited = new java.util.HashSet<>();

        while (head != null) {
            if (visited.contains((head))) {
                return true;
            } else {
                visited.add(head);
                head = head.next;
            }
        }

        return false;
    }
}
