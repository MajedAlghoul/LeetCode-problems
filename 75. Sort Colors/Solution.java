class Solution {
    public void sortColors(int[] nums) {
        int[] answer = new int[3];
        for (int i = 0; i < nums.length; i++) {
            answer[nums[i]]++;
        }
        int index = 0;
        for (int i = 0; i < answer.length; i++) {
            while (answer[i] > 0) {
                nums[index] = i;
                index++;
                answer[i]--;
            }
        }
    }
}