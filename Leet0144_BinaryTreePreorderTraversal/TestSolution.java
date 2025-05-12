package Leet0144_BinaryTreePreorderTraversal;

import java.util.Arrays;
import java.util.List;

import Leet0144_BinaryTreePreorderTraversal.soln.Solution;

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

    private static boolean assertSolution(Integer[] inputTree, Integer[] expected) {
        soln outer = new soln();
        Solution solution = outer.new Solution();

        TreeNode root = createBinaryTree(inputTree);

        List<Integer> output = solution.preorderTraversal(root);

        boolean assertPass = output.equals(Arrays.asList(expected));

        String result = assertPass ? "PASS" : "FAIL";
        String formattedResult = assertPass ? greenText(result) : redText(result);

        System.out.println(
                formattedResult + ": Output: " + output + ", Input: " + truncateStr(Arrays.toString(inputTree)));

        if (!assertPass) {
            System.out.println("\n=== ACTUAL TREE ===");
            System.out.println(treeToString(root));
        }

        System.out.println("==========================================");

        return assertPass;
    }

    public static void main(String[] args) {

        // Basic test cases
        assertSolution(new Integer[] { 1, null, 2, 3 }, new Integer[] { 1, 2, 3 });
        assertSolution(new Integer[] {}, new Integer[] {});
        assertSolution(new Integer[] { 1 }, new Integer[] { 1 });
        assertSolution(new Integer[] { 1, 2, 3, 4, 5, null, 6 }, new Integer[] { 1, 2, 4, 5, 3, 6 });

        // Test with only left children
        assertSolution(new Integer[] { 1, 2, null, 3, null, 4, null }, new Integer[] { 1, 2, 3, 4 });

        // Test with only right children
        assertSolution(new Integer[] { 1, null, 2, null, 3, null, 4 }, new Integer[] { 1, 2, 3, 4 });

        // Balanced tree
        assertSolution(new Integer[] { 1, 2, 3, 4, 5, 6, 7 }, new Integer[] { 1, 2, 4, 5, 3, 6, 7 });

        // Unbalanced tree
        assertSolution(new Integer[] { 5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1 },
                new Integer[] { 5, 4, 11, 7, 2, 8, 13, 4, 1 });

        // Test with negative values
        assertSolution(new Integer[] { -10, 9, -20, null, null, 15, 7 }, new Integer[] { -10, 9, -20, 15, 7 });

        // Test with duplicated values
        assertSolution(new Integer[] { 2, 2, 2 }, new Integer[] { 2, 2, 2 });

        // Zigzag tree
        assertSolution(new Integer[] { 3, 9, 20, null, null, 15, 7 }, new Integer[] { 3, 9, 20, 15, 7 });

        // Test with values at constraint boundaries
        assertSolution(new Integer[] { 100, -100, 0 }, new Integer[] { 100, -100, 0 });

        // Full binary tree (every node has 0 or 2 children)
        assertSolution(new Integer[] { 1, 2, 3, 4, 5, 6, 7 }, new Integer[] { 1, 2, 4, 5, 3, 6, 7 });

        // Complete binary tree (all levels filled except possibly the last)
        assertSolution(new Integer[] { 1, 2, 3, 4, 5, 6 }, new Integer[] { 1, 2, 4, 5, 3, 6 });

        // Perfect binary tree (all internal nodes have two children and all leaf nodes
        // are at the same level)
        assertSolution(new Integer[] { 1, 2, 3, 4, 5, 6, 7 }, new Integer[] { 1, 2, 4, 5, 3, 6, 7 });

        // Tree with one node at each level
        assertSolution(new Integer[] { 1, null, 2, null, 3, null, 4 }, new Integer[] { 1, 2, 3, 4 });

        // Tree with maximum number of nodes at each level
        assertSolution(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 },
                new Integer[] { 1, 2, 4, 8, 9, 5, 10, 11, 3, 6, 12, 13, 7, 14, 15 });

        // Tree with nodes having the same values
        assertSolution(new Integer[] { 5, 5, 5, 5, 5 }, new Integer[] { 5, 5, 5, 5, 5 });
    }
}
