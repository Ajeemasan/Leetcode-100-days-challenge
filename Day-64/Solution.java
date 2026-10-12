class Solution {
    public int maxSum(List<Integer> nums, int k) {
        long MOD = 1_000_000_007;
        int[] bitCounts = new int[30];

        for (int num : nums) {
            for (int i = 0; i < 30; i++) {
                if (((num >> i) & 1) == 1) {
                    bitCounts[i]++;
                }
            }
        }

        long totalSumOfSquares = 0;


        for (int step = 0; step < k; step++) {
            long currentNum = 0;
            for (int i = 0; i < 30; i++) {
                if (bitCounts[i] > 0) {
                    currentNum |= (1 << i);
                    bitCounts[i]--;
                }
            }

            totalSumOfSquares = (totalSumOfSquares + (currentNum * currentNum) % MOD) % MOD;
        }

        return (int) totalSumOfSquares;
    }
}