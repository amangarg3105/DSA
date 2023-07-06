package trees;


import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class ZigZagTraversal {


    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> resultantList = new ArrayList<>();

        if (root == null) {
            return resultantList;
        }

        Deque<TreeNode> deque = new LinkedList<>();

        boolean isLeftToRight = true;
        deque.addLast(root);

        List<Integer> currentLevelNodeList = null;

        while (!deque.isEmpty()) {

            currentLevelNodeList = new ArrayList<>();

            //this basically tells number of nodes on current level
            int dqSize = deque.size();

            while (dqSize > 0) {
                if (isLeftToRight) {
                    TreeNode currentNode = deque.removeFirst();
                    currentLevelNodeList.add(currentNode.val);

                    if (currentNode.left != null) {
                        deque.addLast(currentNode.left);
                    }

                    if (currentNode.right != null) {
                        deque.addLast(currentNode.right);
                    }
                } else {
                    TreeNode currentNode = deque.removeLast();
                    currentLevelNodeList.add(currentNode.val);
                    if (currentNode.right != null) {
                        deque.addFirst(currentNode.right);
                    }

                    if (currentNode.left != null) {
                        deque.addFirst(currentNode.left);
                    }
                }
                dqSize--;
            }

            isLeftToRight = !isLeftToRight;
            resultantList.add(currentLevelNodeList);
        }

        return resultantList;
    }
}
