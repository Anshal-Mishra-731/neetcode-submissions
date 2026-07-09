class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int x : nums) {
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }

        List<Integer>[] buckets = new ArrayList[nums.length + 1];

        for (int i = 0; i <= nums.length; i++) {
            buckets[i] = new ArrayList<>();
        }

        for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
            buckets[e.getValue()].add(e.getKey());
        }

        int[] ans = new int[k];
        int idx = 0;

        for (int i = buckets.length - 1; i >= 0; i--) {
            for (int num : buckets[i]) {
                ans[idx++] = num;
                if (idx == k) {
                    return ans;
                }
            }
        }
        return ans;
    }
}
