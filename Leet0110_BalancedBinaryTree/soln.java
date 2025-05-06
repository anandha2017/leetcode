package Leet0110_BalancedBinaryTree;

import java.util.Arrays;

public class soln {

    class Solution {

        public boolean isBalanced(TreeNode root) {

            return inOrderTraversal(root);
        }

        public boolean inOrderTraversal(TreeNode root) {

            boolean isBalanced = true;

            if (root == null) {
                return true;
            }

            int leftDepth = maxDepth(root.left);
            int rightDepth = maxDepth(root.right);

            if (Math.abs(leftDepth - rightDepth) > 1) {
                return false;
            }

            isBalanced = inOrderTraversal(root.left);
            if (isBalanced == false) {
                return false;
            }

            isBalanced = inOrderTraversal(root.right);
            if (isBalanced == false) {
                return false;
            }

            return true;
        }

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

    private static boolean assertSolution(Integer[] inputList, boolean expected) {
        soln outer = new soln();
        Solution solution = outer.new Solution();

        TreeNode tree = createBinaryTree(inputList);

        boolean output = solution.isBalanced(tree);

        boolean assertPass = output == expected;

        String result = assertPass ? "PASS" : "FAIL";
        String formattedResult = assertPass ? greenText(result) : redText(result);

        System.out.println(formattedResult + ": Input: " + truncateStr(Arrays.toString(inputList)));

        if (!assertPass) {
            System.out.println("\n=== ACTUAL TREE ===");
            System.out.println(treeToString(tree));
        }

        System.out.println("==========================================");

        return assertPass;
    }

    // Helper method to build a balanced tree of a given height
    private static Integer[] buildBalancedTree(int height) {
        int size = (int) Math.pow(2, height) - 1;
        Integer[] result = new Integer[size];
        for (int i = 0; i < size; i++) {
            result[i] = i + 1; // Just fill with sequential numbers
        }
        return result;
    }

    // Helper method to build an unbalanced (left-heavy) tree
    private static Integer[] buildUnbalancedTree(int height) {
        // Creates a tree with left side fully populated and right side empty
        int fullTreeSize = (int) Math.pow(2, height) - 1;
        Integer[] result = new Integer[fullTreeSize];

        // Root node
        result[0] = 1;

        // Construct left-heavy unbalanced tree
        for (int i = 1; i < fullTreeSize; i++) {
            // Only populate left children
            if (i % 2 == 1) {
                result[i] = i + 1;
            } else {
                result[i] = null;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        // Empty tree - should be balanced
        assertSolution(new Integer[] { null },
                /* expected */ true);

        // Single node tree - should be balanced
        assertSolution(new Integer[] { 1 },
                /* expected */ true);

        // Two level balanced tree
        assertSolution(new Integer[] { 3, 9, 20 },
                /* expected */ true);

        // Three level balanced tree (example 1)
        assertSolution(new Integer[] { 3, 9, 20, null, null, 15, 7 },
                /* expected */ true);

        // Unbalanced tree with height difference of 2 (example 2)
        assertSolution(new Integer[] { 1, 2, 2, 3, 3, null, null, 4, 4 },
                /* expected */ false);

        // Unbalanced tree - left heavy
        assertSolution(new Integer[] { 1, 2, null, 3 },
                /* expected */ false);

        // Unbalanced tree - right heavy
        assertSolution(new Integer[] { 1, null, 2, null, 3 },
                /* expected */ false);

        // Perfect balanced tree (all levels completely filled)
        assertSolution(new Integer[] { 1, 2, 3, 4, 5, 6, 7 },
                /* expected */ true);

        // Balanced tree with some missing leaves
        assertSolution(new Integer[] { 1, 2, 3, null, 4, null, 5 },
                /* expected */ true);

        // Tree with balanced height but right-leaning
        assertSolution(new Integer[] { 1, null, 2, null, 3, null, 4, null, 5 },
                /* expected */ false);

        // Tree with balanced height but left-leaning
        assertSolution(new Integer[] { 1, 2, null, 3, null, 4, null, 5 },
                /* expected */ false);

        // Balanced tree with max negative values
        assertSolution(new Integer[] { -10000, -10000, -10000 },
                /* expected */ true);

        // Balanced tree with max positive values
        assertSolution(new Integer[] { 10000, 10000, 10000 },
                /* expected */ true);

        // Large balanced tree at the edge of constraints (not all 5000 nodes shown)
        assertSolution(buildBalancedTree(12), // 2^12 - 1 = 4095 nodes (approx)
                /* expected */ true);

        // Large unbalanced tree at the edge of constraints
        assertSolution(buildUnbalancedTree(12), // creates a left-heavy tree with ~4000 nodes
                /* expected */ false);

        // Tree with zigzag pattern that is balanced
        assertSolution(new Integer[] { 1, 2, 3, null, 4, null, 5, null, null, 6 },
                /* expected */ false);

        // Tree that's balanced at the root but has unbalanced subtrees
        assertSolution(new Integer[] { 3, 9, 20, 4, 5, 15, 7, 6, null, null, null, null, null, null, 8 },
                /* expected */ true);

        // LeetCode fail
        assertSolution(new Integer[] { 1, 2, 2, 3, null, null, 3, 4, null, null, 4 },
                /* expected */ false);
    }
}
