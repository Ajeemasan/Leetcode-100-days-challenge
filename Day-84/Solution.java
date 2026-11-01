class Solution {
    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int num : nums){
            if (num < min){
                min = num;
            }
        }
        int ans = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++){
            if (nums[i] == min) continue;
            ans += nums[i] - min;
        }
        return ans;
    }
}