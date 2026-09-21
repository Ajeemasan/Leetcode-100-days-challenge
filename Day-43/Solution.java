class Solution {
    public long[] resultArray(int[] nums, int k) {
        long[] ans = new long[k];
        // dp[r] tracks the number of subarrays ending at the current position
        // whose product modulo k is equal to r
        long[] dp = new long[k];

        for (int num : nums) {
            long[] newDp = new long[k];
            int numMod = num % k;

            // 1. Start a new subarray containing only the current number
            newDp[numMod] += 1;

            // 2. Extend all valid subarrays that ended at the previous position
            for (int i = 0; i < k; i++) {
                if (dp[i] > 0) {
                    int newMod = (i * numMod) % k;
                    newDp[newMod] += dp[i];
                }
            }

            // 3. Accumulate the current counts into the global result array
            for (int i = 0; i < k; i++) {
                ans[i] += newDp[i];
            }

            // Move to the next element
            dp = newDp;
        }

        return ans;
    }
}