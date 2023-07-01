package trees;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IterativePostInPreOnePass {


    public static void printTraversals(TreeNode root) {

        List<Integer> pre = new ArrayList<>();

        List<Integer> post = new ArrayList<>();

        List<Integer> in = new ArrayList<>();

        if(root == null) {
            return;
        }

        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root));

        while(!stack.isEmpty()) {
            Pair currenTreeNodePair = stack.peek();
            currenTreeNodePair.visitingCount++;

            if(currenTreeNodePair.visitingCount == 1) {
                pre.add(currenTreeNodePair.treeNode.val);

                if(currenTreeNodePair.treeNode.left != null) {
                    stack.push(new Pair(currenTreeNodePair.treeNode.left));
                }
            } else if(currenTreeNodePair.visitingCount == 2) {
                in.add(currenTreeNodePair.treeNode.val);

                if(currenTreeNodePair.treeNode.right != null) {
                    stack.push(new Pair(currenTreeNodePair.treeNode.right));
                }
            } else {
                post.add(currenTreeNodePair.treeNode.val);
                stack.pop();
            }
        }

        System.out.println();
        System.out.println("Printing preorder traversal");

        for(int val : pre) {
            System.out.print(val + "  ");
        }

        System.out.println();
        System.out.println("Printing postorder traversal");

        for(int val : post) {
            System.out.print(val + "  ");
        }

        System.out.println();
        System.out.println("Printing inorder traversal");

        for(int val : in) {
            System.out.print(val + "  ");
        }
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(15);
        root.left = new TreeNode(20);
        root.right = new TreeNode(37);
        root.left.left = new TreeNode(84);
        root.left.right = new TreeNode(79);

        root.right.left = new TreeNode(60);
        root.right.left.left = new TreeNode(34);
        root.right.right = new TreeNode(71);

        printTraversals(root);



    }
}
