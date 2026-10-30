class Solution {
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];
            graph[u].add(new int[]{v, weight});
        }

        int[][] dist = new int[n][k + 1];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        dist[0][1] = 0;
        pq.offer(new int[]{0, 0, 1});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int cost = current[0];
            int u = current[1];
            int c = current[2];

            if (cost > dist[u][c]) {
                continue;
            }


            if (u == n - 1) {
                return cost;
            }

            for (int[] neighbor : graph[u]) {
                int v = neighbor[0];
                int weight = neighbor[1];

                int nextC = (labels.charAt(u) == labels.charAt(v)) ? c + 1 : 1;

                if (nextC <= k) {
                    if (cost + weight < dist[v][nextC]) {
                        dist[v][nextC] = cost + weight;
                        pq.offer(new int[]{cost + weight, v, nextC});
                    }
                }
            }
        }

        return -1;
    }
}