class Solution {

    public boolean ibigger(HashMap<Character, Integer> ein, HashMap<Character, Integer> dwei) {
        for (Map.Entry<Character, Integer> c : ein.entrySet()) {
            if (dwei.getOrDefault(c.getKey(), 0) < c.getValue()) {
                return false;
            }
        }

        return true;
    }

    public String minWindow(String s, String t) {

        HashMap<Character, Integer> ein = new HashMap<>();
        for (char c : t.toCharArray()) {
            ein.put(c, ein.getOrDefault(c, 0) + 1);
        }

        HashMap<Character, Integer> dwei = new HashMap<>();
        int l = 0; int start = 0; int minLen = Integer.MAX_VALUE;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            dwei.put(ch, dwei.getOrDefault(ch, 0) + 1);

            while (ibigger(ein, dwei)) {
                if (i - l + 1 < minLen) {
                    minLen = i - l + 1;
                    start = l;
                }

                char left = s.charAt(l);
                dwei.put(left, dwei.get(left) - 1);
                if (dwei.get(left) == 0) {
                    dwei.remove(left);
                }
                l++;
            }
        }

        if (minLen == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(start, start + minLen);
    }
}