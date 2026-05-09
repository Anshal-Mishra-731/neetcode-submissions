class Solution {
    public int maxArea(int[] heights) {
        int i = 0; int j = heights.length - 1; 
        int ans = 0; 
        while(i < j){
            int volume = (j-i)*(Math.min(heights[i], heights[j])); 
            ans = Math.max(ans, volume); 
            if(Math.min(heights[i], heights[j]) == heights[i]){
                i++; 
            }
            else{
                j--;
            }
        }
        return ans;
    }
}
