class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int x : nums){
            set.add(x); 
        }
        if(set.size() < nums.length){
            return true;
        }
        else{
            return false;
        }
    }
}