package array;


public class MajorityElement {

    /**
     * T.C - O(n) where n is nums.length
     *
     * S.C - O(1)
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int candidate = getMajorityCandidate(nums); //T.C O(n)

        int majorityElementCount = 0;
        for (int i = 0; i < nums.length; i++) { //T.C O(n)
            if (nums[i] == candidate) {
                majorityElementCount++;
            }
        }

        if (majorityElementCount > nums.length / 2) {
            return candidate;
        }
        return 0;
    }

    /**
     * Helps in providing the candidate which can be majority element
     *
     * @param nums
     */
    private int getMajorityCandidate(int[] nums) {

        int majorityIndex = 0, count = 1;

        for(int i = 1; i < nums.length; i++) {
            if(nums[majorityIndex] == nums[i]) {
                count++;
            } else {
                count--;
            }

            if(count <= 0) {
                majorityIndex = i;
                //Resetting the count to 1
                count = 1;
            }
        }

        return nums[majorityIndex];
    }


    public static void main(String[] args) {

    }
}
