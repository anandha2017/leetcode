package Leet203_RemoveLinkedListElements;

import Leet203_RemoveLinkedListElements.Soln.Solution;

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

    private static boolean assertSolution(
            int[] input,
            int val,
            int[] expected,
            String testName) {

        Soln outer = new Soln();
        Solution solution = outer.new Solution();

        ListNode inputList = createLinkedList(input);
        ListNode inputListCopy = createLinkedList(input);
        ListNode expectedList = createLinkedList(expected);

        ListNode outputList = solution.removeElements(inputList, val);

        boolean assertPass = isEqual(outputList, expectedList);

        String result = assertPass ? "PASS" : "FAIL";
        String formattedResult = assertPass ? greenText(result) : redText(result);

        System.out.println(
                formattedResult + ": " + testName +
                        ", Input: " + truncateStr(linkedListToString(inputListCopy)) +
                        ", Val: " + val +
                        ", Output: " + truncateStr(linkedListToString(outputList)) +
                        ", Expected: " + truncateStr(linkedListToString(expectedList)));

        return assertPass;
    }

    public static void main(String[] args) {
        // Basic Examples
        assertSolution(
                new int[] { 1, 2, 6, 3, 4, 5, 6 },
                6,
                new int[] { 1, 2, 3, 4, 5 },
                "Example 1 - Multiple occurrences");

        assertSolution(
                new int[] {},
                1,
                new int[] {},
                "Example 2 - Empty list");

        assertSolution(
                new int[] { 7, 7, 7, 7 },
                7,
                new int[] {},
                "Example 3 - All nodes removed");

        // Edge Cases - Single Node
        assertSolution(
                new int[] { 1 },
                1,
                new int[] {},
                "Single node - remove");

        assertSolution(
                new int[] { 1 },
                2,
                new int[] { 1 },
                "Single node - keep");

        // Head Removal Cases
        assertSolution(
                new int[] { 1, 2, 3 },
                1,
                new int[] { 2, 3 },
                "Remove head only");

        assertSolution(
                new int[] { 1, 1, 2, 3 },
                1,
                new int[] { 2, 3 },
                "Remove consecutive heads");

        assertSolution(
                new int[] { 1, 1, 1, 2 },
                1,
                new int[] { 2 },
                "Remove multiple consecutive heads");

        // Tail Removal Cases
        assertSolution(
                new int[] { 1, 2, 3 },
                3,
                new int[] { 1, 2 },
                "Remove tail only");

        assertSolution(
                new int[] { 1, 2, 3, 3 },
                3,
                new int[] { 1, 2 },
                "Remove consecutive tails");

        assertSolution(
                new int[] { 1, 2, 2, 2 },
                2,
                new int[] { 1 },
                "Remove multiple consecutive tails");

        // Middle Removal Cases
        assertSolution(
                new int[] { 1, 2, 3, 4, 5 },
                3,
                new int[] { 1, 2, 4, 5 },
                "Remove middle single");

        assertSolution(
                new int[] { 1, 2, 2, 3 },
                2,
                new int[] { 1, 3 },
                "Remove consecutive middle");

        assertSolution(
                new int[] { 1, 2, 3, 2, 4 },
                2,
                new int[] { 1, 3, 4 },
                "Remove non-consecutive middle");

        // Mixed Position Cases
        assertSolution(
                new int[] { 1, 2, 1, 3, 1 },
                1,
                new int[] { 2, 3 },
                "Remove head, middle, and tail");

        assertSolution(
                new int[] { 2, 1, 1, 2, 1, 2 },
                2,
                new int[] { 1, 1, 1 },
                "Remove alternating positions");

        // No Matches Cases
        assertSolution(
                new int[] { 1, 2, 3, 4, 5 },
                6,
                new int[] { 1, 2, 3, 4, 5 },
                "No matches - small list");

        assertSolution(
                new int[] { 10, 20, 30, 40, 50 },
                5,
                new int[] { 10, 20, 30, 40, 50 },
                "No matches - larger values");

        // Boundary Value Cases (based on constraints: 1 ≤ Node.val ≤ 50, 0 ≤ val ≤ 50)
        assertSolution(
                new int[] { 1, 1, 1 },
                1,
                new int[] {},
                "Minimum node value - all removed");

        assertSolution(
                new int[] { 50, 50, 50 },
                50,
                new int[] {},
                "Maximum node value - all removed");

        assertSolution(
                new int[] { 1, 25, 50 },
                0,
                new int[] { 1, 25, 50 },
                "Minimum search value - no matches");

        assertSolution(
                new int[] { 1, 2, 3 },
                50,
                new int[] { 1, 2, 3 },
                "Maximum search value - no matches");

        // Large List Cases (approaching constraint: number of nodes ≤ 10^4)
        assertSolution(
                new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 },
                5,
                new int[] { 1, 2, 3, 4, 6, 7, 8, 9, 10 },
                "Longer list - single removal");

        assertSolution(
                new int[] { 5, 1, 5, 2, 5, 3, 5, 4, 5 },
                5,
                new int[] { 1, 2, 3, 4 },
                "Longer list - multiple removals");

        // Pattern Cases
        assertSolution(
                new int[] { 1, 2, 1, 2, 1, 2 },
                1,
                new int[] { 2, 2, 2 },
                "Alternating pattern - remove first");

        assertSolution(
                new int[] { 1, 2, 1, 2, 1, 2 },
                2,
                new int[] { 1, 1, 1 },
                "Alternating pattern - remove second");

        // Two-element Cases
        assertSolution(
                new int[] { 1, 2 },
                1,
                new int[] { 2 },
                "Two elements - remove first");

        assertSolution(
                new int[] { 1, 2 },
                2,
                new int[] { 1 },
                "Two elements - remove second");

        assertSolution(
                new int[] { 1, 1 },
                1,
                new int[] {},
                "Two identical elements - remove both");

        assertSolution(
                new int[] { 1, 2 },
                3,
                new int[] { 1, 2 },
                "Two elements - remove neither");

        // Stress Test Cases
        assertSolution(
                new int[] { 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25 },
                25,
                new int[] {},
                "All identical elements - large count");

        assertSolution(
                new int[] { 1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23, 25, 27, 29 },
                30,
                new int[] { 1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23, 25, 27, 29 },
                "Sequential odd numbers - no matches");
    }
}
