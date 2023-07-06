package trees;

/**
 * @author amgarg
 */
public class DeleteLeafNodes {

    public TreeNode removeLeafNodes(TreeNode root, int target) {

        if(root == null) {
            return null;
        }

        root.left = removeLeafNodes(root.left, target); //root.left = null
        root.right = removeLeafNodes(root.right, target); //root.right = nonNull

        //check current node
        if(root.left == null && root.right == null && root.val == target) {
            return null;
        }

        return root;
    }

}
