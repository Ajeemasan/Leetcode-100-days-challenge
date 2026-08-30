class Solution {
    public int minimumDeletions(int[] nums) {
        int min = -1, max = -1;
        int minVal = Integer.MAX_VALUE, maxVal = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length ; i++){
            if (nums[i] < minVal){
                minVal = nums[i];
                min = i;
            }
            if (nums[i] > maxVal){
                maxVal = nums[i];
                max = i;
            }
        }
        int delFront = Math.max(min, max) + 1;
        int delBack = nums.length - Math.min(min, max);
        int delBoth = Math.min(min, max) + 1 + nums.length - Math.max(min, max);

        return Math.min(delFront, Math.min(delBack, delBoth));
    }
}