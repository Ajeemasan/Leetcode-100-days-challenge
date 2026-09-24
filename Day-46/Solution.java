class Solution {
    public int smallestIndex(int[] nums) {
        for (int i = 0; i < nums.length ; i++){
            int sum = digitSum(nums[i]);
            if (sum == i){
                return i;
            }
        }
        return -1;
    }
    public int digitSum(int num){
        int sum = 0;
        while (num > 0){
            int last = num%10;
            sum += last;
            num /= 10;
        }
        return sum;
    }
}