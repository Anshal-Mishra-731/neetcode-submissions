class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subans = new ArrayList<>();
        backt(nums, subans, res, 0);
        return res;
    }

    public void backt(int[] nums, List<Integer> subans, List<List<Integer>> res, int start){
        if(start >= nums.length){
            res.add(new ArrayList<>(subans));
            return;
        }

        subans.add(nums[start]);
        backt(nums, subans, res, start+1);

        subans.remove(subans.size() - 1);
        backt(nums, subans, res, start+1);
    }
}
