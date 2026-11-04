public class Solution {
    private static final long INF = Long.MAX_VALUE / 2;

    public long minOperations(int[] nums, int x, int k) {
        int n = nums.length;
        long[] minOps = new long[n - x + 1];

        TreeMap<Integer, Integer> left = new TreeMap<>();
        TreeMap<Integer, Integer> right = new TreeMap<>();
        int leftSize = 0, rightSize = 0;
        long leftSum = 0, rightSum = 0;

        int targetLeft = (x + 1) / 2;

        for (int i = 0; i < n; i++) {
            if (leftSize == 0 || nums[i] <= left.lastKey()) {
                left.put(nums[i], left.getOrDefault(nums[i], 0) + 1);
                leftSum += nums[i];
                leftSize++;
            } else {
                right.put(nums[i], right.getOrDefault(nums[i], 0) + 1);
                rightSum += nums[i];
                rightSize++;
            }

            if (i >= x) {
                int toRemove = nums[i - x];
                if (left.containsKey(toRemove)) {
                    removeOne(left, toRemove);
                    leftSum -= toRemove;
                    leftSize--;
                } else {
                    removeOne(right, toRemove);
                    rightSum -= toRemove;
                    rightSize--;
                }
            }

            while (leftSize > targetLeft) {
                int val = left.lastKey();
                removeOne(left, val);
                leftSum -= val;
                leftSize--;

                right.put(val, right.getOrDefault(val, 0) + 1);
                rightSum += val;
                rightSize++;
            }
            while (leftSize < targetLeft && rightSize > 0) {
                int val = right.firstKey();
                removeOne(right, val);
                rightSum -= val;
                rightSize--;

                left.put(val, left.getOrDefault(val, 0) + 1);
                leftSum += val;
                leftSize++;
            }

            if (i >= x - 1) {
                long median = left.lastKey();
                long cost = (median * leftSize - leftSum) + (rightSum - median * rightSize);
                minOps[i - x + 1] = cost;
            }
        }

        long[][] dp = new long[n + 1][k + 1];
        for (long[] row : dp) Arrays.fill(row, -1);

        return solve(0, k, x, minOps, dp, n);
    }

    private void removeOne(TreeMap<Integer, Integer> map, int val) {
        int count = map.get(val);
        if (count == 1) map.remove(val);
        else map.put(val, count - 1);
    }

    private long solve(int i, int k, int x, long[] minOps, long[][] dp, int n) {
        if (k == 0) return 0;
        if (i > n - k * x) return INF;
        if (dp[i][k] != -1) return dp[i][k];

        long take = minOps[i] + solve(i + x, k - 1, x, minOps, dp, n);
        long skip = solve(i + 1, k, x, minOps, dp, n);

        return dp[i][k] = Math.min(take, skip);
    }
}