class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (num < target){
                count++;
            }
        }
        List<Integer> list = new ArrayList<>();
        while (map.containsKey(target) && map.get(target) > 0){
            list.add(count++);
            map.put(target, map.get(target) - 1);
        }
        return list;
    }
}