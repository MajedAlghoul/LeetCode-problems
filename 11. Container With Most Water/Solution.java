class Solution {
    public int maxArea(int[] height) {
        int ptr1=0;
        int ptr2=height.length-1;
        int max=0;
        int temp;
        while(ptr1<ptr2){
            temp=(ptr2-ptr1)*Math.min(height[ptr1],height[ptr2]);
            if(temp>max)
                max=temp;
            if(height[ptr1]>height[ptr2]){
                ptr2--;
            }else{
                ptr1++;
            }
        }
        return max;
    }
}