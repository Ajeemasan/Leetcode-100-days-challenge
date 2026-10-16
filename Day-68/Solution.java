class Solution {
    private static final int MOD = 1_000_000_007;

    static class SegmentTree {
        int n;
        long[] sumOfSquares;
        long[] sumOfCounts;
        long[] lazy;

        public SegmentTree(int n) {
            this.n = n;
            this.sumOfSquares = new long[4 * n];
            this.sumOfCounts = new long[4 * n];
            this.lazy = new long[4 * n];
        }

        private void push(int node, int start, int end) {
            if (lazy[node] == 0) return;

            long val = lazy[node];
            int mid = (start + end) / 2;
            int leftChild = 2 * node;
            int rightChild = 2 * node + 1;

            apply(leftChild, start, mid, val);
            apply(rightChild, mid + 1, end, val);

            lazy[node] = 0;
        }

        private void apply(int node, int start, int end, long val) {
            long rangeLen = end - start + 1;


            long term1 = sumOfSquares[node];
            long term2 = (2 * val % MOD) * sumOfCounts[node] % MOD;
            long term3 = (val * val % MOD) * rangeLen % MOD;

            sumOfSquares[node] = (term1 + term2 + term3) % MOD;
            sumOfCounts[node] = (sumOfCounts[node] + val * rangeLen) % MOD;
            lazy[node] = (lazy[node] + val) % MOD;
        }

        public void update(int node, int start, int end, int l, int r, long val) {
            if (r < start || end < l) return;
            if (l <= start && end <= r) {
                apply(node, start, end, val);
                return;
            }

            push(node, start, end);
            int mid = (start + end) / 2;
            update(2 * node, start, mid, l, r, val);
            update(2 * node + 1, mid + 1, end, l, r, val);

            sumOfSquares[node] = (sumOfSquares[2 * node] + sumOfSquares[2 * node + 1]) % MOD;
            sumOfCounts[node] = (sumOfCounts[2 * node] + sumOfCounts[2 * node + 1]) % MOD;
        }

        public long queryTotal() {
            return sumOfSquares[1];
        }
    }

    public int sumCounts(int[] nums) {
        int n = nums.length;
        SegmentTree tree = new SegmentTree(n);
        Map<Integer, Integer> lastSeen = new HashMap<>();
        long totalSum = 0;

        for (int r = 0; r < n; r++) {
            int l = lastSeen.getOrDefault(nums[r], -1) + 1;

            tree.update(1, 0, n - 1, l, r, 1);

            lastSeen.put(nums[r], r);

            totalSum = (totalSum + tree.queryTotal()) % MOD;
        }

        return (int) totalSum;
    }
}