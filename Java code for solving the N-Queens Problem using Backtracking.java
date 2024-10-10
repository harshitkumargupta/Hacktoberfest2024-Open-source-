public class NQueens {
    final int N;

    public NQueens(int N) {
        this.N = N;
    }

    /* Function to print the chessboard */
    void printSolution(int board[][]) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    /* Function to check if a queen can be placed on board[row][col] */
    boolean isSafe(int board[][], int row, int col) {
        // Check this row on the left side
        for (int i = 0; i < col; i++) {
            if (board[row][i] == 1) {
                return false;
            }
        }

        // Check upper diagonal on the left side
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        // Check lower diagonal on the left side
        for (int i = row, j = col; j >= 0 && i < N; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        return true;
    }

    /* A recursive function to solve the N-Queens problem */
    boolean solveNQUtil(int board[][], int col) {
        // Base case: If all queens are placed, return true
        if (col >= N) {
            return true;
        }

        // Try placing the queen in all rows one by one
        for (int i = 0; i < N; i++) {
            if (isSafe(board, i, col)) {
                // Place the queen
                board[i][col] = 1;

                // Recursively place queens in the next column
                if (solveNQUtil(board, col + 1)) {
                    return true;
                }

                // If placing queen in board[i][col] doesn't lead to a solution, remove the queen
                board[i][col] = 0; // Backtrack
            }
        }

        // If no queen can be placed in this column, return false
        return false;
    }

    /* Function to solve the N-Queens problem */
    boolean solveNQ() {
        int board[][] = new int[N][N];

        if (!solveNQUtil(board, 0)) {
            System.out.println("Solution does not exist");
            return false;
        }

        printSolution(board);
        return true;
    }

    public static void main(String[] args) {
        int N = 4; // You can change this to any number of queens
        NQueens queens = new NQueens(N);
        queens.solveNQ();
    }
}
