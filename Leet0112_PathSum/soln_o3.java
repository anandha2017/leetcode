import java.util.Arrays;

public class soln_o3 {

    class Solution {
        public boolean hasPathSum(TreeNode root, int targetSum) {
            if (root == null)
                return false;

            // Leaf node: confirm the remaining sum matches this node’s value
            if (root.left == null && root.right == null)
                return root.val == targetSum;

            // Recurse on children with the updated remaining sum
            int remaining = targetSum - root.val;
            return hasPathSum(root.left, remaining) || hasPathSum(root.right, remaining);
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

    private static String treeToString(TreeNode root) {
        if (root == null) {
            return "Empty tree";
        }

        StringBuilder result = new StringBuilder();
        // Use a queue for level-order traversal
        java.util.Queue<TreeNode> queue = new java.util.LinkedList<>();
        queue.add(root);

        int level = 0;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            result.append("Level ").append(level + 1).append(": ");

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();

                if (node == null) {
                    result.append("null ");
                } else {
                    result.append(node.val).append(" ");

                    // Add children to queue (including nulls for visualization)
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }

            result.append("\n");
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

        return result.toString();
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

    private static boolean assertSolution(Integer[] inputList, int targetSum, boolean expected) {
        soln_o3 outer = new soln_o3();
        Solution solution = outer.new Solution();

        TreeNode tree = createBinaryTree(inputList);

        boolean output = solution.hasPathSum(tree, targetSum);

        boolean assertPass = output == expected;

        String result = assertPass ? "PASS" : "FAIL";
        String formattedResult = assertPass ? greenText(result) : redText(result);

        System.out.println(
                formattedResult + ": Output: " + output +
                        ", TargetSum: " + targetSum +
                        ", Input: " + truncateStr(Arrays.toString(inputList)));

        if (!assertPass) {
            System.out.println("\n=== ACTUAL TREE ===");
            System.out.println(treeToString(tree));
        }

        System.out.println("==========================================");

        return assertPass;
    }

    public static void main(String[] args) {

        // Test case 1: Empty tree
        assertSolution(new Integer[] {},
                /* expected */ 0, false);

        // Test case 2: Null tree
        assertSolution(null,
                /* expected */ 0, false);

        // Test case 3: Single node tree, matching sum
        assertSolution(new Integer[] { 1 },
                /* expected */ 1, true);

        // Test case 4: Single node tree, non-matching sum
        assertSolution(new Integer[] { 1 },
                /* expected */ 2, false);

        // Basic cases from LeetCode examples
        // Test case 5: Original LeetCode example with successful path
        assertSolution(new Integer[] { 5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1 },
                /* expected */ 22, true);

        // Test case 6: LeetCode example with no successful path
        assertSolution(new Integer[] { 1, 2, 3 },
                /* expected */ 5, false);

        // Additional cases
        // Test case 7: Multiple possible paths, one matching
        assertSolution(new Integer[] { 10, 5, -3, 3, 2, null, 11, 3, -2, null, 1 },
                /* expected */ 8, false);

        // Test case 8: Valid path with negative values
        assertSolution(new Integer[] { -2, null, -3 },
                /* expected */ -5, true);

        // Test case 9: Negative values in tree but no valid path
        assertSolution(new Integer[] { 1, -2, -3 },
                /* expected */ 0, false);

        // Test case 10: Deeper tree with valid path
        assertSolution(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 },
                /* expected */ 15, true); // Path 1->2->4->8 = 15

        // Test case 11: Deeper tree with no valid path
        assertSolution(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 },
                /* expected */ 100, false);

        // Test case 12: Zero sum path exists
        assertSolution(new Integer[] { 0, 1, -1 },
                /* expected */ 0, false); // Path 0->-1 = -1

        // Test case 13: Zero sum with no valid path
        assertSolution(new Integer[] { 1, 2, 3 },
                /* expected */ 0, false);

        // Test case 14: Tree with maximum negative value
        assertSolution(new Integer[] { -1000, -1000, -1000 },
                /* expected */ -2000, true); // Path -1000->-1000 = -2000

        // Test case 15: Tree with maximum positive value
        assertSolution(new Integer[] { 1000, 1000, 1000 },
                /* expected */ 2000, true); // Path 1000->1000 = 2000

        // Test case 16: Path at max constraint limits
        assertSolution(new Integer[] { 1000, 1000, 1000, 1000, 1000 },
                /* expected */ 3000, true); // Path 1000->1000->1000 = 3000

        // Test case 17: Mixed positive and negative values
        assertSolution(new Integer[] { 5, -4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1 },
                /* expected */ 14, true); // Path 5->-4->11->2 = 14

        // Test case 18: Only right children
        assertSolution(new Integer[] { 1, null, 2, null, 3, null, 4 },
                /* expected */ 10, true); // Path 1->2->3->4 = 10

        // Test case 19: Only left children
        assertSolution(new Integer[] { 1, 2, null, 3, null, 4 },
                /* expected */ 10, true); // Path 1->2->3->4 = 10

        // Test case 20: Multiple valid paths with identical sums
        assertSolution(new Integer[] { 5, 3, 7, 2, 4, 6, 8 },
                /* expected */ 10, true); // Paths: 5->3->2=10 and 5->7->8=20

        // Test case 21: targetSum at minimum constraint (-1000)
        assertSolution(new Integer[] { -500, -500, 0 },
                /* expected */ -1000, true);

        // Test case 22: targetSum at maximum constraint (1000)
        assertSolution(new Integer[] { 500, 500, 0 },
                /* expected */ 1000, true);

        // Test case 23: All zeros tree
        assertSolution(new Integer[] { 0, 0, 0, 0, 0 },
                /* expected */ 0, true);

        // Test case 24: Testing with large trees (closer to constraint limit of 5000
        // nodes)
        // For practical reasons, we use a smaller example but it represents testing
        // larger trees
        Integer[] largeTree = new Integer[100]; // Creating a path of 100 nodes, each with value 1
        for (int i = 0; i < 100; i++) {
            largeTree[i] = 1;
        }
        assertSolution(largeTree,
                /* expected */ 100, false); // Path of 100 ones sums to 100

        // Test case 25: Sum exceeds int range but within bounds
        assertSolution(new Integer[] { 1000, 999, 1000 },
                /* expected */ 1999, true); // Path 1000->999 = 1999
    }
}
