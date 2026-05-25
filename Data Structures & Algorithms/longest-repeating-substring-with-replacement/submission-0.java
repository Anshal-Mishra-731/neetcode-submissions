class Solution {

    public char getMax(Map<Character, Integer> mp){
        char maxkey = 'A';
        int maxVal = mp.get('A');
        for(Map.Entry<Character, Integer> it : mp.entrySet()){
            if(it.getValue() > maxVal){
                maxVal = it.getValue();
                maxkey = it.getKey();
            }
        }
        return maxkey;
    }

    public int characterReplacement(String s, int k) {
        Map<Character, Integer> mp = new HashMap<>();
        for(char c = 'A'; c <= 'Z'; c++){
            mp.put(c, 0);
        }
        int res = 0; int j = 0;
        for(int i = 0; i < s.length(); i++){
            mp.put( s.charAt(i), mp.get(s.charAt(i)) + 1);
            
            while(i - j + 1 - mp.get(getMax(mp))> k ){
                mp.put(s.charAt(j), mp.get(s.charAt(j)) - 1);
                j++;
            }

            res = Math.max(res, i - j + 1);
        }

        return res;
    }
}