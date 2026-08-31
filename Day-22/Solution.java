class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int first = -1;
        int last = -1;
        int prevCritical = -1;
        int minDistance = Integer.MAX_VALUE;

        int pos = 1;
        int prev = head.val;
        ListNode cur = head.next;

        while (cur.next != null) {
            int curr = cur.val;
            int next = cur.next.val;

            boolean critical = (curr > prev && curr > next) ||
                    (curr < prev && curr < next);

            if (critical) {
                if (first == -1) {
                    first = pos;
                }

                if (prevCritical != -1) {
                    minDistance = Math.min(
                            minDistance,
                            pos - prevCritical
                    );
                }

                prevCritical = pos;
                last = pos;
            }

            prev = curr;
            cur = cur.next;
            pos++;
        }

        if (first == -1 || first == last) {
            return new int[]{-1, -1};
        }

        int maxDistance = last - first;

        return new int[]{minDistance, maxDistance};
    }
}