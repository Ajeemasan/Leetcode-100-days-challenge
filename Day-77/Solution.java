class Solution {
    boolean[][] visited;
    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        visited = new boolean[m][n];
        int ans = 0;

        for (int i = 0; i < m; i++){
            if (grid[i][0] == 0 && !visited[i][0]){
                dfs(grid, i, 0);
            }
            if (grid[i][n-1] == 0 && !visited[i][n-1]){
                dfs(grid, i, n-1);
            }
        }

        for (int i = 0; i < n; i++){
            if (grid[0][i] == 0 && !visited[0][i]){
                dfs(grid, 0, i);
            }
            if (grid[m-1][i] == 0 && !visited[m-1][i]){
                dfs(grid, m-1, i);
            }
        }

        for (int i = 1; i < m-1 ; i++){
            for (int j = 1; j < n-1; j++){
                if (grid[i][j] == 0 && !visited[i][j]){
                    ans++;
                    dfs(grid, i, j);
                }
            }
        }

        return ans;
    }

    public void dfs(int[][] grid, int row, int col){
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 1 || visited[row][col]){
            return;
        }
        visited[row][col] = true;
        dfs(grid, row-1, col);
        dfs(grid, row+1, col);
        dfs(grid, row, col-1);
        dfs(grid, row, col+1);
    }
}