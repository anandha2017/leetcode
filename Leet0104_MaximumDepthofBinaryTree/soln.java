import java.util.Arrays;

public class soln {

    class Solution {
        public int maxDepth(TreeNode root) {

            // implement later
            return 0;
        }
    }

    private static final int TRUNC = 50;
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_GREEN = "\u001B[92m";
    private static final String ANSI_RED = "\u001B[91m";

    private static String greenText(String text) {
        return ANSI_GREEN + text + ANSI_RESET;
    }

    private static String redText(String text) {
        return ANSI_RED + text + ANSI_RESET;
    }

    private static TreeNode createBinaryTree(Integer[] values) {
        if (values == null || values.length == 0) {
            return null;
        }
        return createBinaryTree(values, 0);
    }

    private static TreeNode createBinaryTree(Integer[] values, int index) {
        if (index >= values.length || values[index] == null) {
            return null;
        }

        TreeNode node = new TreeNode(values[index]);
        node.left = createBinaryTree(values, 2 * index + 1);
        node.right = createBinaryTree(values, 2 * index + 2);

        return node;
    }

    // Truncate a string to max_length characters, adding "..." if truncated
    private static String truncateStr(String s, int maxLength) {
        if (s.length() <= maxLength) {
            return s;
        }
        return s.substring(0, maxLength - 3) + "...";
    }

    // Overloaded method with default max length
    private static String truncateStr(String s) {
        return truncateStr(s, TRUNC);
    }

    // Test solution with given input and expected output
    private static boolean assertSolution(Integer[] inputList, int expected) {
        // Create instances of our classes
        soln outer = new soln();
        Solution solution = outer.new Solution();

        // Run the solution on our input
        int output = solution.maxDepth(createBinaryTree(inputList));

        // Check if the output matches expected
        boolean assertPass = output == expected;

        // Format the result string with colors using our helper methods
        String result = assertPass ? "PASS" : "FAIL";
        String formattedResult = assertPass ? greenText(result) :
                redText(result);

        // Print the test result
        System.out.println(
                formattedResult + ": " +
                        "Input: " + truncateStr(Arrays.toString(inputList)) + ", " +
                        "Expected: " + expected +
                        (assertPass ? "" : ", Got: " + output)
        );

        return assertPass;
    }

    public static void main(String[] args) {
        // Test cases for Maximum Depth of Binary Tree
        assertSolution(new Integer[] { 3, 9, 20, null, null, 15, 7 }, 3);
        assertSolution(new Integer[] { 1, null, 2 }, 2);
        assertSolution(new Integer[] {}, 0);
        // Add more test cases as needed
    }

}
