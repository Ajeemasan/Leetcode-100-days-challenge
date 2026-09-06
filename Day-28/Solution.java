class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();

        // dp[j] will store the number of distinct subsequences of s
        // that match the prefix of t up to index j-1.
        int[] dp = new int[n + 1];

        // Base case: There is exactly 1 way to match an empty string t
        dp[0] = 1;

        // Iterate through each character of the source string s
        for (int i = 1; i <= m; i++) {
            char charS = s.charAt(i - 1);
            // Traverse backwards to use values from the previous iteration of s
            for (int j = n; j >= 1; j--) {
                char charT = t.charAt(j - 1);

                // If characters match, we can either:
                // 1. Use charS to match charT -> dp[j-1]
                // 2. Ignore charS and find the match earlier in s -> dp[j]
                if (charS == charT) {
                    dp[j] = dp[j] + dp[j - 1];
                }
                // If they don't match, dp[j] remains the same (dp[j] = dp[j])
            }
        }

        return dp[n];
    }
}