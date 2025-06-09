package Leet0206_ReverseLinkedList;

import Leet0206_ReverseLinkedList.Soln.Solution;

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

    private static ListNode createLinkedList(int[] list) {

        ListNode head = null;

        if (list.length > 0) {
            head = new ListNode(list[0]);
            ListNode current = head;

            for (int i = 1; i < list.length; i++) {
                current.next = new ListNode(list[i]);
                current = current.next;
            }
        }

        return head;
    }

    private static Boolean isEqual(ListNode headA, ListNode headB) {

        if ((headA == null) && (headB == null)) {
            return true;
        }

        ListNode currentA = headA;
        ListNode currentB = headB;

        while ((currentA != null) && (currentB != null)) {
            if (currentA.val != currentB.val) {
                return false;
            }
            currentA = currentA.next;
            currentB = currentB.next;
        }

        return true;
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

    private static boolean assertSolution(int[] input, int[] expected, String testName) {

        Soln outer = new Soln();
        Solution solution = outer.new Solution();

        ListNode inputList = createLinkedList(input);
        ListNode inputListCopy = createLinkedList(input);
        ListNode expectedList = createLinkedList(expected);

        //ListNode outputList = solution.reverseList(inputList);
        ListNode outputList = solution.reverseListRecursive(inputList);

        boolean assertPass = isEqual(outputList, expectedList);

        String result = assertPass ? "PASS" : "FAIL";
        String formattedResult = assertPass ? greenText(result) : redText(result);

        System.out.println(
                formattedResult + ": " + testName + ", Input: " + truncateStr(linkedListToString(inputListCopy))
                        + ", Output: " + truncateStr(linkedListToString(outputList)) + ", Expected: "
                        + truncateStr(linkedListToString(expectedList)));

        return assertPass;
    }

    public static void main(String[] args) {
        // Edge Cases - Empty and Single Node
        assertSolution(new int[] {}, new int[] {}, "Edge Case - Empty list");
        assertSolution(new int[] { 1 }, new int[] { 1 }, "Edge Case - Single node");

        // Basic Cases
        assertSolution(new int[] { 1, 2 }, new int[] { 2, 1 }, "Basic - Two nodes");
        assertSolution(new int[] { 1, 2, 3 }, new int[] { 3, 2, 1 }, "Basic - Three nodes");
        assertSolution(new int[] { 1, 2, 3, 4, 5 }, new int[] { 5, 4, 3, 2, 1 }, "Basic - Five nodes");

        // Boundary Value Testing
        assertSolution(new int[] { -5000 }, new int[] { -5000 }, "Boundary - Minimum value single");
        assertSolution(new int[] { 5000 }, new int[] { 5000 }, "Boundary - Maximum value single");
        assertSolution(new int[] { -5000, 5000 }, new int[] { 5000, -5000 }, "Boundary - Min max pair");
        assertSolution(new int[] { 0 }, new int[] { 0 }, "Boundary - Zero value");

        // Negative Numbers
        assertSolution(new int[] { -1, -2, -3 }, new int[] { -3, -2, -1 }, "Negative - All negative");
        assertSolution(new int[] { -10, 0, 10 }, new int[] { 10, 0, -10 }, "Mixed - Negative zero positive");

        // Duplicate Values
        assertSolution(new int[] { 1, 1, 1 }, new int[] { 1, 1, 1 }, "Duplicates - All same");
        assertSolution(new int[] { 5, 3, 5, 1, 5 }, new int[] { 5, 1, 5, 3, 5 }, "Duplicates - Mixed values");
        assertSolution(new int[] { 2, 2, 3, 3 }, new int[] { 3, 3, 2, 2 }, "Duplicates - Pairs");

        // Longer Lists
        assertSolution(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }, new int[] { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 },
                "Long - Ten elements");

        // Random Patterns
        assertSolution(new int[] { 42, 17, 99, 3 }, new int[] { 3, 99, 17, 42 }, "Random - Mixed values");
        assertSolution(new int[] { 100, -50, 0, 25, -75 }, new int[] { -75, 25, 0, -50, 100 }, "Random - Mixed signs");

        // Already Sorted Patterns
        assertSolution(new int[] { 1, 2, 3, 4 }, new int[] { 4, 3, 2, 1 }, "Sorted - Ascending");
        assertSolution(new int[] { 4, 3, 2, 1 }, new int[] { 1, 2, 3, 4 }, "Sorted - Descending");

        // Large Values within Constraints
        assertSolution(new int[] { 4999, -4999, 0, 2500, -1250 }, new int[] { -1250, 2500, 0, -4999, 4999 },
                "Large - Near boundary values");
    }
}
