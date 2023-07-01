package trees;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {


    public List<List<Integer>> levelOrder(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();

        List<List<Integer>> result = new ArrayList<>();

        if(root == null) {
            return result;
        }

        queue.add(root);

        while(!queue.isEmpty()) {
            //number of nodes at current level
            int size = queue.size();

            List<Integer> nodes = new ArrayList<>();
            for(int i = 0; i < size; i++) {
                if(queue.peek().left != null) {
                    queue.add(queue.peek().left);
                }

                if(queue.peek().right != null) {
                    queue.add(queue.peek().right);
                }

                int nodeVal = queue.poll().val;
                nodes.add(nodeVal);
            }

            result.add(nodes);
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
