class Solution {
    public int largestInteger(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int j = k -1;
        int s = 0;
        Set<Integer> set = new HashSet<>();
        while (j < nums.length){
            for (int i = s; i <= j ; i++){
                if (set.contains(nums[i])){
                    continue;
                }
                else if (map.containsKey(nums[i])){
                    map.put(nums[i], map.get(nums[i]) + 1);
                }
                else{
                    set.add(nums[i]);
                    map.put(nums[i], 1);
                }
            }
            set.clear();
            s++;
            j++;
        }
        int ans = -1;
        for (int num : map.keySet()){
            if (map.get(num) == 1){
                ans = Math.max(ans, num);
            }
        }
        return ans;
    }
}