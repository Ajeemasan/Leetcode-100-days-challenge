class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int mid = 0;
        if (n%2 == 1){
            mid = nums[n/2];
        }
        else{
            mid = (nums[n/2] + nums[n/2 - 1])/2;
        }
        int ans = 0;
        for (int i = 0; i < n ;i++){
            ans += Math.abs((mid-nums[i]));
        }
        return ans;
    }
}