class Solution {
    private int n;
    private List<Integer>[] adj;
    private int[][] up;
    private int[] depth;
    private int[] tin;
    private int[] tout;
    private int timer;
    private int LOG;

    private static class FenwickTree {
        int size;
        int[] tree;

        FenwickTree(int n) {
            this.size = n;
            this.tree = new int[n + 2];
        }
        public void add(int i, int val) {
            i++;
            while (i <= size + 1) {
                tree[i] ^= val;
                i += i & -i;
            }
        }

        public void updateRange(int l, int r, int val) {
            add(l, val);
            add(r + 1, val);
        }


        public int query(int i) {
            i++;
            int sum = 0;
            while (i > 0) {
                sum ^= tree[i];
                i -= i & -i;
            }
            return sum;
        }
    }

    public List<Boolean> palindromePath(int n, int[][] edges, String s, String[] queries) {
        this.n = n;
        this.LOG = (int) (Math.log(n) / Math.log(2)) + 1;

        adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        up = new int[n][LOG];
        depth = new int[n];
        tin = new int[n];
        tout = new int[n];
        timer = 0;


        dfs(0, 0, 0);

        int[] initialRootMasks = new int[n];
        char[] currentChars = s.toCharArray();
        computeInitialMasks(0, 0, 0, currentChars, initialRootMasks);

        FenwickTree ft = new FenwickTree(n);
        for (int i = 0; i < n; i++) {
            ft.updateRange(tin[i], tin[i], initialRootMasks[i]);
        }

        List<Boolean> result = new ArrayList<>();

        for (String q : queries) {
            String[] parts = q.split(" ");
            if (parts[0].equals("update")) {
                int node = Integer.parseInt(parts[1]);
                char newChar = parts[2].charAt(0);

                char oldChar = currentChars[node];
                if (oldChar != newChar) {
                    int changeMask = (1 << (oldChar - 'a')) ^ (1 << (newChar - 'a'));
                    ft.updateRange(tin[node], tout[node], changeMask);
                    currentChars[node] = newChar;
                }
            } else {
                int u = Integer.parseInt(parts[1]);
                int v = Integer.parseInt(parts[2]);

                int lcaNode = getLCA(u, v);
                int maskU = ft.query(tin[u]);
                int maskV = ft.query(tin[v]);
                int maskLCAChar = 1 << (currentChars[lcaNode] - 'a');


                int pathMask = maskU ^ maskV ^ maskLCAChar;


                boolean canFormPalindrome = (pathMask & (pathMask - 1)) == 0;
                result.add(canFormPalindrome);
            }
        }

        return result;
    }

    private void dfs(int node, int p, int d) {
        tin[node] = timer++;
        depth[node] = d;
        up[node][0] = p;

        for (int i = 1; i < LOG; i++) {
            up[node][i] = up[up[node][i - 1]][i - 1];
        }

        for (int neighbor : adj[node]) {
            if (neighbor != p) {
                dfs(neighbor, node, d + 1);
            }
        }
        tout[node] = timer - 1;
    }

    private void computeInitialMasks(int node, int p, int currentMask, char[] chars, int[] initialRootMasks) {
        currentMask ^= (1 << (chars[node] - 'a'));
        initialRootMasks[node] = currentMask;

        for (int neighbor : adj[node]) {
            if (neighbor != p) {
                computeInitialMasks(neighbor, node, currentMask, chars, initialRootMasks);
            }
        }
    }

    private int getLCA(int u, int v) {
        if (depth[u] < depth[v]) {
            int temp = u; u = v; v = temp;
        }


        for (int i = LOG - 1; i >= 0; i--) {
            if (depth[u] - (1 << i) >= depth[v]) {
                u = up[u][i];
            }
        }

        if (u == v) return u;

        for (int i = LOG - 1; i >= 0; i--) {
            if (up[u][i] != up[v][i]) {
                u = up[u][i];
                v = up[v][i];
            }
        }

        return up[u][0];
    }
}