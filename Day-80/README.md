# Day 80 — Minimum XOR Path in a Grid

**LeetCode:** [3882. Minimum XOR Path in a Grid](https://leetcode.com/problems/minimum-xor-path-in-a-grid/)

**Difficulty:** Medium

**Topic:** Array, Dynamic Programming, Bit Manipulation, Memoization

## 🧠 Intuition

The goal is to find the minimum XOR value among all paths from the top-left cell to the bottom-right cell, moving only down or right.

Since XOR depends on the values of all cells visited so far, we track the current XOR alongside the current position. Memoization avoids recomputing the result for the same state.

## 🔄 Approach

1. Initialize a three-dimensional DP array `dp[m][n][1024]` and fill it with `-1` to mark uncomputed states.
2. Start the recursive search at `(0, 0)` with an initial XOR value of `0`.
3. At each cell, calculate `nextXor` by XORing the current path value with the cell's value.
4. If the destination is reached, return the accumulated XOR.
5. Otherwise, recursively explore moving down and right, then take the minimum result.
6. Cache the result in `dp[row][col][currentXor]` to avoid repeated calculations.

## 💻 Solution

See [Solution.java](./Solution.java).

## ⏱️ Complexity

Let \(X = 1024\), the number of possible XOR states used by the implementation.

- **Time:** O(m × n × X), since each position and XOR state is computed at most once.
- **Space:** O(m × n × X) for the memoization table, plus O(m + n) for the maximum recursion depth.

## 📌 Key Takeaway

When a path problem depends on both position and accumulated state, such as XOR, memoization can use all three values—row, column, and current XOR—to avoid exploring the same state repeatedly.