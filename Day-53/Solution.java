class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length() ; i++){
            if (isOpen(s.charAt(i))){
                st.push(s.charAt(i));
            }
            else{
                if (st.isEmpty()){
                    return false;
                }
                if ((s.charAt(i) == ')' && st.peek() == '(') || (s.charAt(i) == ']' && st.peek() == '[') || (s.charAt(i) == '}' && st.peek() == '{')){
                    st.pop();
                }
                else{
                    return false;
                }
            }
        }
        return st.isEmpty();
    }
    public boolean isOpen (char c){
        return (c == '(' || c == '[' || c == '{');
    }
}