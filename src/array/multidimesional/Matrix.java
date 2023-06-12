package array.multidimesional;


public class Matrix {


    public static void main(String[] args) {

        //it means a table having 4 rows & 5 cols
        int [][] matrix = new int[4][5];

        matrix[2][3] = 10;


        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                if(i == j) {
                    System.out.println(matrix[i][j]);
                }
            }
        }


        for(int i = 0; i < matrix.length; i++) {
            if(matrix[i].length >= i) {
                System.out.println(matrix[i][i]);
            }
        }
    }
}
