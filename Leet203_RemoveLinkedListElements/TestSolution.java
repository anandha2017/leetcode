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

        System.out.println(linkedListToString(head));

        return head;
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

        // Create the linked lists using the helper method
        ListNode inputList = createLinkedList(input);
        ListNode outputList = solution.removeElements(inputList, val);

        // boolean assertPass;
        // if (expected == 0) {
        // // Expected no intersection
        // assertPass = (output == null);
        // } else {
        // // Expected an intersection with specific value
        // assertPass = (output != null && output.val == expected);
        // }

        // String result = assertPass ? "PASS" : "FAIL";
        // String formattedResult = assertPass ? greenText(result) : redText(result);

        // System.out.println(
        // formattedResult + ": " + testName +
        // " - Output: " + (output == null ? "null" : output.val) +
        // ", Expected: " + expected +
        // ", Intersection: " + (intersectionNode == null ? "null" :
        // intersectionNode.val) +
        // ", ListA: " + truncateStr(linkedListToString(headA)) +
        // ", ListB: " + truncateStr(linkedListToString(headB)));

        return false;
    }

    public static void main(String[] args) {
        assertSolution(
                new int[] { 1, 2, 6, 3, 4, 5, 6 },
                6,
                new int[] { 1, 2, 3, 4, 5 },
                "Example 1");
    }
}
