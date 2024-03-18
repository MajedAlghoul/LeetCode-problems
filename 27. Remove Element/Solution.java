class Solution {
    public int removeElement(int[] nums, int val) {
        int ptr = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val && nums[ptr] == val) {
                ptr--;
                i--;
            } else if (nums[i] == val && nums[ptr] != val) {
                int temp = nums[i];
                nums[i] = nums[ptr];
                nums[ptr] = temp;
                ptr--;
            }
            if(ptr==i){
                break;
            }
        }
        return ptr+1;
    }
}