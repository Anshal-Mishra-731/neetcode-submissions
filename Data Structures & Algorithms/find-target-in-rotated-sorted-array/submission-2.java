class Solution {
    public int Bsearch(int[] nums, int low, int high, int target){
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

    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1; 
        int minInd = nums.length - 1; 
        while(low <= high){
            int mid = low + (high - low)/2; 
            if(nums[mid] <= nums[minInd]){
                minInd = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return Math.max(Bsearch(nums, 0, minInd - 1, target), Bsearch(nums, minInd, nums.length - 1, target));
    }
}
