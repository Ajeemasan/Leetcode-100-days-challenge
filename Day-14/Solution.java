class Solution {
    public boolean sumGame(String num) {
        int q1 = 0, q2 = 0;
        int s1 = 0, s2 = 0;
        int mid = num.length() / 2;
        for (int i = 0; i < mid ; i++){
            if (num.charAt(i) == '?'){
                q1++;
            }
            else{
                s1 += (int)(num.charAt(i) - '0');
            }
        }
        for (int i = mid; i < num.length() ; i++){
            if (num.charAt(i) == '?'){
                q2++;
            }
            else{
                s2 += (int)(num.charAt(i) - '0');
            }
        }
        if ((q1 + q2) % 2 == 1){
            return true;
        }
        return 2*(s1 - s2) != (q2 - q1)*9;
    }
}