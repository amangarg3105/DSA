package recursion;

/**
 * @author amgarg
 */
public class MaxElement {


    public static int maxElement(int [] arr, int index) {

        if(index == arr.length - 1) {
            return arr[index];
        }

        int max1 = arr[index];

        int maximumInSmallerArray = maxElement(arr, index + 1);

        int mainAns = Math.max(maximumInSmallerArray, max1);

        return mainAns;
    }



    public static void main(String[] args) {

        int [] arr = {5, 8, 1,7 , 9, 11, 2, 6};
        int max = maxElement(arr, 0);
        System.out.println(max);
    }
}
