import java.util.*;
class Solution {
    public int missingInteger(int[] nums) {
        if (nums.length == 1){
            return nums[0] + 1;
        }
        int prev = nums[0];
        int cur = nums[0];
        int prefix = nums[0];
        int f = 0;
        for (int i = 1; i < nums.length ; i++){
            if (f == 1) break;
            if (nums[i] == prev + 1){
                cur += nums[i];
            }
            else{
                prefix = Math.max(prefix, cur);
                cur = nums[i];
                f = 1;
            }
            prev = nums[i];
        }
        if (f != 1){
            prefix = Math.max(prefix, cur);
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0 ; i < nums.length ; i++){
            list.add(nums[i]);
        }
        int ans = prefix;
        for (ans = prefix; ans < Integer.MAX_VALUE ; ans++){
            if (!list.contains(ans)){
                return ans;
            }
        }
        return ans;
    }
}