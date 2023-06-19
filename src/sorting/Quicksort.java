package sorting;

/**
 * @author amgarg
 */
public class Quicksort {


    public static void sort(int [] arr, int start, int end) {


        if(start >= end) {
            return;
        }
        int pivotIndex = getPivotIndex(arr, start, end); //O(n)
        sort(arr, start, pivotIndex  - 1); //if pivot is in middle then T(n/2)
        sort(arr, pivotIndex + 1, end); //T(n/2)

    }

    public static void swap(int [] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static int getPivotIndex(int[] arr, int start, int end) {

        int pivot = arr[end];

        int pIndex = start;

        for(int i = start; i < end; i++) {
            if(arr[i] <= pivot) {
                swap(arr, i, pIndex);
                pIndex++;
            }
        }

        swap(arr, end, pIndex);

        return pIndex;
    }

    public static void main(String[] args) {
        int [] arr = {2, 5, 6, 1, 3, 8, 15, 4};

        sort(arr, 0, arr.length - 1);

        for(int num : arr) {
            System.out.print(num + "  ");
        }
    }
}
