class Solution {

    public int largestRectangleArea(int[] heights) {

        int ma = 0;
        Stack<Integer> index = new Stack<>();
        Stack<Integer> height = new Stack<>();
        for(int i = 0; i < heights.length; i++){
            int start = i;
            while(!height.isEmpty() && heights[i] < height.peek()){
                int h = height.pop();
                int ind = index.pop();
                ma = Math.max(ma, h * (i - ind));
                start = ind;
            }

            height.push(heights[i]);
            index.push(start);
        }

        int n = heights.length;
        while(!height.isEmpty()){
            int h = height.pop();
            int ind = index.pop();
            ma = Math.max(ma, h * (n - ind));
        }

        return ma;
    }
}