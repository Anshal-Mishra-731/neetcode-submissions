class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<>(); 

        for (int i : nums){
            mp.put(i, mp.getOrDefault(i, 0) + 1); 
        }

        List<List<Integer>> lst = new ArrayList<>(nums.length); 
        for (int i = 0; i <= nums.length; i++) {
            lst.add(new ArrayList<>());
        }

        for(Map.Entry<Integer, Integer> it : mp.entrySet()){
            lst.get(it.getValue() - 1).add(it.getKey()); 
        }

        int[] arr = new int[k]; 
        int idx = 0;
        for(int i = lst.size() - 1; i >= 0; i--){
            for(int j : lst.get(i)){
                arr[idx++] = j; 
                if(idx == k){
                    return arr; 
                }
            }
        }
        return arr;
    }
}
