# Day 51 — Check if There Is a Valid Parentheses String Path

**LeetCode:** [2267. Check if There Is a Valid Parentheses String Path](https://leetcode.com/problems/check-if-there-is-a-valid-parentheses-string-path/)

**Difficulty:** Hard

**Topic:** Dynamic Programming, DFS, Memoization, Grid

## 🧠 Intuition

A valid path must form a balanced parentheses string, meaning the number of closing parentheses can never exceed the number of opening parentheses at any point, and the final balance must be zero.

While exploring the grid, the important state is not just the current cell but also the current number of unmatched opening parentheses. This allows us to use memoization and avoid solving the same state repeatedly.

## 🔄 Approach

- Use DFS to explore paths by moving either down or right.
- Maintain `open` as the current number of unmatched opening parentheses.
- Increment `open` for `(` and decrement it for `)`.
- If `open` becomes negative, the path cannot be valid.
- At the bottom-right cell, the path is valid only when `open == 0`.
- Memoize each `(row, col, open)` state using a 3D DP array.
- Store whether each state has been determined to be valid or invalid.

## 💻 Solution

See [Solution.java](./Solution.java).

## ⏱️ Complexity

- **Time:** O(m × n × (m + n))
- **Space:** O(m × n × (m + n))

## 📌 Key Takeaway

For grid path problems where the result depends on an additional changing condition, the state often needs to include both the **position and that condition**. Here, `(row, col, open)` completely describes the state, allowing DFS with memoization to efficiently avoid repeated work.