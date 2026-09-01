# Day 23 — Minimum Moves to Clean the Classroom

**LeetCode:** [3568. Minimum Moves to Clean the Classroom](https://leetcode.com/problems/minimum-moves-to-clean-the-classroom/)

**Difficulty:** Medium

**Topic:** Breadth-First Search, Bitmask, State Space Search

## 🧠 Intuition

The classroom can be treated as a grid where we need to collect every piece of litter.

A simple BFS based only on the current position is not enough because reaching the same cell with different amounts of energy or different collected litter can lead to completely different outcomes.

So I represent each BFS state using:

`(row, column, energy, collected litter)`

The collected litter is represented using a **bitmask**, where each bit corresponds to one litter cell.

This allows the BFS to keep track of exactly which litter pieces have already been collected.

## 🔄 Approach

1. Convert the classroom into a character grid.
2. Find the starting position `S`.
3. Assign a unique bit to every litter cell `L`.
4. Represent the collected litter using a bitmask.
5. Use BFS starting from:
    - The starting position.
    - Full initial energy.
    - An empty litter mask.
6. For every possible move:
    - Skip walls (`X`).
    - Decrease energy by `1`.
    - If the destination is a recharge cell (`R`), restore energy to the maximum.
    - If the destination contains litter, mark it in the bitmask.
7. Keep a `visited` array for the complete state:

   `(row, column, energy, mask)`

8. Since BFS explores states level by level, the first time all litter is collected gives the minimum number of moves.
9. If the BFS finishes without collecting all litter, return `-1`.

## 💻 Solution

See [`Solution.java`](./Solution.java).

## ⏱️ Complexity

The number of possible states is bounded by:

`O(m × n × energy × 2^L)`

where `L` is the number of litter cells.

Each state has at most 4 possible moves.

- **Time:** `O(m × n × energy × 2^L)`
- **Space:** `O(m × n × energy × 2^L)`

## 📌 Key Takeaway

The main idea I learned from this problem is:

> In BFS problems, the state is not always just the current position. Sometimes we need to include additional information such as energy, collected items, or other conditions that affect future moves.

This problem helped me understand how **BFS + bitmasking** can be used to search through a larger state space while still guaranteeing the minimum number of moves.