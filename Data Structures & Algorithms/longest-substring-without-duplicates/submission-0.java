class Solution {

    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        for(int i = 0; i < s.length(); i++){
            Set<Character> st = new HashSet<>();
            int j = i;

            while(j < s.length() && !st.contains(s.charAt(j))){
                st.add(s.charAt(j));
                j++;
            }
            res = Math.max(res, st.size());
        }

        return res;
    }
}