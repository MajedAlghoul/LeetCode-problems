class Solution {
    public int jump(int[] nums) {
        int[] path = new int[nums.length];
        for (int x = 0; x < nums.length; x++) {
            path[x] = -1;
        }
        path[0]=0;
        int ptr1 = 0;
        int ptr2 = 1;
        while (path[path.length - 1] == -1) {
            if (nums[ptr1] >= ptr2) {
                if (path[ptr1 + ptr2] == -1)
                    path[ptr1 + ptr2] = path[ptr1]+1;
                ptr2++;
            } else {
                ptr2 = 1;
                ptr1++;
            }
        }
        return path[path.length-1];
    }
}