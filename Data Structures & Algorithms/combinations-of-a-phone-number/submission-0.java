class Solution {
    public List<String> letterCombinations(String digits) {
        Map<Character, String> mp = new HashMap<>();
        mp.put('2', "abc");mp.put('3', "def");mp.put('4', "ghi");mp.put('5', "jkl");
        mp.put('6', "mno");mp.put('7', "pqrs"); mp.put('8', "tuv");mp.put('9', "wxyz");
        List<String> res = new ArrayList<>();
        String subans = "";
        if (digits.length() == 0) {
            return res;
        }
        backt(res, subans, mp, digits, 0);
        return res;
    }

    public void backt(List<String> res, String subans, Map<Character, String> mp, String digits, int idx){
        if(subans.length() == digits.length()){
            res.add(subans);
            return;
        }
        String level = mp.get(digits.charAt(idx));
        for(char c : level.toCharArray()){
            subans += c;
            backt(res, subans, mp, digits, idx + 1);
            subans = subans.substring(0, subans.length() - 1);
        }
    }
}
