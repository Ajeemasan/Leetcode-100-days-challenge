class Solution {
    public int[] resultArray(int[] nums) {
        int[] arr1 = new int[nums.length-1];
        int[] arr2 = new int[nums.length-1];
        int k1 = 0, k2 = 0;
        arr1[k1++] = nums[0];
        arr2[k2++] = nums[1];
        for (int i = 2;i < nums.length ; i++){
            if (arr1[k1-1] > arr2[k2-1]){
                arr1[k1++] = nums[i];
            }
            else{
                arr2[k2++] = nums[i];
            }
        }
        int[] res = new int[nums.length];
        int ind = 0;
        for (int i = 0;i < k1; i++){
            res[ind++] = arr1[i];
        }
        for (int i = 0;i < k2; i++){
            res[ind++] = arr2[i];
        }
        return res;
    }
}