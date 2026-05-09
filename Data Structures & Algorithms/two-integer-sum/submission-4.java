class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> targets = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            int need = target - nums[i]; 

            if(targets.containsKey(need)){
                return new int[]{targets.get(need), i};
            }

            targets.put(nums[i], i); 
        }
        return new int[]{-1, -1};
    }
}
