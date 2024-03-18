class Solution {
    public int[] twoSum(int[] nums, int target) {
        int sum=0,i=0,j=i+1;
        int[] solution=new int[2];
        int n=nums.length;
        while(j<n){
                sum=nums[i]+nums[j];
                if(sum==target){
                    solution[0]=i;
                    solution[1]=j;
                    return solution;
                }
                else if(j+1!=n){
                    j++;       
                }
                else{
                    i++;
                    j=i+1;
                }
        }
        return null;
    }
}