# Day 31 — Count Commas in Range II

**LeetCode:** [3871. Count Commas in Range II](https://leetcode.com/problems/count-commas-in-range-ii/)

**Difficulty:** Easy

**Topic:** Math, Counting

## 🧠 Intuition

A comma appears at different number thresholds:

- `1,000` → 1 comma
- `1,000,000` → 2 commas
- `1,000,000,000` → 3 commas
- `1,000,000,000,000` → 4 commas
- `1,000,000,000,000,000` → 5 commas

Instead of checking every number from `1` to `n`, we count the contribution of each comma position separately.

For example, if `n >= 1,000`, every number from `1,000` to `n` contributes at least one comma.

Similarly, if `n >= 1,000,000`, every number from `1,000,000` to `n` contributes another comma.

## 💻 Solution

See [`Solution.java`](./Solution.java).

## ⏱️ Complexity

- **Time:** `O(1)`
- **Space:** `O(1)`