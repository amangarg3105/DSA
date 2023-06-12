package array;

import java.util.ArrayList;

public class UpdateIndex {

    /**
     * TC -> in best case O(n)
     *       in worst case O(n)
     *
     * SC -> O(1)
     * @param args
     */
    public static void main(String[] args) {
        int [] a = new int[5];


        ArrayList<Integer> list = new ArrayList<>();



        int index = 3;

        int n = a.length;
        for(int i = 0; i < n; i++) {
            if(index == i) {
                a[i] = a[i] + 2;
            }
            System.out.println(a[i]);
        }

        for(int i = 0; i < n; i++) {
            System.out.print(a[i] + "  ");
        }
    }
}
