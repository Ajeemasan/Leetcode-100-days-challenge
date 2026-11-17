class Solution {
    public int minimumChanges(String s, int k) {
        int n = s.length();
        int INF = 10000;

        List<Integer>[] divisors = new ArrayList[n + 1];
        for (int len = 2; len <= n; len++) {
            divisors[len] = new ArrayList<>();
            for (int d = 1; d < len; d++) {
                if (len % d == 0) {
                    divisors[len].add(d);
                }
            }
        }

        int[][] cost = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(cost[i], INF);
            for (int j = i + 1; j < n; j++) {
                cost[i][j] = getCost(s, i, j, divisors[j - i + 1]);
            }
        }

        int[][] dp = new int[n + 1][k + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], INF);
        }
        dp[0][0] = 0;

        for (int parts = 1; parts <= k; parts++) {
            for (int i = parts * 2; i <= n; i++) {
                for (int p = (parts - 1) * 2; p <= i - 2; p++) {
                    if (dp[p][parts - 1] != INF) {
                        dp[i][parts] = Math.min(dp[i][parts], dp[p][parts - 1] + cost[p][i - 1]);
                    }
                }
            }
        }

        return dp[n][k];
    }

    private int getCost(String s, int i, int j, List<Integer> divs) {
        int minChanges = Integer.MAX_VALUE;

        for (int d : divs) {
            int changes = 0;

            for (int offset = 0; offset < d; offset++) {
                int left = i + offset;
                int right = j - (d - 1 - offset);
                while (left < right) {
                    if (s.charAt(left) != s.charAt(right)) {
                        changes++;
                    }
                    left += d;
                    right -= d;
                }
            }
            minChanges = Math.min(minChanges, changes);
        }

        return minChanges;
    }
}