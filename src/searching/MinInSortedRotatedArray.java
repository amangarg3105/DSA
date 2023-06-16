package searching;


public class MinInSortedRotatedArray {


    public static int findMin(int[] nums) {

        int low = 0, hi = nums.length - 1;


        if(nums[low] <= nums[hi]) {
            return nums[low];
        }
        while (low <= hi) {
            //calculating mid
            int mid = low + (hi - low) / 2;

            //part1, if last element of part 1 is greater than first element of part 2
            if(nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }

            //part2, if first element of part 1 is smaller than last element of part 2
            if(nums[mid] < nums[mid - 1]) {
                return nums[mid];
            }

            //check for sorted array
            if(nums[low] <= nums[mid]) {
                low = mid + 1;
            } else if(nums[mid] <= nums[hi]) {
                hi = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int arr[] =  {11,13,15,17};

        System.out.println(findMin(arr));
    }
}
