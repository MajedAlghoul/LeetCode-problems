class Solution {
    public int search(int[] nums, int target) {
        int rotpoint = findrotation(nums);
        if (rotpoint == 0) {
            return binarySearch(nums, 0, nums.length - 1, target);
        }
        if (target < nums[nums.length - 1]) {
            return binarySearch(nums, rotpoint, nums.length - 1, target);
        } else if (target > nums[nums.length - 1]) {
            return binarySearch(nums, 0, rotpoint, target);
        } else if (target == nums[nums.length - 1]) {
            return nums.length - 1;
        } else {
            return -1;
        }
    }

    private int findrotation(int[] nums) {
        int j = nums.length - 1;
        int i;
        for (i = 0; i <= j; i++, j--) {
            if (nums[i] < nums[j] || i == j) {
                if (j + 1 < nums.length && nums[j + 1] < nums[j]) {
                    return j;
                } else {
                    return i;
                }
            }
        }
        return i;
    }

    private int binarySearch(int arr[], int l, int r, int x) {
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (arr[m] == x)
                return m;
            if (arr[m] < x)
                l = m + 1;
            else
                r = m - 1;
        }
        return -1;
    }

}