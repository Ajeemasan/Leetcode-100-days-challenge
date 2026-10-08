class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int i = 1;
        int open = 0;
        while (i < s.length()){
            if (s.charAt(i) == '('){
                open++;
                sb.append(s.charAt(i));
            }
            else{
                if (open == 0){
                    i++;
                }
                else{
                    open--;
                    sb.append(s.charAt(i));
                }
                if (open < 0){
                    open = 0;
                }
            }
            i++;
        }
        return sb.toString();
    }
}