package backtracking;


public class NQueens {


    public static boolean placeQueens(int[][] board, int row) {


        if (row == board.length) {
            //print board
            printBoard(board);

            System.out.println();
            System.out.println();
            return false;
        }


        for (int currentIndex = 0; currentIndex < board.length; currentIndex++) {

            if (isSafeToPlaceQueen(board, row, currentIndex)) {

                //placing the queen
                board[row][currentIndex] = 1;

                boolean isQueenPlaced = placeQueens(board, row + 1);

                if (isQueenPlaced) {
                    return true;
                }

                //backtrack
                board[row][currentIndex] = 0;
            }
        }

        return false;
    }

    private static void printBoard(int[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board.length; col++) {
                System.out.print(board[row][col] + "  ");
            }
            System.out.println();
        }
    }

    private static boolean isSafeToPlaceQueen(int[][] board,
                                              int currentRow,
                                              int currentIndex) {


        //vertical traversal in above direction
        int row = currentRow;
        while (row >= 0) {
            if (board[row][currentIndex] == 1) {
                return false;
            }
            row--;
        }

        int x = currentRow;
        int y = currentIndex;

        while (x >= 0 && y >= 0) {
            if (board[x][y] == 1) {
                return false;
            }
            x--;
            y--;
        }

        x = currentRow;
        y = currentIndex;

        while (x >= 0 && y < board.length) {
            if (board[x][y] == 1) {
                return false;
            }
            x--;
            y++;
        }

        return true;
    }

    public static void main(String[] args) {
        int n = 4;
        int [][] board = new int[4][4];

        placeQueens(board, 0);
    }

}
