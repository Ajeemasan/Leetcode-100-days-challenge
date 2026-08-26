class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int i = 0;
        int onesCount = 0;

        int minLen = Integer.MAX_VALUE;
        int start = -1;

        for (int j = 0; j < s.length(); j++) {

            if (s.charAt(j) == '1') {
                onesCount++;
            }

            while (onesCount == k) {

                int len = j - i + 1;

                if (len < minLen || (len == minLen &&s.substring(i, j + 1).compareTo(s.substring(start, start + minLen)) < 0)) {

                    minLen = len;
                    start = i;
                }

                if (s.charAt(i) == '1') {
                    onesCount--;
                }

                i++;
            }
        }

        if (start == -1) {
            return "";
        }

        return s.substring(start, start + minLen);
    }
}