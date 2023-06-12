package array.multidimesional;


public class RotateImage {

    /**
     * T.C - O(n^2) where n is number of elements in matrix
     * @param matrix
     */
    public void rotate(int[][] matrix) {

        //Transpose the matrix
        //Reverse the cols
        int n = matrix.length;
        transposeTheMatrix(matrix);

        for(int i = 0; i < matrix.length; i++) {
            int left = 0, right = n - 1;
            while(left < right) {

                //swapping
                int temp  = 0;
                temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;

                left++;
                right--;
            }
        }
    }



    private void transposeTheMatrix(int[][] matrix) {

        for(int i = 0; i < matrix.length; i++) {
            for(int j = i; j <  matrix[i].length; j++) {
                int temp  = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
