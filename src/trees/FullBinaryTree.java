package trees;


public class FullBinaryTree {

    public static boolean isFull(TreeNode root) {

        if(root == null) {
            return true;
        }

        if(root.left == null && root.right == null) {
            return true;
        }

        boolean isLeftFullBinaryTree = false;
        boolean isRightFullBinaryTree = false;
        if(root.left != null) {
            isLeftFullBinaryTree = isFull(root.left);
        }

        if(root.right != null) {
            isRightFullBinaryTree = isFull(root.right);
        }

        boolean isFullBinaryTree = isLeftFullBinaryTree && isRightFullBinaryTree;

        return isFullBinaryTree;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(6);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(10);
        root.left.right = new TreeNode(11);
        root.left.left.left = new TreeNode(17);
        root.left.left.right = new TreeNode(20);

        root.left.right.left = new TreeNode(18);
        root.left.right.right = new TreeNode(19);


        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(16);


        System.out.println(isFull(root));

    }
}
