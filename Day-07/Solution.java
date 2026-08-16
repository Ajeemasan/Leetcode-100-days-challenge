class Solution {
    public boolean stoneGameIX(int[] stones) {
        int[] rem = new int[3];
        for (int num : stones){
            if (num % 3 == 0){
                rem[0]++;
            }
            if (num % 3 == 1){
                rem[1]++;
            }
            if (num % 3 == 2){
                rem[2]++;
            }
        }
        if (rem[0] % 2 == 0){
            return (rem[1] > 0) && (rem[2] > 0);
        }
        return Math.abs(rem[1] - rem[2]) > 2;
    }
}