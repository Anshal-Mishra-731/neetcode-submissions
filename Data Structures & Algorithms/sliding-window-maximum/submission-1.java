class Solution {

    public int[] maxSlidingWindow(int[] nums, int k) {

        ArrayDeque<Integer> ad = new ArrayDeque<>();
        int[] res = new int[nums.length - k + 1];
        int idx = 0;

        for (int i = 0; i < nums.length; i++) {
            if (!ad.isEmpty() && ad.getFirst() <= i - k) {
                ad.removeFirst();
            }
            
            while (!ad.isEmpty() && nums[i] > nums[ad.getLast()]) {
                ad.removeLast();
            }
            ad.addLast(i);
            if (i >= k - 1) {
                res[idx++] = nums[ad.getFirst()];
            }
        }
        return res;
    }
}