class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int ans = Integer.MAX_VALUE;
        int sum = 0;

        int[] best = new int[n];
        Arrays.fill(best, Integer.MAX_VALUE);

        int left = 0;
        for (int right = 0; right < n; right++) {
            sum += arr[right];
            while (sum > target) {
                sum -= arr[left];
                left++;
            }

            if (sum == target) {
                int currentLength = right - left + 1;

                if (left > 0 && best[left - 1] != Integer.MAX_VALUE) {
                    ans = Math.min(ans, best[left - 1] + currentLength);
                }
                best[right] = currentLength;
            }

            if (right > 0) {
                best[right] = Math.min(best[right], best[right - 1]);
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}