class Solution {
    public boolean checkDivisibility(int n) {
        int digitsSum = 0;
        int digitsProduct = 1;
        int t = n;
        while (t > 0){
            digitsSum += t%10;
            digitsProduct *= t%10;
            t/=10;
        }
        return ((n%(digitsSum + digitsProduct) == 0));
    }
}