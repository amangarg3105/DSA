package backtracking;


import trees.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        helper(root, targetSum, tempList, result);
        return result;
    }

    private void helper(TreeNode root, int targetSum, List<Integer> tempList, List<List<Integer>> result) {

        if (root == null) {
            return;
        }

        tempList.add(root.val);

        if (root.left == null && root.right == null && root.val == targetSum) {
            result.add(new ArrayList<>(tempList));
        } else {
            helper(root.left, targetSum - root.val, tempList, result);
            helper(root.right, targetSum - root.val, tempList, result);
        }
        //backtracking
        tempList.remove(tempList.size() - 1);
    }
}
