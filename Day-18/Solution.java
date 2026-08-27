class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();
        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        for (char c : target.toCharArray()) {
            freq[c - 'a']--;
        }
        for (int i = n - 1; i >= 0; i--) {
            freq[target.charAt(i) - 'a']++;

            if (isValidPrefix(freq)) {
                for (int j = (target.charAt(i) - 'a') + 1; j < 26; j++) {
                    if (freq[j] > 0) {
                        StringBuilder ans = new StringBuilder();

                        ans.append(target.substring(0, i));

                        ans.append((char) (j + 'a'));
                        freq[j]--;

                        for (int k = 0; k < 26; k++) {
                            while (freq[k] > 0) {
                                ans.append((char) (k + 'a'));
                                freq[k]--;
                            }
                        }
                        return ans.toString();
                    }
                }
            }
        }

        return "";
    }
    private boolean isValidPrefix(int[] freq) {
        for (int f : freq) {
            if (f < 0) return false;
        }
        return true;
    }
}
