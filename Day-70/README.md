# Day 70 — Number of Ways to Reorder Array to Get Same BST

**LeetCode:** [1569. Number of Ways to Reorder Array to Get Same BST](https://leetcode.com/problems/number-of-ways-to-reorder-array-to-get-same-bst/)

**Difficulty:** Hard

**Topic:** Binary Search Tree, Recursion, Dynamic Programming, Combinatorics

## 🧠 Intuition

The goal is to count how many reorderings of the array produce the same binary search tree (BST) as the original ordering, excluding the original arrangement.

The first element always becomes the root. The remaining elements are divided into left and right subtrees according to their values.

To preserve the same BST, the relative order of elements within each subtree must remain valid, but elements from the left and right subtrees can be interleaved. Binomial coefficients count the ways to choose the positions occupied by the left-subtree elements.

## 🔄 Approach

1. Precompute Pascal's triangle in `table`, where `table[i][j]` stores the binomial coefficient \(\binom{i}{j}\) modulo \(10^9 + 7\).
2. Convert the input array into a list and recursively process it.
3. In each recursive call:
    - Treat the first element as the root.
    - Partition the remaining elements into `left` and `right` lists.
    - Recursively calculate the number of valid reorderings for each subtree.
    - Multiply the left and right subtree counts by \(\binom{l+r}{l}\), which counts the ways to interleave their elements while preserving their relative orders.
4. Apply the modulo at each multiplication to avoid overflow.
5. Subtract one to exclude the original ordering and normalize the result modulo \(10^9 + 7\).

## 💻 Solution

See [Solution.java](./Solution.java).

## ⏱️ Complexity

- **Time:** O(n²) for building the binomial coefficient table and partitioning elements across recursive calls in the worst case.
- **Space:** O(n²) for the table, plus O(n²) worst-case auxiliary space from recursive list allocations.

## 📌 Key Takeaway

Combining recursive BST decomposition with combinatorics makes it possible to count valid reorderings without generating them individually. Binomial coefficients account for interleavings between the left and right subtrees while recursion handles each subtree independently.