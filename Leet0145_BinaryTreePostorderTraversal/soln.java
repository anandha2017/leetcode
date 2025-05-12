package Leet0145_BinaryTreePostorderTraversal;

import java.util.ArrayList;
import java.util.List;

public class soln {

    class Solution {

        public List<Integer> postorderTraversal(TreeNode root) {

            List<Integer> result = new ArrayList<>();

            helper(root, result);

            return result;

        }

        private void helper(TreeNode root, List<Integer> result) {

            if (root == null) {
                return;
            }

            helper(root.left, result);
            helper(root.right, result);
            result.add(root.val);

        }
    }
}
