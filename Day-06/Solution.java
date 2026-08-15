class Solution {
    public int longestSubsequence(int[] nums) {
        int l = 0;
        int i = 0;
        int val = 0;
        int f = 0;
        while (i < nums.length){
            if (nums[i] != 0){
                f = 1;
            }
            val ^= nums[i];
            l++;
            i++;
        }
        if (f == 0){
            return 0;
        }
        return (val != 0) ? l : l-1 ;
    }
}