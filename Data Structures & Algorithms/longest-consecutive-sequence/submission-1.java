class Solution {
    public int longestConsecutive(int[] nums) {
        int ans = 0; 
        Set<Integer> seti = new HashSet<>(); 

        for(int i = 0; i < nums.length; i++){
            seti.add(nums[i]);
        }

        for(int i= 0; i < nums.length; i++){
            int length = 0;
            int num = nums[i] - 1;
            if(!(seti.contains(num))){
                num++; 
                while(seti.contains(num)){
                    length++;
                    num++;
                }
            }
            ans = Math.max(length, ans); 
        }
        return ans;
    }
}
