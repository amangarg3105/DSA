package trees.binarysearchtree;


import trees.TreeNode;

public class DeleteInBST {

    public TreeNode deleteNode(TreeNode root, int key) {


        if(root == null)
            return null;


        if(root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if(root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            //2C
            if(root.left != null && root.right != null) {
                int leftMax = max(root.left);
                root.val = leftMax;
                root.left = deleteNode(root.left, leftMax);
                //1C
            } else if(root.right != null) {
                return root.right;
            } else if(root.left != null) {
                return root.left;
            }
            //OC
            return null;
        }
        return root;
    }

    private int max(TreeNode node) {
        while (node.right != null) {
            node = node.right;
        }
        return node.val;
    }
}
