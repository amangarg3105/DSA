package array.multidimesional;


public class SetMatrixZeros {


    /**
     * T.C - O(mn * (m+n))
     * S.C - O(mn)
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        int [][] copyMatrix = new int[m][n];

        //((mn)
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                copyMatrix[i][j] = matrix[i][j];
            }
        }

        //O(mn * (m+n))
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == 0) {

                    //O(n+n)
                    for(int k = 0; k < m; k++) {
                        copyMatrix[k][j] = 0;
                    }

                    for(int k = 0; k < n; k++) {
                        copyMatrix[i][k] = 0;
                    }
                }
            }
        }


        //O(nn)
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                matrix[i][j] = copyMatrix[i][j];
            }
        }
    }


    /**
     * T.C - O(mn)
     * S.C - O(1)
     * @param matrix
     */
    public void setZeroesOptimized(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        boolean isZeroIn0Row = false, isZeroIn0Col = false;

        for(int i = 0;  i < n; i++) {
            if(matrix[0][i]  == 0) {
                isZeroIn0Row =true;
                break;
            }
        }

        for(int i = 0;  i < m; i++) {
            if(matrix[i][0]  == 0) {
                isZeroIn0Col =true;
                break;
            }
        }


        for(int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if(matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for(int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }


        if(isZeroIn0Col) {
            for(int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }

        if(isZeroIn0Row) {
            for(int i = 0; i < n; i++) {
                matrix[0][i] = 0;
            }
        }

    }
}
