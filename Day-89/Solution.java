class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        int m = queries.length;
        int[] ans = new int[m];

        Integer[] qIndices = new Integer[m];
        for (int i = 0; i < m; i++) {
            qIndices[i] = i;
        }

        Arrays.sort(qIndices, (a, b) -> Integer.compare(queries[a], queries[b]));

        Arrays.sort(logs, (a, b) -> Integer.compare(a[1], b[1]));

        int[] serverCount = new int[n + 1];
        int activeServers = 0;
        int i = 0;
        int j = 0;
        int L = logs.length;

        for (int qIdx : qIndices) {
            int queryTime = queries[qIdx];
            int leftWindow = queryTime - x;


            while (j < L && logs[j][1] <= queryTime) {
                int serverId = logs[j][0];
                if (serverCount[serverId] == 0) {
                    activeServers++;
                }
                serverCount[serverId]++;
                j++;
            }

            while (i < L && logs[i][1] < leftWindow) {
                int serverId = logs[i][0];
                serverCount[serverId]--;
                if (serverCount[serverId] == 0) {
                    activeServers--;
                }
                i++;
            }

            ans[qIdx] = n - activeServers;
        }

        return ans;
    }
}