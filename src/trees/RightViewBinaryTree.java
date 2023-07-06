package trees;


import java.util.ArrayList;
import java.util.List;

public class RightViewBinaryTree {

    public List<Integer> rightSideView(TreeNode root) {

        ArrayList<Integer> result = new ArrayList<>();

        rightSideViewHelper(root, 0, result);

        return result;
    }

    private void rightSideViewHelper(TreeNode root, int level,
                                     ArrayList<Integer> result) {

        if(root == null) {
            return;
        }

        if(result.size() == level) {
            result.add(root.val);
        }

        rightSideViewHelper(root.right, level + 1, result);
        rightSideViewHelper(root.left, level + 1, result);
    }
}
