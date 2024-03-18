class Solution {
    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        int[][] parent = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O' && checkValid(i, j, rows, cols)) {
                    if (parent[i][j] == 1) {
                        continue;
                    }
                    traverse(parent, board, i, j);
                }

            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (parent[i][j] == 0) {
                    board[i][j] = 'X';
                }
            }
        }

    }

    private void traverse(int[][] parent, char[][] board, int x, int y) {
        if (checkRange(x, y, parent.length, parent[0].length) || parent[x][y] == 1) {
            return;
        }
        if (board[x][y] == 'O') {
            parent[x][y] = 1;
            traverse(parent, board, x + 1, y);
            traverse(parent, board, x - 1, y);
            traverse(parent, board, x, y + 1);
            traverse(parent, board, x, y - 1);
        }
    }

    private boolean checkValid(int x, int y, int rows, int cols) {
        return (x >= rows - 1 || y >= cols - 1 || x <= 0 || y <= 0);
    }

    private boolean checkRange(int x, int y, int rows, int cols) {
        return (x > rows - 1 || y > cols - 1 || x < 0 || y < 0);
    }

}