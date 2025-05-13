package Leet0160_IntersectionOfTwoLinkedLists;

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        java.util.Set<ListNode> visited = new java.util.HashSet<>();

        while (headA != null) {
            visited.add(headA);
            headA = headA.next;
        }

        while (headB != null) {
            if (visited.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }

        return null;
    }
}