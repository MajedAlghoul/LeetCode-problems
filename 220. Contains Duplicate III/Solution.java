class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        if (valueDiff == 0 && indexDiff + 1 >= nums.length) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < nums.length; j++) {
                if (map.getOrDefault(nums[j], null) == null) {
                    map.put(nums[j], j);
                } else {
                    return true;
                }
            }
            return false;
        } else if (valueDiff == 0) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int j = 1; j < nums.length; j++) {
                if (map.getOrDefault(nums[j], null) == null) {
                    map.put(nums[j], j);
                } else {
                    if (Math.abs(map.get(nums[j]) - j) <= indexDiff) {
                        return true;
                    }
                    map.put(nums[j], j);
                }
            }
            return false;
        } else if (indexDiff + 1 >= nums.length) {
            for (int j = 0; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (Math.abs(nums[k] - nums[j]) <= valueDiff) {
                        return true;
                    }
                }
            }
            return false;
        } else {
            int groupslength = Math.min(indexDiff, nums.length - 1);
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1, counter = 1; counter <= groupslength && j < nums.length; j++, counter++) {
                    if (Math.abs(nums[i] - nums[j]) <= valueDiff) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
}