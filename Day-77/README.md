# Day 77 — Number of Closed Islands

**LeetCode:** [1254. Number of Closed Islands](https://leetcode.com/problems/number-of-closed-islands/)

**Difficulty:** Medium

**Topic:** Array, Depth-First Search (DFS), Matrix, Graph Traversal

## 🧠 Intuition

A closed island is a group of land cells (`0`) completely surrounded by water (`1`), meaning it does not touch the grid's boundary.

Instead of checking whether every island touches the boundary, we first mark all land connected to the boundary as visited. Any remaining unvisited land component must be a closed island.

## 🔄 Approach

1. Create a `visited` matrix to track explored land cells.
2. Traverse all four boundaries and run DFS from every unvisited land cell to mark boundary-connected islands.
3. Iterate through the interior cells of the grid.
4. Whenever an unvisited land cell is found, increment the answer and use DFS to mark its entire island as visited.
5. Return the total number of closed islands.

The DFS explores all four directions and stops when it encounters a boundary violation, water, or an already visited cell.

## 💻 Solution

See [Solution.java](./Solution.java).

## ⏱️ Complexity

- **Time:** O(m × n), since each cell is visited at most once.
- **Space:** O(m × n), for the visited matrix and the worst-case recursive DFS call stack.

## 📌 Key Takeaway

For grid connectivity problems, eliminating components connected to the boundary can simplify the task of identifying enclosed regions. DFS helps explore each connected component efficiently.