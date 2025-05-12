package Leet0144_BinaryTreePreorderTraversal;

/**
 * Definition for a binary tree node.
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    /**
     * Default constructor
     */
    TreeNode() {}

    /**
     * Constructor with value
     * @param val the value of this node
     */
    TreeNode(int val) {
        this.val = val;
    }

    /**
     * Constructor with value and children
     * @param val the value of this node
     * @param left the left child
     * @param right the right child
     */
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}