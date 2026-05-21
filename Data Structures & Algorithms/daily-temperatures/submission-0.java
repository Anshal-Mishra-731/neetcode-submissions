class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st = new Stack<>(); 
        st.push(0);

        int[] res = new int[temperatures.length];

        for(int i = 1; i < temperatures.length; i++){
            while(!st.isEmpty() && temperatures[i] > temperatures[st.peek()]){
                res[st.peek()] = i - st.peek(); 
                st.pop();
            }
            st.push(i);
        }
        return res;
    }
}
