class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[][] maxmin = new int[n][2];
        maxmin[0][0] = nums[0];
        maxmin[n-1][1] = nums[n-1];
        for (int i = 1; i < n ; i++){
            maxmin[i][0] = Math.max(maxmin[i-1][0], nums[i]);
        }
        for (int i = n-2; i >=0 ; i--){
            maxmin[i][1] = Math.min(maxmin[i+1][1], nums[i]);
        }
        for (int i = 0; i < n; i ++){
            if (maxmin[i][0] - maxmin[i][1] <= k){
                return i;
            }
        }
        return -1;

    }
}