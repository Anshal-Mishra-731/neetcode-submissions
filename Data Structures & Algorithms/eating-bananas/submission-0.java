class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int mx = piles[0];
        for(int x : piles){
            mx = Math.max(mx, x);
        }

        int ans = 0;
        int low = 1; 
        int high = mx; 
        while(low <= high){
            int mid= (low+high)/2; 
            int value = 0; 
            for(int x : piles){ value += (x + mid - 1) / mid; }
            if(value <= h){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return ans;
    }
}
