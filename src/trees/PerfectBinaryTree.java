package trees;


public class PerfectBinaryTree {

    public static boolean isPerfectBinaryTree(TreeNode root) {

        int leftMostDepthLevel = findDepthLevel(root);

        return isPerfectBinaryTreeHelper(root, 0, leftMostDepthLevel);
    }

    private static boolean isPerfectBinaryTreeHelper(TreeNode root, int currentLevel,
                                                     int leftMostDepthLevel) {

        if(root == null) {
            return true;
        }


        if(root.left == null && root.right == null) {
        //it's a leaf node
           if(currentLevel + 1 == leftMostDepthLevel) {
               return true;
           }
           return false;
        }

        if(root.left == null || root.right == null) {
            return false;
        }

        boolean isLeftSubTreePerfectTree = isPerfectBinaryTreeHelper(root.left, currentLevel + 1, leftMostDepthLevel);
        boolean isRightSubTreePerfectTree = isPerfectBinaryTreeHelper(root.right, currentLevel + 1, leftMostDepthLevel);

        return isLeftSubTreePerfectTree && isRightSubTreePerfectTree;
    }

    private static int findDepthLevel(TreeNode root) {
        int depth = 0;
        while(root != null) {
            depth++;
            root = root.left;
        }
        return depth;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(6);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(10);
        root.left.right = new TreeNode(11);



        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(16);


        System.out.println(isPerfectBinaryTree(root));
    }
}
