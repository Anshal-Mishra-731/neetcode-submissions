class Solution {

    public int lengthOfLongestSubstring(String s) {

        Set<Character> seti = new HashSet<>();

        int j =0; int res = 0;

        for(int i = 0; i < s.length(); i++){
            while(seti.contains(s.charAt(i))){
                seti.remove(s.charAt(j));
                j++;
            }
            seti.add(s.charAt(i));

            res = Math.max(res, seti.size());
        }
        return res;
    }
}