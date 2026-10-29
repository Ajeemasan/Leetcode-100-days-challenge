# Day 81 — Palindromic Path Queries in a Tree

**LeetCode:** [3841. Palindromic Path Queries in a Tree](https://leetcode.com/problems/palindromic-path-queries-in-a-tree/)

**Difficulty:** Hard

**Topic:** Trees, Lowest Common Ancestor (LCA), Binary Lifting, Euler Tour, Fenwick Tree, Bit Manipulation

## 🧠 Intuition

A path's characters can be rearranged into a palindrome if at most one character appears an odd number of times.

Instead of counting character frequencies for every query, we represent character parity using a 26-bit bitmask. XOR combines these masks efficiently, while binary lifting finds the Lowest Common Ancestor (LCA) of two nodes.

To handle character updates efficiently, we use an Euler tour and a Fenwick tree with XOR range updates.

## 🔄 Approach

1. Build the adjacency list and perform a DFS to calculate node depths, Euler tour entry/exit times, and binary-lifting ancestors.
2. Compute the initial root-to-node character masks.
3. Initialize a Fenwick tree to maintain the root-to-node masks using Euler tour positions.
4. For an `update` query, XOR the old and new character bits and apply the change to the updated node's entire subtree.
5. For a path query `(u, v)`, find `LCA(u, v)` using binary lifting.
6. Combine the root-to-node masks using `maskU ^ maskV ^ maskLCAChar` to obtain the path's character-parity mask.
7. Check whether at most one bit is set using `(pathMask & (pathMask - 1)) == 0`. If true, the path can form a palindrome.

## 💻 Solution

See [Solution.java](./Solution.java).

## ⏱️ Complexity

Let `n` be the number of nodes and `q` the number of queries.

- **Time:** O(n log n + q log n), assuming each query string has bounded length. Each update or path query takes O(log n).
- **Space:** O(n log n) for binary-lifting ancestors, adjacency lists, and supporting arrays.

## 📌 Key Takeaway

Combining bitmask parity, Euler tours, Fenwick trees, and binary lifting enables efficient path queries with character updates. XOR makes it possible to track character-frequency parity without storing full frequency counts.