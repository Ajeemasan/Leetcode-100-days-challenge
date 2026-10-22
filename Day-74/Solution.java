class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;

        int ind = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                ind = i;
                break;
            }
        }

        boolean isInc = true;
        boolean isDec = true;

        for (int i = 0; i < n; i++) {
            if (nums[(ind + i) % n] != i) {
                isInc = false;
            }
            if (nums[(ind - i + n) % n] != i) {
                isDec = false;
            }
        }

        if (!isInc && !isDec) {
            return -1;
        }

        int ans = Integer.MAX_VALUE;

        if (isInc) {
            ans = Math.min(ans, ind);
            ans = Math.min(ans, n - ind + 2);
        }

        if (isDec) {
            ans = Math.min(ans, ind + 2);
            ans = Math.min(ans, n - ind);
        }

        return ans;
    }
}
