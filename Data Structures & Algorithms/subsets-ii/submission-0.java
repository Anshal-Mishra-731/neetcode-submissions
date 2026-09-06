class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subans = new ArrayList<>();
        Arrays.sort(nums);
        backt(res, subans, nums, 0);
        return res;
    }

    public void backt(List<List<Integer>> res, List<Integer> subans, int[] nums, int start){
        if(start >= nums.length){
            res.add(new ArrayList<>(subans));
            return;
        }
        subans.add(nums[start]); 
        backt(res, subans, nums, start + 1); 
        subans.remove(subans.size() - 1); 

        int next = start + 1; 
        while(next < nums.length && nums[next] == nums[start]){ next++; }

        backt(res, subans, nums, next); 

    }
}
