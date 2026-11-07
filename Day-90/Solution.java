public class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        int m = tasks.length;
        int[] ans = new int[m];

        PriorityQueue<int[]> idle = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });

        for (int i = 0; i < servers.length; i++) {
            idle.offer(new int[]{servers[i], i});
        }

        PriorityQueue<int[]> busy = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            if (a[1] != b[1]) return Integer.compare(a[1], b[1]);
            return Integer.compare(a[2], b[2]);
        });

        int currentTime = 0;

        for (int j = 0; j < m; j++) {
            currentTime = Math.max(currentTime, j);

            while (!busy.isEmpty() && busy.peek()[0] <= currentTime) {
                int[] server = busy.poll();
                idle.offer(new int[]{server[1], server[2]}); // weight, index
            }

            if (idle.isEmpty()) {
                currentTime = busy.peek()[0];
                while (!busy.isEmpty() && busy.peek()[0] <= currentTime) {
                    int[] server = busy.poll();
                    idle.offer(new int[]{server[1], server[2]});
                }
            }


            int[] bestServer = idle.poll();
            int weight = bestServer[0];
            int index = bestServer[1];
            ans[j] = index;


            busy.offer(new int[]{currentTime + tasks[j], weight, index});
        }

        return ans;
    }
}
