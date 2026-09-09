class Solution {
    public long countCommas(long n) {
        long totalCommas = 0;

        if (n >= 1_000L)          totalCommas += (n - 1_000L + 1);
        if (n >= 1_000_000L)      totalCommas += (n - 1_000_000L + 1);
        if (n >= 1_000_000_000L)  totalCommas += (n - 1_000_000_000L + 1);
        if (n >= 1_000_000_000_000L)     totalCommas += (n - 1_000_000_000_000L + 1);
        if (n >= 1_000_000_000_000_000L) totalCommas += (n - 1_000_000_000_000_000L + 1);

        return totalCommas;
    }
}