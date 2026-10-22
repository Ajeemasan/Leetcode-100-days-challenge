# Day 74 — Minimum Operations to Sort a Permutation

**LeetCode:** [3942. Minimum Operations to Sort a Permutation](https://leetcode.com/problems/minimum-operations-to-sort-a-permutation/)

**Difficulty:** Medium

**Topic:** Array, Permutation, Simulation, Math

## 🧠 Intuition

The key observation is that the permutation can be sorted using the allowed operations only if its elements follow one of two specific cyclic patterns around `0`: increasing order or decreasing order.

By locating `0` and checking the sequence in both circular directions, we can determine whether either pattern holds. If neither does, sorting is impossible under the given operation rules.

## 🔄 Approach

1. Find the index `ind` where `0` occurs.
2. Check the circular sequence in the forward direction:
    - Starting from `ind`, verify that the elements match `0, 1, 2, ...`.
    - Track whether the permutation follows the increasing pattern using `isInc`.
3. Check the circular sequence in the reverse direction:
    - Starting from `ind`, verify that the elements match `0, 1, 2, ...` when moving backward.
    - Track whether the permutation follows the decreasing pattern using `isDec`.
4. If neither pattern matches, return `-1`.
5. Otherwise, calculate the candidate operation counts for the valid pattern or patterns and return the minimum.

## 💻 Solution

See [Solution.java](./Solution.java).

## ⏱️ Complexity

- **Time:** O(n), since locating `0` and checking both circular directions take linear time.
- **Space:** O(1), since only a constant number of variables are used.

## 📌 Key Takeaway

Recognizing structural patterns in a permutation can eliminate the need to simulate every possible operation. Circular traversal and modular indexing make it possible to verify both orientations efficiently in a single linear scan.