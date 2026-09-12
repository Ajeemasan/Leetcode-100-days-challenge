public class Solution {
    static class State {
        long weight;
        List<Integer> indices;

        State(long weight, List<Integer> indices) {
            this.weight = weight;
            this.indices = indices;
        }
    }

    static class Interval {
        int start, end, weight, id;

        Interval(int start, int end, int weight, int id) {
            this.start = start;
            this.end = end;
            this.weight = weight;
            this.id = id;
        }
    }

    public int[] maximumWeight(List<List<Integer>> intervalsList) {
        int n = intervalsList.size();
        Interval[] intervals = new Interval[n];
        for (int i = 0; i < n; i++) {
            intervals[i] = new Interval(
                    intervalsList.get(i).get(0),
                    intervalsList.get(i).get(1),
                    intervalsList.get(i).get(2),
                    i
            );
        }

        Arrays.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));

        State[][] dp = new State[n + 1][5];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= 4; j++) {
                dp[i][j] = new State(0, new ArrayList<>());
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            int nextIdx = findNextNonOverlapping(intervals, intervals[i].end, i + 1);

            for (int j = 1; j <= 4; j++) {
                State skipState = dp[i + 1][j];

                State nextState = dp[nextIdx][j - 1];
                long takeWeight = intervals[i].weight + nextState.weight;

                List<Integer> takeIndices = new ArrayList<>();
                takeIndices.add(intervals[i].id);
                takeIndices.addAll(nextState.indices);
                Collections.sort(takeIndices);
                State takeState = new State(takeWeight, takeIndices);

                dp[i][j] = getBetterState(skipState, takeState);
            }
        }

        List<Integer> resultList = dp[0][4].indices;
        int[] result = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }
        return result;
    }

    private int findNextNonOverlapping(Interval[] intervals, int currentEnd, int startIdx) {
        int low = startIdx;
        int high = intervals.length - 1;
        int ans = intervals.length;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (intervals[mid].start > currentEnd) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
    private State getBetterState(State s1, State s2) {
        if (s1.weight != s2.weight) {
            return s1.weight > s2.weight ? s1 : s2;
        }

        int len1 = s1.indices.size();
        int len2 = s2.indices.size();
        int minLen = Math.min(len1, len2);

        for (int i = 0; i < minLen; i++) {
            int idx1 = s1.indices.get(i);
            int idx2 = s2.indices.get(i);
            if (idx1 != idx2) {
                return idx1 < idx2 ? s1 : s2;
            }
        }

        return len1 <= len2 ? s1 : s2;
    }
}
