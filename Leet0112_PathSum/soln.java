import java.util.Arrays;

public class soln {

    class Solution {

        public boolean hasPathSum(TreeNode root, int targetSum) {

            if (root == null) {
                return false;
            }

            return hasPathSum(root, targetSum, root.val);
        }

        public boolean hasPathSum(TreeNode root, int targetSum, int runningTotal) {

            if (root.left == null && root.left == null) {
                if (root.val + runningTotal == targetSum) {
                    return true;
                } else {
                    return false;
                }
            }

            boolean leftPath = false;
            boolean rightPath = false;
            if (root.left != null) {
                leftPath = hasPathSum(root.left, targetSum, root.val + runningTotal);
            }
            if (root.right != null) {
                rightPath = hasPathSum(root.right, targetSum, root.val + runningTotal);
            }

            return leftPath || rightPath;
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
        soln outer = new soln();
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

        // Edge cases
        assertSolution(new Integer[] { 5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1 },
                /* expected */ 22, true);

        assertSolution(new Integer[] { 1, 2, 3 },
                /* expected */ 5, false);
    }
}
