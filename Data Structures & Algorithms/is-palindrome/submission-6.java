class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder neu = new StringBuilder(); 
        for(char c : s.toCharArray()){
            if(Character.isLetterOrDigit(c)){
                neu.append(Character.toLowerCase(c)); 
            }
        }
        int i = 0; 
        int j = neu.length() - 1; 
        while(i <= j){
            if(neu.charAt(i) != neu.charAt(j)){
                return false;
            }
            i++; 
            j--; 
        }
        return true;
    }
}