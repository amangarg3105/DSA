package sorting;

/**
 * @author amgarg
 */
public class InsertionSort {


    public static void sort(int [] arr) {

        //start from second element
        for(int i = 1; i < arr.length; i++) {

            int temp = arr[i];
            int hole = i;

            while (hole > 0 && arr[hole - 1] > temp) {
                arr[hole] = arr[hole - 1];
                hole = hole - 1;
            }

            arr[hole] = temp;
        }
    }


    public static void sortRecursive(int [] arr, int n) {


        if(n <= 1) {
            return;
        }
       sortRecursive(arr, n - 1);

       int last = arr[n - 1];

       int hole = n - 2;
       while (hole >= 0 && arr[hole] > last) {
           arr[hole + 1] = arr[hole];
           hole--;
       }
       arr[hole + 1] = last;

    }

    public static void main(String[] args) {
        int [] arr = {7, 4, 1, 5, 8};

        sortRecursive(arr, arr.length);

        for(int element : arr) {
            System.out.print(element + "  ");
        }
    }
}
