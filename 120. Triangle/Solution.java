class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        triangle.get(0).get(0);
        int[][] arr = new int[triangle.size()][triangle.size()];
        for (int i = 0; i < triangle.size(); i++) {
            for (int j = 0; j <= i; j++) {
                arr[i][j] = Integer.MAX_VALUE;
            }
        }
        arr[0][0] = triangle.get(0).get(0);
        for (int i = 0; i < triangle.size() - 1; i++) {
            for (int j = 0; j <= i; j++) {
                arr[i + 1][j] = Math.min(arr[i + 1][j], arr[i][j] + triangle.get(i + 1).get(j));
                arr[i + 1][j + 1] = Math.min(arr[i + 1][j + 1], arr[i][j] + triangle.get(i + 1).get(j + 1));
            }
        }
        int mini = Integer.MAX_VALUE;
        for (int i = 0; i < triangle.size(); i++) {
            mini = Math.min(mini, arr[triangle.size() - 1][i]);
        }
        return mini;
    }
}