class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subans = new ArrayList<>();
        HashSet<Integer> st = new HashSet<>();
        backt(res, subans, nums, st);
        return res; 
    }

    public void backt(List<List<Integer>> res, List<Integer> subans, int[] nums, HashSet<Integer> st){
        if(subans.size() == nums.length){
            res.add(new ArrayList<>(subans));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(!st.contains(nums[i])){
                st.add(nums[i]);
                subans.add(nums[i]);
                backt(res, subans, nums, st);
                st.remove(nums[i]);
                subans.remove(subans.size() - 1);
            }
        }
    }
}
