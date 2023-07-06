package trees.binarysearchtree;

import trees.TreeNode;

/**
 * @author amgarg
 */
public class InsertInBst {

    public TreeNode insertIntoBST(TreeNode root, int val) {

        if (root == null) {
            return new TreeNode(val);
        }

        helper(root, val);
        return root;
    }

    private void helper(TreeNode root, int val) {

        if (root.val > val && root.left == null) {
            root.left = new TreeNode(val);
        } else if (root.val < val && root.right == null) {
            root.right = new TreeNode(val);
        } else if (root.val < val) {
            helper(root.right, val);
        } else {
            helper(root.left, val);
        }
    }
}
