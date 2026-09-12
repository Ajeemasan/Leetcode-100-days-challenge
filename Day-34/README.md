# Day 34 — Maximum Score of Non-overlapping Intervals

**LeetCode:** [3414. Maximum Score of Non-overlapping Intervals](https://leetcode.com/problems/maximum-score-of-non-overlapping-intervals/)

**Difficulty:** Hard

**Topic:** Dynamic Programming, Binary Search, Sorting

## 🧠 Intuition

Sort the intervals by their starting position. For each interval, we can either skip it or take it and jump to the next non-overlapping interval. Since we can select at most 4 intervals, DP with binary search efficiently finds the maximum total weight while handling lexicographical tie-breaking.

## 🔄 Approach

Use DP where `dp[i][j]` represents the best result from index `i` onward when we can still choose `j` intervals. For every interval, compare skipping it with taking it and moving to the next compatible interval found using binary search.

## 💻 Solution

See [Solution.java](./Solution.java).

## ⏱️ Complexity

- **Time:** `O(n log n + 4n log n)`
- **Space:** `O(4n)`

## 📌 Key Takeaway

This problem combines sorting, binary search, and dynamic programming to efficiently handle non-overlapping interval selection. The key idea is to reduce each interval decision to **take or skip**, then jump directly to the next compatible interval.