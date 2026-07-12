class Solution {
    public int getMax(int[] freq) {
        int maxVal = 0;
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > maxVal) {
                maxVal = freq[i];
            }
        }
        return maxVal;
    }

    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int res = 0;
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'A']++;
            while (i - j + 1 - getMax(freq) > k) {
                freq[s.charAt(j) - 'A']--;
                j++;
            }
            res = Math.max(res, i - j + 1);
        }

        return res;
    }
}