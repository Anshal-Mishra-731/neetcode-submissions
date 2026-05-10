class Solution {

    public int trap(int[] height) {

        int n = height.length;

        int[] leftarr = new int[n];
        int[] rightarr = new int[n];

        leftarr[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftarr[i] = Math.max(leftarr[i - 1], height[i]);
        }

        rightarr[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightarr[i] = Math.max(rightarr[i + 1], height[i]);
        }

        int fans = 0;
        for (int i = 0; i < n; i++) {
            fans += Math.min(leftarr[i], rightarr[i]) - height[i];
        }

        return fans;
    }
}