package trees;


import java.util.ArrayList;
import java.util.List;

public class FindLeaves {

    public List<List<Integer>> findLeaves(TreeNode root) {


        List<List<Integer>> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    private int helper(TreeNode root, List<List<Integer>> res) {

        if(root == null) {
            return -1;
        }

        int leftMaxDepth = helper(root.left, res);
        int rightMaxDepth = helper(root.right, res);

        int maxDepth = 1 + Math.max(leftMaxDepth, rightMaxDepth);

        if(res.size() == maxDepth) {
            res.add(new ArrayList<>());
        }

        res.get(maxDepth).add(root.val);
        return maxDepth;
    }
}
