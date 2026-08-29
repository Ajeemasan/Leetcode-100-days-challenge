class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;

        // Step 1: Pair each number with its original index
        int[][] indexedNums = new int[n][2];
        for (int i = 0; i < n; i++) {
            indexedNums[i][0] = nums[i]; // value
            indexedNums[i][1] = i;       // original index
        }

        // Step 2: Sort based on the values
        Arrays.sort(indexedNums, (a, b) -> Integer.compare(a[0], b[0]));

        int[] ans = new int[n];

        // Step 3: Identify groups and sort their indices
        int i = 0;
        while (i < n) {
            int j = i + 1;
            // Find all elements that belong to the current group
            while (j < n && indexedNums[j][0] - indexedNums[j - 1][0] <= limit) {
                j++;
            }

            // Extract the original indices for this group
            int[] indicesGroup = new int[j - i];
            for (int k = i; k < j; k++) {
                indicesGroup[k - i] = indexedNums[k][1];
            }

            // Sort the indices to place values back in the earliest possible spots
            Arrays.sort(indicesGroup);

            // Step 4: Map the sorted values to the sorted indices
            for (int k = i; k < j; k++) {
                ans[indicesGroup[k - i]] = indexedNums[k][0];
            }

            // Move to the next group
            i = j;
        }

        return ans;
    }
}
