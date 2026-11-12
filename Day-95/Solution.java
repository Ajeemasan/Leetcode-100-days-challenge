class Solution {
    public static int longestMonotonicSubarray(int[] nums) {
        int ans1 = 0, ans2 = 0;
        int n = nums.length;
        int prev = nums[0];
        int curr = 1;
        for (int i = 1; i < n ; i++){
            if (prev < nums[i]){
                curr++;
            }
            else{
                ans1 = Math.max(ans1, curr);
                curr = 1;
            }
            prev = nums[i];
        }
        ans1 = Math.max(ans1, curr);
        prev = nums[0];
        curr = 1;
        for (int i = 1; i < n ; i++){
            if (prev > nums[i]){
                curr++;
            }
            else{
                ans2 = Math.max(ans2, curr);
                curr = 1;
            }
            prev = nums[i];
        }
        ans2 = Math.max(ans2, curr);
        return Math.max(ans1, ans2);
    }
}