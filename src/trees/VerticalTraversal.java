package trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * @author amgarg
 */
public class VerticalTraversal {


    Map<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map;
    public List<List<Integer>> verticalTraversal(TreeNode root) {

        if(root == null) {
            return null;
        }

        map = new TreeMap<>();
        dfsHelper(root, 0, 0);
        List<List<Integer>> result = new ArrayList<>();


        for(int key : map.keySet()) {
            List<Integer> list = new ArrayList<>();
            TreeMap<Integer, PriorityQueue<Integer>> treeMap = map.get(key);
            for(int treeMapKey : treeMap.keySet()) {
                PriorityQueue<Integer> pq = treeMap.get(treeMapKey);
                while(!pq.isEmpty()) {
                    list.add(pq.poll());
                }
            }
            result.add(list);
        }
        return result;

    }

    private void dfsHelper(TreeNode root, int x, int y) {
        
        if(root == null) {
            return;
        }
        
        if(!map.containsKey(y)) {
            map.put(y, new TreeMap<>());
        }

        TreeMap<Integer, PriorityQueue<Integer>> treeMap = map.get(y);
        if(!treeMap.containsKey(x)) {
            treeMap.put(x, new PriorityQueue<>());
        }

        PriorityQueue<Integer> pq = treeMap.get(x);
        pq.add(root.val);

        dfsHelper(root.left, x + 1, y - 1);
        dfsHelper(root.right, x + 1, y + 1);
    }
}
