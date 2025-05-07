package Leet0111_MinimumDepthofBinaryTree;

import java.util.Arrays;

public class soln {

    class Solution {

        public int minDepth(TreeNode root) {

            if (root == null) {
                return 0;
            }

            return 1 + Math.min(
                    minDepth(root.left),
                    minDepth(root.right));
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

    private static boolean assertSolution(Integer[] inputList, int expected) {
        soln outer = new soln();
        Solution solution = outer.new Solution();

        TreeNode tree = createBinaryTree(inputList);

        int output = solution.minDepth(tree);

        boolean assertPass = output == expected;

        String result = assertPass ? "PASS" : "FAIL";
        String formattedResult = assertPass ? greenText(result) : redText(result);

        System.out.println(formattedResult + ": Output: " + output + ", Input: " + truncateStr(Arrays.toString(inputList)));

        if (!assertPass) {
            System.out.println("\n=== ACTUAL TREE ===");
            System.out.println(treeToString(tree));
        }

        System.out.println("==========================================");

        return assertPass;
    }

    public static void main(String[] args) {

        // Test cases for Minimum Depth of Binary Tree problem

        // Edge cases
        assertSolution(new Integer[] { null },
                /* expected */ 0);

        assertSolution(new Integer[] { 1 },
                /* expected */ 1);

        // Basic cases
        assertSolution(new Integer[] { 3, 9, 20 },
                /* expected */ 2);

        assertSolution(new Integer[] { 3, 9, 20, null, null, 15, 7 },
                /* expected */ 2);

        // Unbalanced trees
        assertSolution(new Integer[] { 2, null, 3, null, 4, null, 5, null, 6 },
                /* expected */ 5);

        // assertSolution(new Integer[] { 1, 2, null, 3, null, 4, null, 5 },
        //         /* expected */ 5);

        // // Trees with different depths on left and right
        // assertSolution(new Integer[] { 1, 2, 3, 4, null, null, 5, 6, null, null, 7 },
        //         /* expected */ 3);

        // assertSolution(new Integer[] { 1, 2, 3, 4, null, 5, 6, null, null, 7 },
        //         /* expected */ 2);

        // // Complete balanced tree
        // assertSolution(new Integer[] { 1, 2, 3, 4, 5, 6, 7 },
        //         /* expected */ 3);

        // // Complete tree with multiple levels
        // assertSolution(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 },
        //         /* expected */ 4);

        // // Trees with negative values (values shouldn't affect the depth calculation)
        // assertSolution(new Integer[] { -10, -20, -30 },
        //         /* expected */ 2);

        // // Large tree (edge of constraints)
        // Integer[] largeTree = new Integer[100000];
        // largeTree[0] = 1;
        // for (int i = 1; i < 100000; i++) {
        //     if (i % 2 == 1) { // Left child
        //         largeTree[i] = i + 1;
        //     } else { // Right child is null
        //         largeTree[i] = null;
        //     }
        // }
        // assertSolution(largeTree,
        //         /* expected */ 50000);

        // // Tree with only left children
        // assertSolution(new Integer[] { 1, 2, null, 3, null, 4, null, 5, null },
        //         /* expected */ 5);

        // // Tree with only right children
        // assertSolution(new Integer[] { 1, null, 2, null, 3, null, 4, null, 5 },
        //         /* expected */ 5);

        // // Tree with multiple potential minimum paths
        // assertSolution(new Integer[] { 1, 2, 3, null, 4, null, 5, null, null, 6 },
        //         /* expected */ 3);

        // // Tree with leaf nodes at different levels
        // assertSolution(new Integer[] { 1, 2, 3, 4, 5, null, 6, null, null, 7, 8 },
        //         /* expected */ 3);

        // // Tree with values at the boundaries of constraints
        // assertSolution(new Integer[] { 1000, -1000, 0 },
        //         /* expected */ 2);

        // // More complex tree structures
        // assertSolution(new Integer[] { 5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1 },
        //         /* expected */ 3);

        // assertSolution(new Integer[] { 3, 1, 4, null, 2, null, 5 },
        //         /* expected */ 3);

    }
}
