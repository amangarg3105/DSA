package array;


public class TrappingRainWater {

    /**
     * T.C - O(n^2)
     * S.C - O(1)
     * @param height
     * @return
     */
    public int trap(int[] height) {


        int totalWaterTrapped = 0;
        int n = height.length;

        //check every building
        for(int currentBuildingIndex = 1; currentBuildingIndex < n; currentBuildingIndex++) {

            int currentBuildingHeight = height[currentBuildingIndex];
            //get highest in left direction
            int leftHighest = height[currentBuildingIndex];

            for(int left = 0; left < currentBuildingIndex; left++) {
                if(leftHighest < height[left]) {
                    leftHighest = height[left];
                }
            }


            //get highest in right direction
            int rightHighest = height[currentBuildingIndex];

            for(int right = currentBuildingIndex + 1 ; right < n; right++) {
                if(rightHighest < height[right]) {
                    rightHighest = height[right];
                }
            }


            int currentWaterTrapped = Math.min(leftHighest, rightHighest) - currentBuildingHeight;
            totalWaterTrapped += currentWaterTrapped;

        }
        return totalWaterTrapped;
    }


    public int trapOptimized(int[] height) {


        int totalWaterTrapped = 0;
        int n = height.length;

        int left [] = new int[n];
        int right [] = new int[n];

        left[0] = height[0];
        //construct left array
        for(int i = 1; i < n; i++) {
            left[i] = Math.max(left[i - 1], height[i]);
        }

        right[n -1] = height[n -1];
        //construct right array
        for(int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], height[i]);
        }

        //check every building
        for(int currentBuildingIndex = 0; currentBuildingIndex < n; currentBuildingIndex++) {
            int currentBuildingHeight = height[currentBuildingIndex];
            int currentWaterTrapped = Math.min(left[currentBuildingIndex], right[currentBuildingIndex]) - currentBuildingHeight;
            totalWaterTrapped += currentWaterTrapped;
        }

        return totalWaterTrapped;
    }

}
