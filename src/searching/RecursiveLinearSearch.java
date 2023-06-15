package searching;


public class RecursiveLinearSearch {


    public static boolean search(int [] arr, int index, int key) {

        if(index >= arr.length) {
            return false;
        }

        if(arr[index] == key) {
            System.out.println("Found the element at Index " + index);
            return true;
        }

        boolean restOfTheArrayAns = search(arr, index + 1, key);

        return restOfTheArrayAns;
    }


    public static void main(String[] args) {
        int [] arr = {5, 15, 10, 20, 6, 31};

        System.out.println(search(arr, 0, 50));
    }
}
