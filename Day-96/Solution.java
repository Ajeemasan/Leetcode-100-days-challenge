class Solution {
    public long countNonDecreasingSubarrays(int[] nums, int k) {
        int n = nums.length;
        long ans = 0;
        long cost = 0;


        Deque<int[]> dq = new ArrayDeque<>();

        int j = n - 1;

        for (int i = n - 1; i >= 0; i--) {
            int num = nums[i];
            int count = 1;

            while (!dq.isEmpty() && dq.peekLast()[0] < num) {
                int[] nextBlock = dq.pollLast();
                int nextVal = nextBlock[0];
                int nextCount = nextBlock[1];

                count += nextCount;
                cost += (long) (num - nextVal) * nextCount;
            }

            dq.offerLast(new int[]{num, count});

            while (cost > k) {
                int[] rightmostBlock = dq.peekFirst();
                int targetVal = rightmostBlock[0];

                cost -= (targetVal - nums[j]);
                j--;

                rightmostBlock[1]--;
                if (rightmostBlock[1] == 0) {
                    dq.pollFirst();
                }
            }

            ans += (j - i + 1);
        }

        return ans;
    }
}