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
     * Converts a linked list to a string representation.
     * Handles cycles by detecting and marking them in the output.
     *
     * @param head The head of the linked list
     * @return A string representation of the linked list
     */
    private static String linkedListToString(ListNode head) {
        if (head == null) return "null";

        StringBuilder sb = new StringBuilder();
        ListNode current = head;
        int nodeCount = 0;
        final int MAX_NODES = 20; // Limit to prevent infinite loops with cycles

        // Use a HashSet to detect cycles
        java.util.Set<ListNode> visited = new java.util.HashSet<>();

        while (current != null && nodeCount < MAX_NODES) {
            if (visited.contains(current)) {
                // We found a cycle
                sb.append(" → CYCLE to ").append(current.val);
                break;
            }

            sb.append(current.val);
            visited.add(current);

            if (current.next != null) {
                sb.append(" → ");
            } else {
                sb.append(" → null");
            }

            current = current.next;
            nodeCount++;
        }

        if (nodeCount == MAX_NODES && current != null) {
            sb.append("...");
        }

        return sb.toString();
    }

    /**
     * Tests the hasCycle solution with the given linked list and expected result.
     *
     * @param head     The head of the linked list to test
     * @param expected The expected result (true if there's a cycle, false otherwise)
     * @param testName A descriptive name for the test case
     * @return true if the test passes, false otherwise
     */
    private static boolean assertSolution(ListNode head, boolean expected, String testName) {
        Solution solution = new Solution();
        boolean output = solution.hasCycle(head);

        boolean assertPass = output == expected;

        String result = assertPass ? "PASS" : "FAIL";
        String formattedResult = assertPass ? greenText(result) : redText(result);

        System.out.println(
                formattedResult + ": " + testName +
                " - Output: " + output +
                ", Expected: " + expected +
                ", List: " + truncateStr(linkedListToString(head)));

        return assertPass;
    }

    /**
     * Creates a linked list with a cycle.
     *
     * @param values The values for the linked list nodes
     * @param pos    The position to connect the tail to (0-indexed), or -1 for no cycle
     * @return The head of the created linked list
     */
    private static ListNode createLinkedList(int[] values, int pos) {
        if (values == null || values.length == 0) {
            return null;
        }

        // Create nodes
        ListNode[] nodes = new ListNode[values.length];
        for (int i = 0; i < values.length; i++) {
            nodes[i] = new ListNode(values[i]);
        }

        // Connect nodes
        for (int i = 0; i < values.length - 1; i++) {
            nodes[i].next = nodes[i + 1];
        }

        // Create cycle if pos is valid
        if (pos >= 0 && pos < values.length) {
            nodes[values.length - 1].next = nodes[pos];
        }

        return nodes[0];
    }

    public static void main(String[] args) {
        // Test cases based on examples from the problem description

        // Example 1: [3,2,0,-4], pos = 1
        ListNode example1 = createLinkedList(new int[]{3, 2, 0, -4}, 1);
        assertSolution(example1, true, "Example 1: Cycle at position 1");

        // Example 2: [1,2], pos = 0
        ListNode example2 = createLinkedList(new int[]{1, 2}, 0);
        assertSolution(example2, true, "Example 2: Cycle at position 0");

        // Example 3: [1], pos = -1
        ListNode example3 = createLinkedList(new int[]{1}, -1);
        assertSolution(example3, false, "Example 3: No cycle");

        // Example 4: [5,8,3,1,4,7,2], pos = 3
        ListNode example4 = createLinkedList(new int[]{5, 8, 3, 1, 4, 7, 2}, 3);
        assertSolution(example4, true, "Example 4: Cycle at position 3");

        // Example 5: [9,4,7,2,1,3,5], pos = -1
        ListNode example5 = createLinkedList(new int[]{9, 4, 7, 2, 1, 3, 5}, -1);
        assertSolution(example5, false, "Example 5: No cycle");

        // Edge case: Empty list
        ListNode emptyList = null;
        assertSolution(emptyList, false, "Edge case: Empty list");

        // Edge case: Single node with self-loop
        ListNode selfLoop = new ListNode(1);
        selfLoop.next = selfLoop;
        assertSolution(selfLoop, true, "Edge case: Single node with self-loop");
    }
}
