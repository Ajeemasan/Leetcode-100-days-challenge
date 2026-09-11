class Solution {
    public int totalNumbers(int[] digits) {
        Set<Integer> uniqueNumbers = new HashSet<>();
        int n = digits.length;

        // Enumerate all combinations of three distinct indices (i, j, k)
        for (int i = 0; i < n; i++) {
            // Hundreds place cannot have leading zero
            if (digits[i] == 0) continue;

            for (int j = 0; j < n; j++) {
                if (i == j) continue;

                for (int k = 0; k < n; k++) {
                    if (k == i || k == j) continue;

                    int onesDigit = digits[k];
                    // Ones place must be even
                    if (onesDigit % 2 != 0) continue;

                    int num = digits[i] * 100 + digits[j] * 10 + onesDigit;
                    uniqueNumbers.add(num);
                }
            }
        }

        return uniqueNumbers.size();
    }
}