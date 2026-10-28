class Solution {
    private int[][][] dp;
    private static final int MAX_XOR = 1024;

    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        dp = new int[m][n][MAX_XOR];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return path(grid, 0, 0, 0);
    }

    public int path(int[][] grid, int row, int col, int currentXor) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
            return Integer.MAX_VALUE;
        }

        int nextXor = currentXor ^ grid[row][col];

        if (row == grid.length - 1 && col == grid[0].length - 1) {
            return nextXor;
        }

        if (dp[row][col][currentXor] != -1) {
            return dp[row][col][currentXor];
        }

        int p1 = path(grid, row + 1, col, nextXor);
        int p2 = path(grid, row, col + 1, nextXor);

        return dp[row][col][currentXor] = Math.min(p1, p2);
    }
}