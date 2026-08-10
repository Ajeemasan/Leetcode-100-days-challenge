class Solution {
    int[] squares;
    Boolean[] dp;
    public boolean winnerSquareGame(int n) {
        squares = new int[(int)(Math.sqrt(n))];
        dp = new Boolean[n+1];
        for (int i = 1 ; i <= squares.length ; i++){
            squares[i-1] = i*i;
        }
        return solve(n);
    }
    public boolean solve (int n){
        if (n == 0){
            return false;
        }
        if (dp[n] != null){
            return dp[n];
        }
        for (int i = 0 ; i < squares.length && squares[i] <= n; i++){
            if (!solve(n-squares[i])){
                return dp[n] = true;
            }
        }
        return dp[n] = false;
    }
}