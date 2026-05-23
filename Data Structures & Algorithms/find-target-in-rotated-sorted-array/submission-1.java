class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1; 
        int minim = 0;
        while(low <= high){
            if(nums[low] <= nums[high]){
                if(nums[low] < nums[minim]) minim = low; 
                break;
            }

            int mid = (low + high)/2;
            if(nums[mid] < nums[minim]) minim = mid;

            if(nums[mid] >= nums[low]){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }

        low = 0; 
        high = minim - 1;
        while(low <= high){
            int mid = (low + high)/2;
            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid] > target){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }

        low = minim;
        high = nums.length - 1;
        while(low <= high){
            int mid = (low + high)/2;
            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid] > target){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }

        return -1;
    }
}
