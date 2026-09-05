class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[][] minmax = new int[n][2];
        minmax[0][0] = nums[0];
        for (int i = 1; i < n ; i++){
            minmax[i][0] = Math.max(minmax[i-1][0], nums[i]);
        }
        minmax[n-1][1] = nums[n-1];
        for (int i = n-2; i >= 0 ; i--){
            minmax[i][1] = Math.min(minmax[i+1][1], nums[i]);
        }
        for (int i = 0; i < n ; i++){
            if (minmax[i][0] - minmax[i][1] <= k){
                return i;
            }
        }
        return -1;
    }
}