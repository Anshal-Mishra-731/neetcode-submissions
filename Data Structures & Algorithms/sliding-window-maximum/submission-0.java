class Solution {

    public int[] maxSlidingWindow(int[] nums, int k) {

        ArrayDeque<Integer> ad = new ArrayDeque<>();
        for (int i = 0; i < k; i++) {
            while (!ad.isEmpty() && nums[i] > ad.getLast()) {
                ad.removeLast();
            }
            ad.add(nums[i]);
        }

        int[] res = new int[nums.length - k + 1];
        res[0] = ad.getFirst();
        int idx = 1;

        for (int i = k; i < nums.length; i++) {
            if (nums[i - k] == ad.getFirst()) {
                ad.removeFirst();
            }
            while (!ad.isEmpty() && nums[i] > ad.getLast()) {
                ad.removeLast();
            }
            ad.add(nums[i]);
            res[idx++] = ad.getFirst();
        }

        return res;
    }
}