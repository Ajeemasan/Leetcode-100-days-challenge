class Solution {
    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length, n = classroom[0].length();
        char[][] grid = new char[m][n];
        for (int i = 0; i < m; i++) grid[i] = classroom[i].toCharArray();

        int sr = -1, sc = -1;
        int[][] litterBit = new int[m][n];
        for (int[] row : litterBit) Arrays.fill(row, -1);
        int L = 0;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'S') { sr = i; sc = j; }
                else if (grid[i][j] == 'L') litterBit[i][j] = L++;
            }

        int fullMask = (1 << L) - 1;
        int maskCount = 1 << L;
        int E = energy;

        // state index = ((r*n+c)*(E+1) + e) * maskCount + mask
        boolean[] visited = new boolean[m * n * (E + 1) * maskCount];

        int startMask = 0; // S is never an L cell per constraints
        if (startMask == fullMask) return 0; // no litter at all

        int[] dr = {1, -1, 0, 0}, dc = {0, 0, 1, -1};
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{sr, sc, energy, startMask});
        visited[idx(sr, sc, energy, startMask, n, E, maskCount)] = true;

        int moves = 0;
        while (!queue.isEmpty()) {
            moves++;
            for (int sz = queue.size(); sz > 0; sz--) {
                int[] cur = queue.poll();
                int r = cur[0], c = cur[1], e = cur[2], mask = cur[3];
                if (e == 0) continue; // stuck (not on R, per invariant)

                for (int d = 0; d < 4; d++) {
                    int nr = r + dr[d], nc = c + dc[d];
                    if (nr < 0 || nr >= m || nc < 0 || nc >= n) continue;
                    char ch = grid[nr][nc];
                    if (ch == 'X') continue;

                    int ne = (ch == 'R') ? energy : e - 1;
                    int nmask = mask;
                    if (litterBit[nr][nc] != -1) nmask |= (1 << litterBit[nr][nc]);

                    if (nmask == fullMask) return moves;

                    int nidx = idx(nr, nc, ne, nmask, n, E, maskCount);
                    if (!visited[nidx]) {
                        visited[nidx] = true;
                        queue.add(new int[]{nr, nc, ne, nmask});
                    }
                }
            }
        }
        return -1;
    }

    private int idx(int r, int c, int e, int mask, int n, int E, int maskCount) {
        return (((r * n + c) * (E + 1)) + e) * maskCount + mask;
    }
}
