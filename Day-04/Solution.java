class Solution {

    class Node {
        char leftChar;
        char rightChar;

        int prefix;
        int suffix;
        int best;
        int length;

        Node() {}

        Node(char leftChar, char rightChar,
             int prefix, int suffix,
             int best, int length) {

            this.leftChar = leftChar;
            this.rightChar = rightChar;
            this.prefix = prefix;
            this.suffix = suffix;
            this.best = best;
            this.length = length;
        }
    }

    Node[] tree;
    char[] arr;

    public int[] longestRepeating(
            String s,
            String queryCharacters,
            int[] queryIndices) {

        arr = s.toCharArray();

        int n = arr.length;

        tree = new Node[4 * n];

        build(1, 0, n - 1);

        int[] ans = new int[queryIndices.length];

        for (int i = 0; i < queryIndices.length; i++) {

            int index = queryIndices[i];
            char ch = queryCharacters.charAt(i);

            arr[index] = ch;

            update(1, 0, n - 1, index, ch);

            ans[i] = tree[1].best;
        }

        return ans;
    }

    // Build the segment tree
    private void build(int node, int l, int r) {

        // Leaf
        if (l == r) {

            tree[node] = new Node(
                    arr[l],
                    arr[l],
                    1,
                    1,
                    1,
                    1
            );

            return;
        }

        int mid = l + (r - l) / 2;

        build(node * 2, l, mid);

        build(node * 2 + 1, mid + 1, r);

        tree[node] = merge(
                tree[node * 2],
                tree[node * 2 + 1]
        );
    }

    // Update one position
    private void update(
            int node,
            int l,
            int r,
            int index,
            char ch) {

        // Leaf
        if (l == r) {

            tree[node] = new Node(
                    ch,
                    ch,
                    1,
                    1,
                    1,
                    1
            );

            return;
        }

        int mid = l + (r - l) / 2;

        if (index <= mid) {

            update(
                    node * 2,
                    l,
                    mid,
                    index,
                    ch
            );

        } else {

            update(
                    node * 2 + 1,
                    mid + 1,
                    r,
                    index,
                    ch
            );
        }

        // Recalculate current node
        tree[node] = merge(
                tree[node * 2],
                tree[node * 2 + 1]
        );
    }

    // Merge two adjacent segments
    private Node merge(Node left, Node right) {

        Node result = new Node();

        result.leftChar = left.leftChar;
        result.rightChar = right.rightChar;

        result.length = left.length + right.length;

        // Prefix
        result.prefix = left.prefix;

        if (left.prefix == left.length &&
                left.rightChar == right.leftChar) {

            result.prefix =
                    left.length + right.prefix;
        }

        // Suffix
        result.suffix = right.suffix;

        if (right.suffix == right.length &&
                left.rightChar == right.leftChar) {

            result.suffix =
                    right.length + left.suffix;
        }

        // Best inside either side
        result.best = Math.max(
                left.best,
                right.best
        );

        // Best crossing the boundary
        if (left.rightChar == right.leftChar) {

            result.best = Math.max(
                    result.best,
                    left.suffix + right.prefix
            );
        }

        return result;
    }
}