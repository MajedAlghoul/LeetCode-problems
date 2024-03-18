class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int[] answer = new int[quiet.length];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = i;
        }
        for (int i = 0; i < richer.length; i++) {
            if (quiet[answer[richer[i][0]]] < quiet[answer[richer[i][1]]]) {
                answer[richer[i][1]] = answer[richer[i][0]];
            }
        }
        for (int i = richer.length - 1; i >= 0; i--) {
            if (quiet[answer[richer[i][0]]] < quiet[answer[richer[i][1]]]) {
                answer[richer[i][1]] = answer[richer[i][0]];
            }
        }
        return answer;
    }
}