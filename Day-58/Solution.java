class Solution {
    public int minAddToMakeValid(String s) {
        int open = 0;
        int ans = 0;
        for (int i = 0; i < s.length() ; i++){
            if (s.charAt(i) == '('){
                open++;
            }
            else{
                open--;
            }
            if (open < 0){
                ans++;
                open = 0;
            }
        }
        if (open > 0){
            ans += open;
        }
        return ans;
    }
}