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

    private static int[] createArrayOfSize(int size, int intersectionValue) {
        int[] array = new int[size];
        for (int i = 0; i < size - 1; i++) {
            array[i] = i + 1;
        }
        array[size - 1] = intersectionValue;
        return array;
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

    public static void main(String[] args) {
        // Regular intersection cases with different list lengths
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

        // Edge cases: Minimal length lists
        // Example 4: Single node lists that intersect
        assertSolution(
                1,
                new int[] { 1 },
                new int[] { 1 },
                0,
                0,
                1,
                "Single node lists that intersect");

        // Example 5: Two identical lists (full overlap)
        assertSolution(
                5,
                new int[] { 5, 6, 7 },
                new int[] { 5, 6, 7 },
                0,
                0,
                5,
                "Two identical lists (full overlap)");

        // Example 6: Intersection at the beginning of both lists
        assertSolution(
                10,
                new int[] { 10, 11, 12 },
                new int[] { 10, 11, 12 },
                0,
                0,
                10,
                "Intersection at beginning of both lists");

        // Example 7: Intersection at the end of both lists
        assertSolution(
                99,
                new int[] { 1, 2, 3, 99 },
                new int[] { 7, 8, 99 },
                3,
                2,
                99,
                "Intersection at end of both lists");

        // Boundary cases: Maximum size differences
        // Example 8: First list much longer than second
        assertSolution(
                42,
                new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 42, 43 },
                new int[] { 99, 42, 43 },
                15,
                1,
                42,
                "First list much longer than second");

        // Example 9: Second list much longer than first
        assertSolution(
                50,
                new int[] { 77, 50, 51, 52 },
                new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 50, 51, 52 },
                1,
                14,
                50,
                "Second list much longer than first");

        // Example 10: Lists with maximum allowed values
        assertSolution(
                100000,
                new int[] { 100000, 100001 },
                new int[] { 1, 2, 3, 100000, 100001 },
                0,
                3,
                100000,
                "Lists with maximum allowed values");

        // Example 11: Boundary lengths
        assertSolution(
                5,
                createArrayOfSize(30000, 5), // Create array of 30,000 elements with intersection value 5
                createArrayOfSize(30000, 5),
                29999,
                29999,
                5,
                "Maximum length lists");

        // Example 12: First list is subset of second list
        assertSolution(
                15,
                new int[] { 15, 16, 17, 18 },
                new int[] { 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 },
                0,
                4,
                15,
                "First list is subset of second");

        // Example 13: Second list is subset of first list
        assertSolution(
                25,
                new int[] { 21, 22, 23, 24, 25, 26, 27, 28, 29, 30 },
                new int[] { 25, 26, 27, 28 },
                4,
                0,
                25,
                "Second list is subset of first");

        // Example 14: Duplicate values before intersection
        assertSolution(
                7,
                new int[] { 5, 5, 5, 5, 7, 8, 9 },
                new int[] { 1, 5, 5, 7, 8, 9 },
                4,
                3,
                7,
                "Duplicate values before intersection");

        // Example 15: Intersection with one empty branch
        assertSolution(
                8,
                new int[] { 8, 9, 10 },
                new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 },
                0,
                7,
                8,
                "Intersection with one empty branch");
    }
}
