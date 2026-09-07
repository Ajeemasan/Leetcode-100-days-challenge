class Solution {
    public int distinctSubseqII(String str) {
        int n = str.length();
        int mod = 1000000007;

        int[] dp = new int[n + 1];
        dp[0] = 1;

        int[] last = new int[26];
        Arrays.fill(last, -1);

        for (int i = 1; i <= n; i++) {
            dp[i] = (2 * dp[i - 1]) % mod;

            int idx = str.charAt(i - 1) - 'a';
            if (last[idx] != -1) {
                dp[i] = (dp[i] - dp[last[idx]] + mod) % mod;
            }

            last[idx] = i - 1;
        }
        return (dp[n] - 1 + mod)%mod;
    }
}