class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        List<int[]> list1 = new ArrayList<>();
        List<int[]> list2 = new ArrayList<>();
        for (int i = 0; i < n ; i++){
            for (int j = 0; j < n ; j++){
                if (img1[i][j] == 1){
                    list1.add(new int[]{i, j});
                }
                if (img2[i][j] == 1){
                    list2.add(new int[]{i, j});
                }
            }
        }
        int[][] shiftCounts = new int[2*n][2*n];
        int ans = 0;
        for (int[] arr1 : list1){
            for (int[] arr2 : list2){
                int rows = arr2[0] - arr1[0] + n - 1;
                int cols = arr2[1] - arr1[1] + n -1;

                shiftCounts[rows][cols]++;

                ans = Math.max(ans, shiftCounts[rows][cols]);
            }
        }
        return ans;
    }
}
