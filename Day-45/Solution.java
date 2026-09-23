class Solution {
    public int minOperations(int[] nums, int x) {
        int targetSum = 0;
        for (int num : nums){
            targetSum+=num;
        }
        int target = targetSum - x;
        if (target == 0){
            return nums.length;
        }
        if (target < 0){
            return -1;
        }

        int curSum = 0;
        int maxLen = -1;
        int start = 0;

        for (int end = 0; end < nums.length ; end++){
            curSum += nums[end];

            while (curSum > target && start <= end){
                curSum -= nums[start];
                start++;
            }

            if (curSum == target){
                int len = end - start + 1;
                maxLen = Math.max(maxLen, len);
            }
        }
        return (maxLen == -1) ? -1 : nums.length - maxLen;
    }
}