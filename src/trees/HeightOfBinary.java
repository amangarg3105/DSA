package trees;

/**
 * @author amgarg
 */
public class HeightOfBinary {

    public int maxDepth(TreeNode root) {


        if(root == null) {
            return 0;
        }
        int leftMaxDepth = maxDepth(root.left);

        int rightMaxDepth = maxDepth(root.right);

        int totalDepth = Math.max(leftMaxDepth, rightMaxDepth) + 1;

        return totalDepth;
    }
}
