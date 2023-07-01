package trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Pair {
    TreeNode treeNode;
    int visitingCount;

    public Pair(TreeNode treeNode) {
        this.treeNode = treeNode;
    }
}
public class ConstructTree {


    public static void main(String[] args) {

        TreeNode root = new TreeNode(5);

        root.left = new TreeNode(7);
        root.left.left = new TreeNode(10);
        root.left.right = new TreeNode(1);
        root.right = new TreeNode(15);
        root.right.right = new TreeNode(20);


    }
}
