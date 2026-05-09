class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> listus = new ArrayList<>();
        Arrays.sort(nums);

        for (int tar = 0; tar < nums.length; tar++) {
            if (tar > 0 && nums[tar] == nums[tar - 1]) {
                continue;
            }

            int target = -nums[tar];

            int i = tar + 1;
            int j = nums.length - 1;

            while (i < j) {
                int sumo = nums[i] + nums[j];
                if (sumo == target) {
                    List<Integer> temp = new ArrayList<>();

                    temp.add(nums[tar]);
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    listus.add(temp);

                    i++;
                    j--;
                    while (i < j && nums[i] == nums[i - 1]) {
                        i++;
                    }
                    while (i < j && nums[j] == nums[j + 1]) {
                        j--;
                    }
                }

                else if (sumo < target) {
                    i++;
                }
                else {
                    j--;
                }
            }
        }

        return listus;
    }
}