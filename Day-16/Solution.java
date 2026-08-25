class Solution {
    public int missingMultiple(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums){
            if (num % k == 0){
                set.add(num);
            }
        }
        int i = 1;
        while (true){
            int cur = k*i ;
            if (!set.contains(cur)){
                return cur;
            }
            i++;
        }
    }
}