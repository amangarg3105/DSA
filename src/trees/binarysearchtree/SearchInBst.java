package trees.binarysearchtree;


import trees.TreeNode;

public class SearchInBst {

    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null) {
            return null;
        }

        if(root.val == val) {
            return root;
        }

        if(root.val < val) {
            TreeNode searchInRight = searchBST(root.right, val);
            return searchInRight;
        }

        TreeNode searchInLeft = searchBST(root.left, val);
        return searchInLeft;

    }
}
