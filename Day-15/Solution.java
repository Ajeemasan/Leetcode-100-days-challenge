class Solution {
    public int stoneGameVIII(int[] stones) {
        int n = stones.length;

        // Step 1: Calculate prefix sums directly in place to save space
        for (int i = 1; i < n; i++) {
            stones[i] += stones[i - 1];
        }

        // Step 2: Base case.
        // The last player must take all remaining stones (index n - 1).
        int maxDiff = stones[n - 1];

        // Step 3: Work backwards from the second to last element down to index 1.
        // We stop at index 1 because the first player must take at least 2 stones (index >= 1).
        for (int i = n - 2; i >= 1; i--) {
            maxDiff = Math.max(maxDiff, stones[i] - maxDiff);
        }

        return maxDiff;
    }
}