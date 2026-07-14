class Solution {

    public int largestRectangleArea(int[] heights) {

        Stack<Integer> agrim = new Stack<>();
        Stack<Integer> pichla = new Stack<>();

        int[] forward = new int[heights.length];
        int[] backward = new int[heights.length];

        for(int i = 0; i < heights.length; i++){
            while(!agrim.isEmpty() && heights[i] < heights[agrim.peek()]){
                forward[agrim.pop()] = i;
            }
            agrim.push(i);
        }
        while(!agrim.isEmpty()){forward[agrim.pop()] = heights.length;}

        for(int i = heights.length - 1; i >= 0; i--){
            while(!pichla.isEmpty() && heights[i] < heights[pichla.peek()]){
                backward[pichla.pop()] = i;
            }
            pichla.push(i);
        }
        while(!pichla.isEmpty()){backward[pichla.pop()] = -1;}

        int res = 0;
        for(int i = 0; i < heights.length; i++){
            int width = forward[i] - backward[i] - 1;
            res = Math.max(res, width * heights[i]);
        }
        return res;
    }
}