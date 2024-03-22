class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int[][] dpt = new int[n][n];
        String[][] dpts = new String[n][n];
        for (int i = 0; i < n; i++) {
            dpt[i][i] = 1;
        }
        for (int i = 0; i < n; i++) {
            dpts[i][i] = s.substring(i, i + 1);
        }
        for (int k = 1; k < n; k++) {
            int i = 0, j = k;
            while (j < n) {
                int left = dpt[i][j - 1], down = dpt[i + 1][j];
                if (left == down) {
                    int temp = -1;
                    if (s.charAt(i) == s.charAt(j)) {
                        if (j - i == 1 || dpt[i + 1][j - 1] > dpt[i + 1][j - 2]
                                && dpt[i + 1][j - 1] > dpt[i + 2][j - 1]) {
                            temp = (j-i)+1;
                        }
                    }
                    if (temp > left) {
                        dpts[i][j] = s.substring(i, j + 1);
                        dpt[i][j] = temp;
                    } else {
                        dpts[i][j] = dpts[i][j - 1];
                        dpt[i][j] = left;
                    }
                } else {
                    if (down > left) {
                        dpts[i][j] = dpts[i + 1][j];
                        dpt[i][j] = down;
                    } else {
                        dpts[i][j] = dpts[i][j - 1];
                        dpt[i][j] = left;
                    }
                }
                i++;
                j++;
            }
        }
        return dpts[0][n - 1];
    }
}