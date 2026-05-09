class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> mp = new HashMap<>(); 
        for(char c: s.toCharArray()){
            mp.put(c, mp.getOrDefault(c, 0) + 1);
        }
        Map<Character, Integer> mpi = new HashMap<>(); 
        for(char c: t.toCharArray()){
            mpi.put(c, mpi.getOrDefault(c, 0) + 1);
        }

        return mp.equals(mpi);

    }
}
