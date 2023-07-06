package trees;


public class PreorderInorderTree {


    public TreeNode buildTree(int[] preorder, int[] inorder) {

        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preOrder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {


        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preOrder[preStart]);

        int inorderRootIndex = inStart;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                inorderRootIndex = i;
                break;
            }
        }

        int leftTreeLength = inorderRootIndex - inStart;

        root.left = buildTree(preOrder, preStart + 1, preStart + leftTreeLength, inorder,
                inStart, inorderRootIndex - 1);

        root.right = buildTree(preOrder, preStart + leftTreeLength + 1, preEnd, inorder,
                inorderRootIndex + 1, inEnd);

        return root;
    }
}
