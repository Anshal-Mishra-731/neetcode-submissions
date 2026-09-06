class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subans = new ArrayList<>();
        backt(res, subans, target, nums, 0);
        return res;
    }
    public void backt(List<List<Integer>> res, List<Integer> subans, int target, int[] nums, int start){
        if(target == 0){
            res.add(new ArrayList<>(subans));
            return;
        }

        if(target < 0){
            return;
        }

        for(int i = start; i <nums.length; i++){
            subans.add(nums[i]);
            backt(res, subans, target - nums[i], nums, i);
            subans.remove(subans.size() - 1);
        }
    }
}
