package searching;

public class RecursiveBinarySearch {


    /**
     * T.C - O(log)
     * @param arr
     * @param left
     * @param right
     * @param key
     * @return
     */
    public static boolean search(int[] arr, int left, int right, int key) {


        if(left > right) {
            return false;
        }

        int mid = left + (right - left) / 2;


        if(key == arr[mid]) {
            System.out.println("We found the element at index "  + mid);
            return true;
        }


        if(key > arr[mid]) {
            boolean searchResultInRightPart = search(arr, mid + 1, right, key);
            return searchResultInRightPart;
        } else {
            boolean searchResultInLeftPart = search(arr, left, mid - 1, key);
            return searchResultInLeftPart;
        }

    }


    public static void main(String[] args) {
        int [] arr = {2, 5, 8, 11, 13, 16};

        System.out.println(search(arr, 0, arr.length - 1,  52));
    }

}
