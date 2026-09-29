class Solution {
    int[][][] dp;
    public boolean hasValidPath(char[][] grid) {
        dp = new int[grid.length][grid[0].length][grid.length+grid[0].length+1];
        return isValid(grid, 0, 0, 0);
    }
    public boolean isValid (char[][] grid, int row, int col, int open){
        if (row == grid.length || col == grid[0].length){
            return false;
        }
        char ch = grid[row][col];
        if (ch == '('){
            open++;
        }
        else{
            open--;
        }

        if (open < 0){
            return false;
        }
        if (row == grid.length-1 && col == grid[0].length - 1 && open == 0){
            return true;
        }

        if (dp[row][col][open] != 0){
            return (dp[row][col][open]) == 1 ? true : false;
        }


        if (isValid(grid, row+1, col, open) || isValid(grid, row, col+1, open)){
            dp[row][col][open] = 1;
        }
        else{
            dp[row][col][open] = 2;
        }
        return (dp[row][col][open] == 1) ? true : false;
    }
}