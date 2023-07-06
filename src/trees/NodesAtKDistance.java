package trees;


import java.util.ArrayList;
import java.util.List;

public class NodesAtKDistance {


    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        List<TreeNode> pathList = new ArrayList<>();
        List<Integer> resultList = new ArrayList<>();

        findPath(root, target, pathList);

        for(int i = 0; i < pathList.size(); i++) {
            addNodesKlevelsDown(pathList.get(i), k - i, resultList, i == 0 ? null : pathList.get(i - 1));
        }

        return resultList;
    }

    public boolean findPath(TreeNode root, TreeNode targetNode, List<TreeNode> pathList) {

        if (root == null) {
            return false;
        }

        if (root == targetNode) {
            pathList.add(root);
            return true;
        }

        boolean isLeftFound = findPath(root.left, targetNode, pathList);

        if (isLeftFound) {
            pathList.add(root);
            return true;
        }

        boolean isRightFound = findPath(root.right, targetNode, pathList);

        if (isRightFound) {
            pathList.add(root);
            return true;
        }

        return false;
    }


    private void addNodesKlevelsDown(TreeNode node, int deepLevel, List<Integer> nodesList, TreeNode blocker) {

        if (node == null || deepLevel < 0 || node == blocker) {
            return;
        }

        if (deepLevel == 0) {
            nodesList.add(node.val);
            return;
        }

        addNodesKlevelsDown(node.left, deepLevel - 1, nodesList, blocker);
        addNodesKlevelsDown(node.right, deepLevel - 1, nodesList, blocker);
    }
}
