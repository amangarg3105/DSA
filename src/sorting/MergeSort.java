package sorting;


public class MergeSort {


    /**
     * T.C - O(n log n)
     * S.C - O(n)
     * @param nums
     * @param start
     * @param end
     */
    public static void mergeSort(int [] nums, int start, int end) {

        if(start >= end) {
            return;
        }

        int mid = start + (end - start) / 2;

        mergeSort(nums, start, mid); //2,5
        mergeSort(nums, mid + 1, end); //1,6

        merge(nums, start, mid, end);
    }

    private static void merge(int[] nums, int start, int mid, int end) {

        int arraySize1 = mid - start + 1;
        int arraySize2 = end - mid;

        int array1[] = new int[arraySize1];
        int array2[] = new int[arraySize2];

        for(int i = 0; i < arraySize1; i++) {
            array1[i] = nums[start + i];
        }

        for(int i = 0; i < arraySize2; i++) {
            array2[i] = nums[mid + i + 1];
        }

        //merging two arrays into original array

        int i = 0, j = 0;

        int k = start;

        while(i < arraySize1 && j < arraySize2) {
            if(array1[i] <= array2[j])  {
                nums[k] = array1[i];
                i++;
            } else {
                nums[k] = array2[j];
                j++;
            }
            k++;
        }


        //copy the remaining elements into original array
        while (i < arraySize1) {
            nums[k] = array1[i];
            i++;
            k++;
        }

        while (j < arraySize2) {
            nums[k] = array2[j];
            j++;
            k++;
        }
    }


    public static void main(String[] args) {
        int [] arr = {2, 5, 6, 1, 3, 8, 15, 4};
        mergeSort(arr, 0, arr.length - 1);

        for(int num : arr) {
            System.out.print(num + "  ");
        }
    }
}
