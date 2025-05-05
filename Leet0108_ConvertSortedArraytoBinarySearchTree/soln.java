package Leet0108_ConvertSortedArraytoBinarySearchTree;

import java.util.Arrays;

public class soln {

    class Solution {

        public TreeNode sortedArrayToBST(int[] nums) {

            return helper(nums, 0, nums.length - 1);

            /*
             * FUNCTION buildBST(sortedArray):
             * RETURN helper(sortedArray, 0, length(sortedArray) - 1)
             *
             * FUNCTION helper(arr, leftIndex, rightIndex):
             * IF leftIndex > rightIndex:
             * RETURN null // empty sub‑array ➜ empty child
             *
             * midIndex ← (leftIndex + rightIndex) / 2 // integer division
             *
             * node ← new TreeNode(arr[midIndex]) // create root for this segment
             *
             * node.left ← helper(arr, leftIndex, midIndex - 1) // build left subtree
             * node.right ← helper(arr, midIndex + 1, rightIndex) // build right subtree
             *
             * RETURN node
             */

        }

        private static final TreeNode helper(int[] arr, int leftIndex, int rightIndex) {
            if (leftIndex > rightIndex) {
                return null;
            }

            int midIndex = (leftIndex + rightIndex) / 2;

            TreeNode node = new TreeNode(arr[midIndex]);

            node.left = helper(arr, leftIndex, midIndex - 1);
            node.right = helper(arr, midIndex + 1, rightIndex);

            return node;
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

    private static Boolean isSameTree(TreeNode p, TreeNode q) {

        if ((p == null) && (q == null)) {
            return true;
        }

        if ((p == null) && (q != null)) {
            return false;
        }

        if ((p != null) && (q == null)) {
            return false;
        }

        if (p.val != q.val) {
            return false;
        }

        return (isSameTree(p.left, q.left) &&
                isSameTree(p.right, q.right));
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

    private static boolean assertSolution(int[] inputList, TreeNode expected) {
        soln outer = new soln();
        Solution solution = outer.new Solution();

        TreeNode output = solution.sortedArrayToBST(inputList);

        boolean assertPass = isSameTree(output, expected);

        String result = assertPass ? "PASS" : "FAIL";
        String formattedResult = assertPass ? greenText(result) : redText(result);

        System.out.println(formattedResult + ": Input: " + truncateStr(Arrays.toString(inputList)));
        System.out.println("\n=== EXPECTED TREE ===");
        System.out.println(treeToString(expected));

        if (!assertPass) {
            System.out.println("\n=== ACTUAL TREE ===");
            System.out.println(treeToString(output));
        }

        System.out.println("==========================================");

        return assertPass;
    }

    public static void main(String[] args) {

        /* 1 – Empty input → empty tree (null) */
        assertSolution(new int[] {},
                /* expected */ null);

        /* 2 – Single element → single‑node tree */
        assertSolution(new int[] { 7 },
                createBinaryTree(new Integer[] { 7 }));

        /* 3 – Two elements (even length) */
        assertSolution(new int[] { 1, 3 },
                createBinaryTree(new Integer[] { 1, null, 3 }));

        /* 4 – Three elements (odd length, perfectly balanced) */
        assertSolution(new int[] { 1, 2, 3 },
                createBinaryTree(new Integer[] { 2, 1, 3 }));

        /* 5 – Four elements (even length, skew on final level) */
        assertSolution(new int[] { 1, 2, 3, 4 },
                createBinaryTree(new Integer[] { 2, 1, 3, null, null, null, 4 }));

        /* 6 – Five elements, mixed signs */
        assertSolution(new int[] { -10, -3, 0, 5, 9 },
                createBinaryTree(new Integer[] { 0, -10, 5, null, -3, null, 9 }));

        /* 7 – Edge values of 32‑bit range */
        assertSolution(new int[] { -2147483648, -1, 0, 1, 2147483647 },
                createBinaryTree(new Integer[] { 0, -2147483648, 1, null, -1, null, 2147483647 }));
    }

}
