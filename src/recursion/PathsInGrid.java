package recursion;

/**
 * @author amgarg
 */
public class PathsInGrid {


    public static int totalWays(int [][] matrix, int x, int y) {


        if(x >= matrix.length) {
            return 0;
        }

        if(y >= matrix[0].length) {
            return 0;
        }

        if(x == matrix.length - 1 && y == matrix[0].length - 1) {
            return 1;
        }

        int rightWays = totalWays(matrix, x + 1, y);

        int downWays = totalWays(matrix, x, y + 1);

        return rightWays + downWays;
    }
}
