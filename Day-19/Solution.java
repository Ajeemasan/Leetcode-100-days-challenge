class Solution {
    public String lexPalindromicPermutation(String s, String target) {
        int n = s.length();
        int halfLen = n / 2;

        // 1. Compute frequency table
        int[] cnt = new int[26];
        for (int i = 0; i < n; i++) {
            cnt[s.charAt(i) - 'a']++;
        }

        // 2. Palindrome integrity validation
        int oddChar = -1;
        for (int i = 0; i < 26; i++) {
            if (cnt[i] % 2 == 1) {
                if (oddChar != -1) return ""; // More than one odd frequency character
                oddChar = i;
            }
        }

        // 3. Populate frequency budget for the left half mirror
        int[] leftCnt = new int[26];
        for (int i = 0; i < 26; i++) {
            leftCnt[i] = cnt[i] / 2;
        }

        int[] left = new int[halfLen];
        int[] remain = leftCnt.clone();
        boolean isMatched = true;

        // 4. Try matching the target prefix exactly for the first half
        for (int i = 0; i < halfLen; i++) {
            int targetIdx = target.charAt(i) - 'a';
            if (remain[targetIdx] > 0) {
                left[i] = targetIdx;
                remain[targetIdx]--;
            } else {
                // Cannot match the target prefix exactly, mark match boundary
                isMatched = false;

                // Find the absolute smallest character greater than target[i]
                int nextGreater = -1;
                for (int c = targetIdx + 1; c < 26; c++) {
                    if (remain[c] > 0) {
                        nextGreater = c;
                        break;
                    }
                }

                if (nextGreater != -1) {
                    left[i] = nextGreater;
                    remain[nextGreater]--;
                    // Fill everything remaining with the absolute lowest available chars
                    fillSmallest(left, remain, i + 1, halfLen);
                    return constructPalindrome(left, oddChar);
                } else {
                    // Cannot find any character greater at this point, must trigger right-to-left rollback
                    return rollback(left, remain, target, i - 1, oddChar);
                }
            }
        }

        // 5. If first half perfectly matched, construct complete string to verify the remaining tail
        if (isMatched) {
            String candidate = constructPalindrome(left, oddChar);
            if (candidate.compareTo(target) > 0) {
                return candidate;
            }
            // Tail was not strictly greater, trigger right-to-left rollback from the end of the half string
            return rollback(left, remain, target, halfLen - 1, oddChar);
        }

        return "";
    }

    // Helper to safely pop up a character from right-to-left when standard prefix matching breaks
    private String rollback(int[] left, int[] remain, String target, int startIdx, int oddChar) {
        for (int i = startIdx; i >= 0; i--) {
            int currentVal = left[i];
            remain[currentVal]++; // Reclaim used char to pool

            int targetIdx = target.charAt(i) - 'a';
            int nextGreater = -1;
            for (int c = currentVal + 1; c < 26; c++) {
                if (remain[c] > 0) {
                    nextGreater = c;
                    break;
                }
            }

            if (nextGreater != -1) {
                left[i] = nextGreater;
                remain[nextGreater]--;
                fillSmallest(left, remain, i + 1, left.length);
                return constructPalindrome(left, oddChar);
            }
        }
        return "";
    }

    // Greedily flattens out structural choices to the smallest alphabetical items
    private void fillSmallest(int[] left, int[] remain, int start, int end) {
        int charIdx = 0;
        for (int i = start; i < end; i++) {
            while (charIdx < 26 && remain[charIdx] == 0) {
                charIdx++;
            }
            left[i] = charIdx;
            remain[charIdx]--;
        }
    }

    // Assembles left array, odd character (if present), and the mirror right array into a single String
    private String constructPalindrome(int[] left, int oddChar) {
        StringBuilder sb = new StringBuilder();
        for (int val : left) {
            sb.append((char) ('a' + val));
        }
        String firstHalf = sb.toString();
        String secondHalf = new StringBuilder(firstHalf).reverse().toString();
        if (oddChar != -1) {
            return firstHalf + (char) ('a' + oddChar) + secondHalf;
        }
        return firstHalf + secondHalf;
    }
}
