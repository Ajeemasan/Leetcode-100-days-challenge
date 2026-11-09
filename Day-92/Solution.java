class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        PriorityQueue<int[]> busy = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        TreeSet<Integer> idle = new TreeSet<>();
        for (int i = 0; i < k; i++) {
            idle.add(i);
        }

        int[] requestsHandled = new int[k];
        int maxHandled = 0;

        for (int i = 0; i < arrival.length; i++) {
            int currTime = arrival[i];

            while (!busy.isEmpty() && busy.peek()[0] <= currTime) {
                idle.add(busy.poll()[1]);
            }

            if (idle.isEmpty()) {
                continue;
            }

            int preferred = i % k;
            Integer server = idle.ceiling(preferred);

            if (server == null) {
                server = idle.ceiling(0);
            }

            idle.remove(server);
            busy.offer(new int[] { currTime + load[i], server });
            requestsHandled[server]++;
            maxHandled = Math.max(maxHandled, requestsHandled[server]);
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (requestsHandled[i] == maxHandled) {
                result.add(i);
            }
        }

        return result;
    }
}