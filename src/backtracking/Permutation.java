package backtracking;


import java.util.ArrayList;
import java.util.List;

public class Permutation {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        helper(nums, tempList, result);
        return result;
    }

    private void helper(int[] nums, List<Integer> tempList, List<List<Integer>> result) {

        if (tempList.size() == nums.length) {
            List<Integer> newList = new ArrayList<>();
            newList.addAll(tempList);
            result.add(newList);
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            if (tempList.contains(nums[i])) {
                continue;
            }
            tempList.add(nums[i]);
            helper(nums, tempList, result);
            //backtrack
            tempList.remove(tempList.size() - 1);
        }
    }

}
