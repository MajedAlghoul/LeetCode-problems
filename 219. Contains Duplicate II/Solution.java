class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.getOrDefault(nums[i], -1) == -1) {
                map.put(nums[i], i);
            } else {
                if (Math.abs(map.getOrDefault(nums[i], -1) - i) <= k) {
                    return true;
                } else {
                    map.put(nums[i], i);
                }
            }
        }
        return false;
    }
}