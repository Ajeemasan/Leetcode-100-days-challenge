class Solution {

    int k;
    Node[] tree;

    class Node {
        int product;
        int[] count;

        Node() {
            product = 1 % k;
            count = new int[k];
        }
    }

    Node merge(Node left, Node right) {
        Node res = new Node();

        res.product = (left.product * right.product) % k;

        for (int x = 0; x < k; x++) {
            res.count[x] += left.count[x];
        }

        for (int x = 0; x < k; x++) {
            int newRemainder = (left.product * x) % k;
            res.count[newRemainder] += right.count[x];
        }

        return res;
    }

    void build(int node, int l, int r, int[] nums) {
        if (l == r) {
            int value = nums[l] % k;

            tree[node].product = value;
            tree[node].count[value] = 1;
            return;
        }

        int mid = (l + r) / 2;

        build(node * 2, l, mid, nums);
        build(node * 2 + 1, mid + 1, r, nums);

        tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
    }

    void update(int node, int l, int r, int index, int value) {
        if (l == r) {
            value %= k;

            tree[node] = new Node();
            tree[node].product = value;
            tree[node].count[value] = 1;

            return;
        }

        int mid = (l + r) / 2;

        if (index <= mid) {
            update(node * 2, l, mid, index, value);
        } else {
            update(node * 2 + 1, mid + 1, r, index, value);
        }

        tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
    }

    Node query(int node, int l, int r, int ql, int qr) {

        if (ql <= l && r <= qr) {
            return tree[node];
        }

        int mid = (l + r) / 2;

        if (qr <= mid) {
            return query(node * 2, l, mid, ql, qr);
        }

        if (ql > mid) {
            return query(node * 2 + 1, mid + 1, r, ql, qr);
        }

        Node left = query(node * 2, l, mid, ql, qr);
        Node right = query(node * 2 + 1, mid + 1, r, ql, qr);

        return merge(left, right);
    }

    public int[] resultArray(int[] nums, int k, int[][] queries) {

        this.k = k;

        int n = nums.length;

        tree = new Node[4 * n];

        for (int i = 0; i < tree.length; i++) {
            tree[i] = new Node();
        }

        build(1, 0, n - 1, nums);

        int[] answer = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            int index = queries[i][0];
            int value = queries[i][1];
            int start = queries[i][2];
            int x = queries[i][3];

            update(1, 0, n - 1, index, value);

            Node result = query(1, 0, n - 1, start, n - 1);
            answer[i] = result.count[x];
        }

        return answer;
    }
}