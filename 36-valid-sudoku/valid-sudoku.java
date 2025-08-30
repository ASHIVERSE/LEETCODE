public class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            boolean[] row = new boolean[9];
            boolean[] col = new boolean[9];
            boolean[] box = new boolean[9];

            for (int j = 0; j < 9; j++) {
                // Row check
                if (board[i][j] != '.') {
                    int num = board[i][j] - '1';
                    if (row[num]) return false;
                    row[num] = true;
                }

                // Column check
                if (board[j][i] != '.') {
                    int num = board[j][i] - '1';
                    if (col[num]) return false;
                    col[num] = true;
                }

                // Box check
                int boxRow = 3 * (i / 3);
                int boxCol = 3 * (i % 3);
                int r = boxRow + j / 3;
                int c = boxCol + j % 3;

                if (board[r][c] != '.') {
                    int num = board[r][c] - '1';
                    if (box[num]) return false;
                    box[num] = true;
                }
            }
        }

        return true;
    }

    
}
