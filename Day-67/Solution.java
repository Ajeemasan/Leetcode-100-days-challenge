class Solution {
    public int sumCounts(List<Integer> nums) {
        int totalSum = 0;
        int n = nums.size();
        Set<Integer> distinctElements = new HashSet<>();

        for (int i = 0; i < n; i++) {


            for (int j = i; j < n; j++) {
                distinctElements.add(nums.get(j));

                int distinctCount = distinctElements.size();

                totalSum += distinctCount * distinctCount;
            }

            distinctElements.clear();
        }

        return totalSum;
    }
}