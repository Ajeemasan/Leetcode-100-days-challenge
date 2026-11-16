class Solution {
    public String digitSum(String s, int k) {
        while (s.length() > k){
            char[] ch = s.toCharArray();
            StringBuilder sb = new StringBuilder();
            int sum = 0;
            int len = 0;
            for (int i = 0; i < s.length() ; i++){
                if (i%k== 0 && i != 0){
                    sb.append(sum);
                    sum = s.charAt(i) - '0';
                    len = 1;
                }
                else{
                    sum += s.charAt(i) - '0';
                    len++;
                }
            }
            if (len <= k){
                sb.append(sum);
            }
            s = sb.toString();
        }
        return s;
    }
}