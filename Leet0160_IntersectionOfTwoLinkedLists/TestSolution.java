package Leet0160_IntersectionOfTwoLinkedLists;

/**
 * Test class for the LinkedListCycle problem.
 * This file contains test cases and utility methods for testing your solution.
 */
public class TestSolution {
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_GREEN = "\u001B[92m";
    private static final String ANSI_RED = "\u001B[91m";
    private static final int MAX_STRING_LENGTH = 50;

    private static String greenText(String text) {
        return ANSI_GREEN + text + ANSI_RESET;
    }

    private static String redText(String text) {
        return ANSI_RED + text + ANSI_RESET;
    }

    private static String truncateStr(String s, int maxLength) {
        if (s.length() <= maxLength) {
            return s;
        }
        return s.substring(0, maxLength - 3) + "...";
    }

    private static String truncateStr(String s) {
        return truncateStr(s, MAX_STRING_LENGTH);
    }

    /**
     * Creates two linked lists that may intersect at a specific point.
     *
     * @param intersectVal The value at the intersection point (0 if no
     *                     intersection)
     * @param listA        Values for the first linked list
     * @param listB        Values for the second linked list
     * @param skipA        Number of nodes to skip in listA before intersection
     * @param skipB        Number of nodes to skip in listB before intersection
     * @return Array containing [headA, headB, intersectionNode]
     */
    private static ListNode[] createIntersectingLinkedLists(
            int intersectVal,
            int[] listA,
            int[] listB,
            int skipA, int skipB) {

        ListNode headA = null;
        ListNode headB = null;
        ListNode intersectionNode = null;

        // Create list A
        if (listA.length > 0) {
            headA = new ListNode(listA[0]);
            ListNode currentA = headA;

            // Create nodes up to the intersection point
            for (int i = 1; i < skipA; i++) {
                currentA.next = new ListNode(listA[i]);
                currentA = currentA.next;
            }

            // Create the intersection node if there is one
            if (intersectVal != 0) {
                intersectionNode = new ListNode(intersectVal);
                currentA.next = intersectionNode;
                currentA = currentA.next;

                // Continue with the rest of list A after intersection
                for (int i = skipA + 1; i < listA.length; i++) {
                    currentA.next = new ListNode(listA[i]);
                    currentA = currentA.next;
                }
            } else {
                // No intersection, just finish list A
                for (int i = skipA; i < listA.length; i++) {
                    currentA.next = new ListNode(listA[i]);
                    currentA = currentA.next;
                }
            }
        }

        // Create list B
        if (listB.length > 0) {
            headB = new ListNode(listB[0]);
            ListNode currentB = headB;

            // Create nodes up to the intersection point
            for (int i = 1; i < skipB; i++) {
                currentB.next = new ListNode(listB[i]);
                currentB = currentB.next;
            }

            // Connect to the intersection node if there is one
            if (intersectionNode != null) {
                currentB.next = intersectionNode;
            } else {
                // No intersection, just finish list B
                for (int i = skipB; i < listB.length; i++) {
                    currentB.next = new ListNode(listB[i]);
                    currentB = currentB.next;
                }
            }
        }

        return new ListNode[] { headA, headB, intersectionNode };
    }

    private static boolean assertSolution(
            int intersectVal,
            int[] listA, int[] listB,
            int skipA, int skipB,
            int expected,
            String testName) {

        Solution solution = new Solution();

        // Create the linked lists using the helper method
        ListNode[] lists = createIntersectingLinkedLists(intersectVal, listA, listB, skipA, skipB);
        ListNode headA = lists[0];
        ListNode headB = lists[1];
        ListNode intersectionNode = lists[2];

        ListNode output = solution.getIntersectionNode(headA, headB);

        boolean assertPass;
        if (expected == 0) {
            // Expected no intersection
            assertPass = (output == null);
        } else {
            // Expected an intersection with specific value
            assertPass = (output != null && output.val == expected);
        }

        String result = assertPass ? "PASS" : "FAIL";
        String formattedResult = assertPass ? greenText(result) : redText(result);

        System.out.println(
                formattedResult + ": " + testName +
                        " - Output: " + (output == null ? "null" : output.val) +
                        ", Expected: " + expected +
                        ", Intersection: " + (intersectionNode == null ? "null" : intersectionNode.val) +
                        ", ListA: " + truncateStr(linkedListToString(headA)) +
                        ", ListB: " + truncateStr(linkedListToString(headB)));

        return assertPass;
    }

    private static String linkedListToString(ListNode head) {
        StringBuilder sb = new StringBuilder("[");
        ListNode current = head;
        while (current != null) {
            sb.append(current.val);
            if (current.next != null) {
                sb.append(", ");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        // Example 1: Intersection at node with value 8
        assertSolution(
                8,
                new int[] { 4, 1, 8, 4, 5 },
                new int[] { 5, 6, 1, 8, 4, 5 },
                2,
                3,
                8,
                "Example 1");

        // Example 2: Intersection at node with value 2
        assertSolution(
                2,
                new int[] { 1, 9, 1, 2, 4 },
                new int[] { 3, 2, 4 },
                3,
                1,
                2,
                "Example 2");

        // Example 3: No intersection
        assertSolution(
                0,
                new int[] { 2, 6, 4 },
                new int[] { 1, 5 },
                3,
                2,
                0,
                "Example 3");
    }
}
