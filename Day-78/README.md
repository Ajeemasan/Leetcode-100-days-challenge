# Day 78 — Count Islands With Total Value Divisible by K

**LeetCode:** [3619. Count Islands With Total Value Divisible by K](https://leetcode.com/problems/count-islands-with-total-value-divisible-by-k/)

**Difficulty:** Medium

**Topic:** Array, Depth-First Search (DFS), Matrix, Graph Traversal

## 🧠 Intuition

An island is a connected group of non-zero cells, where connectivity is defined by the four adjacent directions.

Instead of counting individual cells, we need to calculate the total value of each island. If that sum is divisible by `k`, the island contributes one to the answer.

## 🔄 Approach

1. Traverse every cell in the grid.
2. Whenever a non-zero cell is found, start DFS to explore its entire island.
3. Add each visited cell's value to the island sum and mark the cell as `0` to prevent revisiting it.
4. Continue DFS in all four directions to collect the values of connected cells.
5. If the island sum is divisible by `k`, increment the answer.
6. Return the total number of qualifying islands.

The DFS returns a `long` to safely accumulate island values without unnecessary integer overflow.

## 💻 Solution

See [Solution.java](./Solution.java).

## ⏱️ Complexity

- **Time:** O(m × n), since each cell is visited at most once.
- **Space:** O(m × n) in the worst case due to the recursive DFS call stack.

## 📌 Key Takeaway

DFS can do more than identify connected components: it can also aggregate information, such as the sum of all cell values within each component. Modifying visited cells in place eliminates the need for a separate `visited` matrix.