class Solution {

    public int trap(int[] height) {
        int l = 0; 
        int r = height.length - 1; 

        int leftMax = height[0]; 
        int rightMax = height[height.length - 1]; 
        int wans = 0;

        while(l <= r){
            if(leftMax <= rightMax){
                leftMax = Math.max(leftMax, height[l]); 
                wans += leftMax - height[l]; 
                l++;
            }
            else{
                rightMax = Math.max(rightMax, height[r]); 
                wans += rightMax - height[r]; 
                r--;
            }
        }

        return wans;
    }
}