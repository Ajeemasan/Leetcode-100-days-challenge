class Solution {
    public String[] createGrid(int m, int n) {
        if (m == 0 || n == 0){
            return null;
        }

        String[] grid = new String[m];

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m ; i++){
            for (int j = 0; j < n; j++){
                if (i == 0 || j == n-1){
                    sb.append('.');
                }
                else{
                    sb.append('#');
                }
            }
            grid[i] = sb.toString();
            sb.setLength(0);
        }
        return grid;
    }
}