package Leet0108_ConvertSortedArraytoBinarySearchTree;

import java.util.Arrays;

public class soln {

    class Solution {

        public TreeNode sortedArrayToBST(int[] nums) {

            if (nums.length == 0) {
                return null;
            }

            if (nums.length == 1) {
                return new TreeNode(nums[0]);
            }

            if (nums.length == 2) {
                TreeNode root = new TreeNode(nums[0]);
                if (nums[0] < nums[1]) {
                    root.right = new TreeNode(nums[1]);
                } else {
                    root.left = new TreeNode(nums[1]);
                }
                return root;
            }

            boolean isOdd = (nums.length & 1) == 1;

            TreeNode root = null;

            int midway = nums.length / 2;

            if (isOdd) {
                root = new TreeNode(nums[midway]);
                int[] newArrayLeft = Arrays.copyOf(nums, midway);
                int[] newArrayRight = Arrays.copyOfRange(nums, nums.length - midway, nums.length);
                root.left = sortedArrayToBST(newArrayLeft);
                root.right = sortedArrayToBST(newArrayRight);
            } else {


            }


            return root;
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

        return (
            isSameTree(p.left, q.left) &&
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
        assertSolution(new int[] { 1, 3 }, createBinaryTree(new Integer[] { 1, null, 3 }));
        assertSolution(new int[] { -10, -3, 0, 5, 9 }, createBinaryTree(new Integer[] { 0, -3, 9, -10, null, 5 }));
    }
}