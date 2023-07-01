package trees;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TraversalsOnTree {



    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> pre = new ArrayList<>();
        preOrderTraversalHelper(root, pre);
        return pre;

    }

    public List<Integer> preorderTraversalIterative(TreeNode root) {

        List<Integer> pre = new ArrayList<>();

        if(root == null) {
            return pre;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()) {

            TreeNode node = stack.pop();
            pre.add(node.val);

            if(node.right != null ) {
                stack.push(node.right);
            }

            if(node.left != null ) {
                stack.push(node.left);
            }
        }

        return pre;
    }

    private void preOrderTraversalHelper(TreeNode root, List<Integer> pre) {

        if(root == null) {
            return;
        }

        pre.add(root.val);
        preOrderTraversalHelper(root.left, pre);
        preOrderTraversalHelper(root.right, pre);
    }



}
