class Solution {
    private int m;
    private int n;
    private int[][] grid;
    private int[][] memo;
    private final int MOD = 1_000_000_007;

    public int uniquePaths(int[][] grid) {
        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length;

        this.memo = new int[m][n];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return count(0, 0);
    }

    private int count(int r, int c) {
        if (r == m - 1 && c == n - 1) {
            return 1;
        }

        if (memo[r][c] != -1) {
            return memo[r][c];
        }

        long totalPaths = 0;

        int[] nextRight = getNext(r, c, 0);
        if (nextRight != null) {
            totalPaths = (totalPaths + count(nextRight[0], nextRight[1])) % MOD;
        }

        int[] nextDown = getNext(r, c, 1);
        if (nextDown != null) {
            totalPaths = (totalPaths + count(nextDown[0], nextDown[1])) % MOD;
        }

        memo[r][c] = (int) totalPaths;
        return memo[r][c];
    }

    private int[] getNext(int r, int c, int d) {
        int tr = (d == 0) ? r : r + 1;
        int tc = (d == 0) ? c + 1 : c;
        int currD = d;

        while (tr >= 0 && tr < m && tc >= 0 && tc < n) {
            if (tr == m - 1 && tc == n - 1) {
                return new int[]{tr, tc};
            }

            if (grid[tr][tc] == 0) {
                return new int[]{tr, tc};
            }

            if (currD == 0) {
                tr = tr + 1;
                currD = 1;
            } else {
                tc = tc + 1;
                currD = 0;
            }
        }


        return null;
    }
}
