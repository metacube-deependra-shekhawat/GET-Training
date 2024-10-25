package main;

public class NQueens {

    private int n;
    private int[][] board;

    /**
     * Constructor method which will take n (integer) as input and set size of board
     * @param n integer the size of board
     */
    public NQueens(int n) {
        this.n = n;
        this.board = new int[n][n];
    }

    /**
     * This is a starter method for the NQueens problem code
     * @return boolean if it is possible to place n queens on the board
     */
    public boolean solveNQueens() {
        if (placeQueens(0)) {
            printBoard();
            return true;
        } else {
            System.out.println("Not Possible");
            return false;
        }
    }

    /**
     * This is a recursive method which will place queens at a certain position and backtrack to try different possibilites
     * @param row number of row in which the queen is to be placed
     * @return return a boolean if it is possible to place queen at a certain position
     */
    private boolean placeQueens(int row) {
        if (row == n) return true;
        for (int col = 0; col < n; col++) {
            if (isSafe(row, col)) {
                board[row][col] = 1;
                if (placeQueens(row + 1)) return true;
                board[row][col] = 0;
            }
        }
        return false;
    }

    /**
     * This method will check if it is possible to establish queen at a position without facing any other queen
     * @param row index of row where queen is to be place
     * @param col index of column where queen is to be place
     * @return boolean if possible to place
     */
    private boolean isSafe(int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 1) return false;
        }
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) return false;
        }
        for (int i = row, j = col; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 1) return false;
        }
        return true;
    }

    /**
     * This method will print the board after successful placement of n queens
     */
    private void printBoard() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j] == 1 ? "Q " : ". ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        NQueens nQueens = new NQueens(6);
        nQueens.solveNQueens();
    }
}