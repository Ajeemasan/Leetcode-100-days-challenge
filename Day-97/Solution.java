class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int ans = Integer.MAX_VALUE;
        int n = nums.size();
        int[] prefix = new int[n];
        prefix[0] = nums.get(0);
        for (int i = 1; i < n; i++){
            prefix[i] = prefix[i-1] + nums.get(i);
        }
        int prev = 0;
        for (int i = 0; i < n ; i++){
            for (int j = i + l - 1; j < n && j < i + r; j++){
                int curr = prefix[j] - prev;
                ans = (curr > 0) ? Math.min(ans, curr) : ans;
            }
            prev = prefix[i];
        }
        return (ans == Integer.MAX_VALUE) ? -1 : ans;
    }
}