class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        generate(n, 0, 0, ans);
        return ans;
    }
    StringBuilder sb = new StringBuilder();
    public void generate (int n, int open, int close, List<String> ans){
        if (sb.length() == 2*n){
            ans.add(sb.toString());
            return;
        }
        if (open < n){
            sb.append('(');
            generate (n, open + 1, close, ans);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (close < open){
            sb.append(')');
            generate (n, open, close + 1, ans);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}