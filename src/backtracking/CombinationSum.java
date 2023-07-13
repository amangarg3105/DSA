package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {


    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        List<Integer> tempList = new ArrayList<>();
        helper(candidates, target, 0, tempList, result);
        return result;
    }

    private void helper(int[] candidates, int target, int start,
                        List<Integer> tempList, List<List<Integer>> result) {

        if (target < 0) {
            return;
        }
        if(target == 0) {
            List<Integer> newList = new ArrayList<>();
            newList.addAll(tempList);
            result.add(newList);
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            tempList.add(candidates[i]);
            helper(candidates, target - candidates[i], i, tempList, result);
            //backtrack
            tempList.remove(tempList.size() - 1);
        }
    }

}
