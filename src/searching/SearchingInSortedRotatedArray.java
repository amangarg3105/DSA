package searching;

/**
 * @author amgarg
 */
public class SearchingInSortedRotatedArray {

    /**
     * T.C - O(log n)
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {

        int low = 0, hi = nums.length - 1;

        int index = search(nums, low, hi, target);
        return index;

    }


    public int search(int[] nums, int low, int hi, int target) {

        if (low > hi) {
            return -1;
        }

        int mid = low + (hi - low) / 2;

        if (nums[mid] == target) {
            return mid;
        }

        //check if left part is sorted
        if(nums[low] <= nums[mid]) {
            if(target >= nums[low] && target <= nums[mid]) {
                int ansInLeftSortedArray = search(nums, low, mid - 1, target);
                return ansInLeftSortedArray;
            }
            int ansInRightSubArray = search(nums, mid + 1, hi, target);
            return ansInRightSubArray;
        }
        //we are coming here, it means right subarray is sorted
        else {
            if(target >= nums[mid] && target <= nums[hi]) {
                return search(nums, mid + 1, hi, target);
            } else {
                return search(nums, low, mid - 1, target);
            }
        }
    }
}
