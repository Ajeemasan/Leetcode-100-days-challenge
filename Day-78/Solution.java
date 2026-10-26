class Solution {
    public int countIslands(int[][] grid, int k) {
        int ans = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0;i < m; i++){
            for (int j = 0; j < n; j++){
                if (grid[i][j] != 0){
                    ans = (dfs(grid, i, j) % k == 0) ? ans+1 : ans;
                }
            }
        }
        return ans;
    }
    public long dfs (int[][] grid, int row, int col){
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 0){
            return 0;
        }

        long count = grid[row][col];
        grid[row][col] = 0;
        count += dfs (grid, row-1, col);
        count += dfs (grid, row+1, col);
        count += dfs (grid, row, col-1);
        count += dfs (grid, row, col+1);

        return count;
    }
}