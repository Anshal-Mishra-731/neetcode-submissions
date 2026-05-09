class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] pref = new int[nums.length]; 
        int[] suff = new int[nums.length]; 
        pref[0] = 1; suff[nums.length - 1] = 1; 
        for(int i = 1; i < nums.length; i++){
            pref[i] = nums[i-1]*pref[i-1]; 
        }
        for(int j = nums.length - 2; j >= 0; j--){
            suff[j] = nums[j+1]*suff[j+1]; 
        }

        int[] arr = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            arr[i] = pref[i]*suff[i]; 
        }
        return arr;
    }
}  
