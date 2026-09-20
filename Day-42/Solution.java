class Solution {
    public int reverseDegree(String s) {
        int degree = 0;
        int n = s.length();
        int[] val = new int[26];
        int value = 26;
        for (int i = 0; i < 26 ; i++){
            val[i] = value--;
        }
        for (int i = 0; i < n ; i++){
            degree += (val[s.charAt(i)-'a']*(i+1));
        }
        return degree;
    }
}