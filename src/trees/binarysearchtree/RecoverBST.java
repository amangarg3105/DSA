package trees.binarysearchtree;


import trees.TreeNode;

public class RecoverBST {


    TreeNode prev = null;
    TreeNode firstIncorrect = null;

    TreeNode secondIncorrectNode = null;
    public void recoverTree(TreeNode root) {


        inorderTraversal(root);
        //swap first and second
        int temp = firstIncorrect.val;
        firstIncorrect.val = secondIncorrectNode.val;
        secondIncorrectNode.val = temp;
    }

    private void inorderTraversal(TreeNode root) {

        if(root == null) {
            return;
        }

        inorderTraversal(root.left);
        if(prev != null && prev.val > root.val) {
            if(firstIncorrect == null) {
                firstIncorrect = prev;
            }
            secondIncorrectNode = root;
        }

        prev = root;
        inorderTraversal(root.right);
    }
}
