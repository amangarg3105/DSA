package trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author amgarg
 */
public class CompleteBinaryTree {


    int maxIndex = 0;

    public boolean isCompleteTreeIteratively(TreeNode root) {

       boolean isEndOfRoad = false;
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();
            if(currentNode == null) {
                isEndOfRoad = true;
            } else {
                if(isEndOfRoad) {
                    return false;
                }
                queue.add(currentNode.left);
                queue.add(currentNode.right);
            }
        }

        return true;
    }


    public boolean isCompleteTree(TreeNode root) {

        //count the nodes
        int numberOfNodes = countNodes(root);
        boolean isComplete = isCompleteTreeHelper(root, 0, numberOfNodes);
        return isComplete;
    }

    private boolean isCompleteTreeHelper(TreeNode root, int index, int numberOfNodes) {

        if(root == null) {
            return true;
        }

        if(index >= numberOfNodes) {
            return false;
        }

        boolean isLeftCompleteBinaryTree = isCompleteTreeHelper(root.left, 2 * index + 1, numberOfNodes);
        boolean isRightCompleteBinaryTree = isCompleteTreeHelper(root.right, 2 * index + 2, numberOfNodes);

        return isLeftCompleteBinaryTree && isRightCompleteBinaryTree;


    }

    private int countNodes(TreeNode root) {

        if(root == null) {
            return 0;
        }

        int numberOfNodesInLeftSubTree = countNodes(root.left);
        int numberOfNodesInRightSubTree = countNodes(root.right);

        return 1 + numberOfNodesInLeftSubTree + numberOfNodesInRightSubTree;
    }
}
