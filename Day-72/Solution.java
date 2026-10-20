class Solution {
    public int sortableIntegers(int[] nums) {
        int n = nums.length;
        int sum = 0;

        List<Integer> divisors = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                divisors.add(i);
                if (i * i != n) {
                    divisors.add(n / i);
                }
            }
        }

        for (int k : divisors) {
            if (isValidBlockSize(nums, n, k)) {
                sum += k;
            }
        }

        return sum;
    }

    private boolean isValidBlockSize(int[] nums, int n, int k) {
        int previousMax = Integer.MIN_VALUE;

        for (int start = 0; start < n; start += k) {
            int currentMin = Integer.MAX_VALUE;
            int currentMax = Integer.MIN_VALUE;
            int drops = 0;

            for (int i = 0; i < k; i++) {
                int currIdx = start + i;
                int nextIdx = start + (i + 1) % k;

                currentMin = Math.min(currentMin, nums[currIdx]);
                currentMax = Math.max(currentMax, nums[currIdx]);

                if (nums[currIdx] > nums[nextIdx]) {
                    drops++;
                }
            }

            if (drops > 1) {
                return false;
            }

            if (currentMin < previousMax) {
                return false;
            }

            previousMax = currentMax;
        }

        return true;
    }
}