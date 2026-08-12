class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> ref = new HashMap<>();
        for (int i = 0 ; i < nums.length ; i++){
            if (map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i]) + 1);
            }
            else{
                map.put(nums[i], 1);
                ref.put(nums[i], 0);
            }
        }
        int ans = 0;
        int cur = 0;
        int i = 0, j = 0;
        while (i < nums.length && j < nums.length){
            if (i > j){
                j = i;
                continue;
            }
            if (ref.get(nums[j]) < k){
                ref.put(nums[j], ref.get(nums[j]) + 1);
                j++;
                cur++;

            }
            else{
                ref.put(nums[i], ref.get(nums[i]) - 1);
                i++;
                ans = Math.max(cur, ans);
                cur --;
            }
        }
        ans = Math.max(cur, ans);
        return ans;
    }
}