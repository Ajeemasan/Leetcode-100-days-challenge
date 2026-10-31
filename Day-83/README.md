# Day 83 — Twisted Mirror Path Count

**LeetCode:** [3665. Twisted Mirror Path Count](https://leetcode.com/problems/twisted-mirror-path-count/)

**Difficulty:** Medium

**Topic:** Dynamic Programming, Recursion, Memoization, Matrix

## 🧠 Intuition

Unlike a standard grid path problem, twisted mirrors can change the direction of movement when a path encounters them.

The key idea is to simulate the movement caused by mirrors whenever we attempt to move right or down. Since the path count from a cell can be reused, we apply memoization to avoid recalculating the same states.

## 🔄 Approach

1. Initialize a memoization matrix with `-1` to mark uncomputed states.
2. Start the recursive path count from the top-left cell `(0, 0)`.
3. If the destination is reached, return `1`.
4. For each cell, explore two possible initial directions: right and down.
5. Use `getNext()` to simulate movement:
    - Move in the selected direction.
    - If the destination is reached, return its coordinates.
    - If an empty cell (`0`) is encountered, return its coordinates.
    - If a mirror is encountered, change direction and continue moving.
6. Recursively calculate the paths from each valid next position.
7. Add both results modulo `10^9 + 7` and cache the result.

## 💻 Solution

See [Solution.java](./Solution.java).

## ⏱️ Complexity

Let `m` and `n` be the grid dimensions.

- **Time:** O(m × n × (m + n)) in the worst case, since each memoized state can perform two directional simulations, each taking up to O(m + n).
- **Space:** O(m × n) for the memoization matrix, with an additional O(m + n) recursion stack in the worst case.

## 📌 Key Takeaway

Memoization is useful when multiple recursive paths reach the same state. Separating movement simulation from path counting also makes grid problems involving direction changes easier to organize and understand.