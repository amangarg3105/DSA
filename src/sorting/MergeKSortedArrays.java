package sorting;

/**
 * @author amgarg
 */
public class MergeKSortedArrays {


    public static int [] merge2SortedArrays(int [] nums1, int [] nums2) {
        int [] result = new int[nums1.length + nums2.length];
        int k = 0, i = 0, j = 0;

        while(i < nums1.length && j < nums2.length) {
            if(nums1[i] <= nums2[j]) {
                result[k++] = nums1[i++];
            } else {
                result[k++] = nums2[j++];
            }
        }

        while(i < nums1.length) {
            result[k++] = nums1[i++];
        }

        while(j < nums2.length) {
            result[k++] = nums2[j++];
        }

        return result;
    }

    public static int [] mergeKSorted(int [][] arr) {

        if(arr.length <= 1) {
            return arr[0];
        }

        int[] result = merge2SortedArrays(arr[0], arr[1]);
        for(int i = 2; i < arr.length; i++) {
            result = merge2SortedArrays(result, arr[i]);
        }
        return result;
    }




    public static void main(String[] args) {
        int arr [][] = {
                {1, 8, 5, 22},
                {2, 9, 11, 15},
                {3, 6, 10},
                {5, 15, 18, 20}
        };


        int[] result = mergeKSorted(arr);

        for(int num : result) {
            System.out.print(num + "  ");
        }


    }
}
