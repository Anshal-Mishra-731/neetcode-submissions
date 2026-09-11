class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> subans = new ArrayList<>();
        backt(res, subans, s, 0);
        return res;
    }

    public void backt(List<List<String>> res, List<String> subans, String s, int start){
        if(start >= s.length()){
            res.add(new ArrayList<>(subans));
            return;
        }

        String level = s.substring(start, s.length());
        for(int i = 1; i <= level.length(); i++){
            if(isPali(level.substring(0, i))){
                subans.add(level.substring(0, i));
                backt(res, subans, s, start + i);
                subans.remove(subans.size() - 1);
            }
        }
    }
    public boolean isPali(String s){
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
