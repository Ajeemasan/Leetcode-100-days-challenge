# Day 44 — Find X Value of Array II

**LeetCode:** [3525. Find X Value of Array II](https://leetcode.com/problems/find-x-value-of-array-ii/)

**Difficulty:** Hard

**Topic:** Segment Tree, Dynamic Programming, Modular Arithmetic

## 🧠 Intuition

Unlike the previous version, this problem includes updates and range queries, so processing every subarray after each query would be too slow.

A segment tree can maintain information about each range. For every node, we store the product modulo `k` and the number of subarrays producing each possible remainder.

When two segments are merged, their products are combined modulo `k`, and the subarray counts from the right segment are adjusted based on the product of the left segment.

## 🔄 Approach

- Build a segment tree over the array.
- For every node, store:
    - The product of the segment modulo `k`.
    - The number of subarrays for every possible product remainder.
- Merge two nodes by combining their products and updating the remainder counts.
- For each query:
    - Update the specified index in the segment tree.
    - Query the range `[start, n - 1]`.
    - Return the number of subarrays whose product modulo `k` equals `x`.
- Each update and range query operates on `O(log n)` segment-tree nodes, with `O(k)` work required to merge each node.

## 💻 Solution

See [Solution.java](./Solution.java).

## ⏱️ Complexity

- **Build:** O(n × k)
- **Each update:** O(k log n)
- **Each query:** O(k log n)
- **Space:** O(n × k)

## 📌 Key Takeaway

This problem combines **segment trees with modular DP states**. The important idea is to design a node so that two ranges can be merged while preserving exactly the information needed for future updates and queries.