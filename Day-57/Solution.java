
class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        st.push(0);

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                st.push(0);
            } else {
                int innerScore = st.pop();
                int currentBlockScore = (innerScore == 0) ? 1 : 2 * innerScore;


                int parentScore = st.pop();
                st.push(parentScore + currentBlockScore);
            }
        }

        return st.pop();
    }
}