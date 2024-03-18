class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
      List <List<Integer>> motherlist=new LinkedList<>();
      Set<List<Integer>> set = new HashSet<>();
        int ptr1=0;
        int ptr2=1;
        int ptr3=0;
        int temp=0;
        Arrays.sort(nums);
        while(ptr1<nums.length){
            ptr2=ptr1+1;
            ptr3=nums.length-1;
            while(ptr2<ptr3){
                temp=nums[ptr1]+nums[ptr2]+nums[ptr3];
                if(temp==0){
                    set.add(Arrays.asList(nums[ptr1],nums[ptr2],nums[ptr3]));
                    ptr2++;
                    ptr3--;
                }else if(temp<0){
                    ptr2++;
                }else{
                    ptr3--;
                }
            }
            ptr1++;
        }
        motherlist.addAll(set);
        return motherlist;
    }
}