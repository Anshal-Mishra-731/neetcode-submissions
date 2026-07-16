class Solution {
    public int findMin(int[] nums) {
        int mini = nums[nums.length - 1]; 

        int low = 0; 
        int high = nums.length - 1; 

        while(low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] <= mini){
                mini = nums[mid];
                high = mid - 1; 
            }
            else{
                low = mid + 1;
            }
        }

        return mini;
    }
}
