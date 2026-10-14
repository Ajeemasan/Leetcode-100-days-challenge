class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if (sum < 0 || num*9 < sum){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int nines = sum/9;
        while (nines > 0){
            sb.append('9');
            nines--;
        }
        int rem = sum %9;
        if (nines < num && rem > 0){
            sb.append(rem);
        }

        while (sb.length() < num){
            sb.append('0');
        }

        return sb.toString();
    }
}