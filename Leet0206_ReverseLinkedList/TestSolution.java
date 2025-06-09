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

        ListNode outputList = solution.reverseList(inputList);

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
        assertSolution(new int[] { 1, 2, 3, 4, 5, 6, 7 }, new int[] { 7, 6, 5, 4, 3, 2, 1 }, "Example 1 - Basic");
    }
}
