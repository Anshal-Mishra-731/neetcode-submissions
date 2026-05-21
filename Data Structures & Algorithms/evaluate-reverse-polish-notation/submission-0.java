class Solution {

    public int evalRPN(String[] tokens) {

        Stack<Integer> st = new Stack<>();

        for (String token : tokens) {

            if (!token.equals("+") && !token.equals("-") && !token.equals("*") && !token.equals("/")) 
            {
                st.push(Integer.parseInt(token));
            }
            else 
            {
                int num = st.pop();
                int num2 = st.pop();

                int res = 0;

                if (token.equals("+")) {
                    res = num2 + num;
                }

                else if (token.equals("-")) {
                    res = num2 - num;
                }

                else if (token.equals("*")) {
                    res = num2 * num;
                }

                else {
                    res = num2 / num;
                }

                st.push(res);
            }
        }

        return st.pop();
    }
}