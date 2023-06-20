package searching;

/**
 * @author amgarg
 */
public class KthMinimumElementInMatrix {


    public static int kthSmallest(int[][] matrix, int k) {

       int m = matrix[0].length;
       int n = matrix.length;

       int low = matrix[0][0];
       int high = matrix[n - 1][m - 1];

       while(low < high) {
           int mid =  low + (high -  low) / 2;
           int countOfLesserElements = getLesserElement(matrix, mid, n, m);

           if(countOfLesserElements >= k) {
               high = mid;
           } else {
               low = mid + 1;
           }
       }

       return low;
    }

    /**
     * Returns the count of elements which are smaller than mid in matrix
     * @param matrix
     * @param target
     * @return
     */
    private static int getLesserElement(int[][] matrix, int target, int rows, int cols) {

        int row = rows - 1;
        int col = 0;

        int count = 0;

        while (row >= 0 && col < cols) {

            if(matrix[row][col] <= target) {
                col++;
                count =  count + (row + 1);
            } else  {
                row--;
            }
        }
        return count;
    }

    public static void main(String[] args) {
      int [][] arr = {{1,1, 1},{10,11,13},{12,13,15}};

        System.out.println(kthSmallest(arr, 2));
    }

}
