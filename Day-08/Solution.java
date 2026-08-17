class Solution {
    int[][] dp;
    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;
        int[] prefix = new int[n+1];
        for (int i = 0; i < n ; i++){
            prefix[i+1] = prefix[i] + stoneValue[i];
        }
        dp = new int[n+1][n+1];
        for (int[] arr: dp){
            Arrays.fill(arr, -1);
        }
        return solve(stoneValue, prefix, 0, n-1);
    }
    public int solve (int[] stones, int[] prefix, int s, int e){
        if (s == e){
            return 0;
        }

        if (dp[s][e] != -1){
            return dp[s][e];
        }

        int ans = 0;

        int left = 0, right = 0;
        for (int i = s; i < e ; i++){
            left = prefix[i+1] - prefix[s];
            right = prefix[e+1] - prefix[i+1];

            int cur = 0;

            if (left < right){
                cur = left + solve(stones, prefix, s, i);
                ans = Math.max(ans, cur);
            }
            else if (right < left){
                cur = right + solve(stones, prefix, i+1, e);
                ans = Math.max(ans, cur);
            }
            else{
                cur = left + solve (stones, prefix, s, i);
                ans = Math.max(ans, cur);

                cur = right + solve(stones, prefix, i+1, e);
                ans = Math.max(ans, cur);
            }
        }
        dp[s][e] = ans;
        return dp[s][e];
    }
}