import java.util.Arrays;

public class soln {

    class Solution {
        public int maxDepth(TreeNode root) {

            if (root == null) {
                return 0;
            }

            return 1 + Math.max(
                    maxDepth(root.left),
                    maxDepth(root.right));
        }
    }

    private static final int MAX_STRING_LENGTH = 50;
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
        if (values == null || values.length == 0 || values[0] == null) {
            return null;
        }

        // Create the root node
        TreeNode root = new TreeNode(values[0]);

        // Use a queue to keep track of nodes that need children
        java.util.Queue<TreeNode> queue = new java.util.LinkedList<>();
        queue.add(root);
        int i = 1; // Start from the second element

        // Process the rest of the values
        while (!queue.isEmpty() && i < values.length) {
            // Get the next node that needs children
            TreeNode current = queue.poll();

            // Assign left child if value is not null
            if (i < values.length) {
                if (values[i] != null) {
                    current.left = new TreeNode(values[i]);
                    queue.add(current.left);
                }
                i++;
            }

            // Assign right child if value is not null
            if (i < values.length) {
                if (values[i] != null) {
                    current.right = new TreeNode(values[i]);
                    queue.add(current.right);
                }
                i++;
            }
        }

        return root;
    }

    private static void printTree(TreeNode root) {
        if (root == null) {
            System.out.println("Empty tree");
            return;
        }

        // Use a queue for level-order traversal
        java.util.Queue<TreeNode> queue = new java.util.LinkedList<>();
        queue.add(root);

        System.out.println("Tree structure:");
        int level = 0;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            System.out.print("Level " + (level+1) + ": ");

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();

                if (node == null) {
                    System.out.print("null ");
                } else {
                    System.out.print(node.val + " ");

                    // Add children to queue (including nulls for visualization)
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }

            System.out.println();
            level++;

            // Check if the next level has only nulls
            boolean allNull = true;
            for (TreeNode node : queue) {
                if (node != null) {
                    allNull = false;
                    break;
                }
            }

            if (allNull) {
                break;
            }
        }
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

    private static boolean assertSolution(Integer[] inputList, int expected) {
        soln outer = new soln();
        Solution solution = outer.new Solution();

        TreeNode root = createBinaryTree(inputList);

        int output = solution.maxDepth(root);

        boolean assertPass = output == expected;

        String result = assertPass ? "PASS" : "FAIL";
        String formattedResult = assertPass ? greenText(result) : redText(result);

        System.out.println(
                formattedResult + ": " +
                        "Input: " + truncateStr(Arrays.toString(inputList)) + ", " +
                        "Expected: " + expected +
                        (assertPass ? "" : ", Got: " + output));

        if (!assertPass) { printTree(root); }

        return assertPass;
    }

    public static void main(String[] args) {
        // Base cases
        assertSolution(new Integer[] {}, 0); // Empty tree
        assertSolution(new Integer[] { 1 }, 1); // Single node tree

        // Basic cases with different depths
        assertSolution(new Integer[] { 1, 2 }, 2); // Root with left child
        assertSolution(new Integer[] { 1, null, 2 }, 2); // Root with right child
        assertSolution(new Integer[] { 1, 2, 3 }, 2); // Full tree of depth 2
        assertSolution(new Integer[] { 3, 9, 20, null, null, 15, 7 }, 3); // Example from problem

        // Left-skewed trees
        assertSolution(new Integer[] { 1, 2, null, 3 }, 3); // Left-skewed depth 3
        assertSolution(new Integer[] { 1, 2, null, 3, null, 4 }, 4); // Left-skewed depth 4

        // Right-skewed trees
        assertSolution(new Integer[] { 1, null, 2, null, 3 }, 3); // Right-skewed depth 3
        assertSolution(new Integer[] { 1, null, 2, null, null, null, 3 }, 2); // Right-skewed with gaps

        // Balanced trees
        assertSolution(new Integer[] { 1, 2, 3, 4, 5, 6, 7 }, 3); // Perfect binary tree depth 3
        assertSolution(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }, 4); // Partial depth 4

        // Unbalanced trees
        assertSolution(new Integer[] { 1, 2, null, 3, 4 }, 3); // Deeper on left branch
        assertSolution(new Integer[] { 1, null, 2, 3, 4 }, 3); // Deeper on right branch
        assertSolution(new Integer[] { 5, 4, 7, 3, null, 2, null, null, null, 9 }, 4); // Complex tree

        // Trees with specific patterns
        assertSolution(new Integer[] { 1, null, 2, 3, null, null, 4 }, 4); // Tree with zigzag pattern
        assertSolution(new Integer[] { 5, 3, 6, 2, 4, null, null, 1 }, 4); // BST-like structure
    }
}
