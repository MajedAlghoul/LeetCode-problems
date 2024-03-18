class Solution {
    public void solveSudoku(char[][] board) {
        Stack<int[]> stack1 = new Stack<>();
        Queue<int[]> queue = new LinkedList<>();
        Stack<int[]> stack2 = new Stack<>();
        int[] temp = new int[2];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    int[] x=new int[2];
                    x[0] = i;
                    x[1] = j;
                    queue.add (x);
                }
            }
        }
        while (!queue.isEmpty() || !stack2.isEmpty()){
            if(stack2.isEmpty()){
                temp = queue.poll();
            }else{
                temp = stack2.pop();
            }
            if (temp != null) {
                int value = pickerChecker(temp, board);
                if (value != 0) {
                    board[temp[0]][temp[1]] = (char) (value+'0');
                    stack1.push(temp);
                } else {
                    board[temp[0]][temp[1]] = '.';
                    stack2.push(temp);
                    if(!stack1.isEmpty())
                        stack2.push(stack1.pop());
                }
            }else{
            }
        }
    }

    public int pickerChecker(int[] square, char[][] board) {
        int flag;
        int i;
        if(board[square[0]][square[1]]=='.'){
            i=1;
        }else{
            i=Character.getNumericValue( board[square[0]][square[1]]);
            i++;
        }
        while (i <= 9) {
            flag=0;
            int locationx = ((square[0] / 3) * 3);
            int locationy = ((square[1] / 3) * 3);
            for (int e = locationx; e < (locationx + 3); e++) {
                for (int r = locationy; r < locationy + 3; r++) {
                    if (board[e][r] == (char) (i+'0')) {
                        flag = 1;
                        break;
                    }
                }
                if (flag == 1) {
                    break;
                }
            }
            for (int j = 0; j < 9 && flag == 0; j++) {
                if (board[square[0]][j] == (char) (i+'0') || board[j][square[1]] == (char) (i+'0')) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                return i;
            }
            i++;
        }
        return 0;
    }
}