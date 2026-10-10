class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        long k = (long) k1 + k2;

        int[] counts = new int[100001];
        for (int i = 0; i < nums1.length; i++) {
            int diff = Math.abs(nums1[i] - nums2[i]);
            counts[diff]++;
        }

        for (int d = 100000; d > 0; d--) {
            if (counts[d] == 0) continue;

            int reduceCount = (int) Math.min(counts[d], k);

            counts[d] -= reduceCount;
            counts[d - 1] += reduceCount;
            k -= reduceCount;

            if (k == 0) break;
        }

        long totalSum = 0;
        for (int d = 1; d <= 100000; d++) {
            if (counts[d] > 0) {
                totalSum += (long) counts[d] * d * d;
            }
        }

        return totalSum;
    }
}