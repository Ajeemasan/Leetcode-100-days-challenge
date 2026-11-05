class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int n1 = arr1.length;
        int n2 = arr2.length;
        int ans = 0;

        for (int i = 0; i < n1; i++){
            boolean flag = true;
            for (int j = 0; j < n2; j++){
                if (Math.abs(arr1[i] - arr2[j]) <= d){
                    flag = false;
                    break;
                }
            }
            if (flag){
                ans++;
            }
        }
        return ans;
    }
}