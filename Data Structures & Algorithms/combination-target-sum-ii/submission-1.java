class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subans = new ArrayList<>();
        Arrays.sort(candidates);
        backt(res, subans, target, candidates, 0);
        return res;
    }

    public void backt(List<List<Integer>> res, List<Integer> subans, int target, int[] nums, int start) {
        if (target == 0) {
            res.add(new ArrayList<>(subans));
            return;
        }
        if(target < 0){
            return;
        }

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] > target) {
                break;
            }
            subans.add(nums[i]);
            backt(res, subans, target - nums[i], nums, i + 1);
            subans.remove(subans.size() - 1);
        }
    }
}