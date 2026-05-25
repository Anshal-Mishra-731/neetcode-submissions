class Solution {

    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()){
            return false;
        }
        Map<Character, Integer> mp = new HashMap<>();

        for(char c : s1.toCharArray()){
            mp.put(c, mp.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> tmp = new HashMap<>();

        for(int i = 0; i < s2.length(); i++){
            if(i >= s1.length()){
                char rem = s2.charAt(i - s1.length());
                tmp.put(rem, tmp.get(rem) - 1);
                if(tmp.get(rem) == 0){
                    tmp.remove(rem);
                }
            }

            char add = s2.charAt(i);
            tmp.put(add, tmp.getOrDefault(add, 0) + 1);
            if(tmp.equals(mp)){
                return true;
            }
        }

        return false;
    }
}