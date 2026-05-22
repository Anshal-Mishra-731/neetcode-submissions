class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = 1;
        int res = 0;
        while(n <= 1000){
            int cnt = 0;
            for(int x : heights){
                if(n > x){
                    res = Math.max(res, cnt*n);
                    cnt = 0; 
                }
                else{
                    cnt++;
                }
            }
            res = Math.max(res, cnt*n);
            n++;
        }
        return res;
    }
}
