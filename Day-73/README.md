# Day 73 — Minimum Operations to Sort a String

**LeetCode:** [3863. Minimum Operations to Sort a String](https://leetcode.com/problems/minimum-operations-to-sort-a-string/)

**Difficulty:** Medium

**Topic:** String, Greedy, Observation

## 🧠 Intuition

The key is to determine the minimum number of operations needed to sort the string by examining its current order and the positions of its minimum and maximum characters.

Instead of simulating operations, we can use a few observations about the string's structure to determine whether it is already sorted and how many operations are necessary.

## 🔄 Approach

1. Traverse the string to check whether it is already sorted in non-decreasing order.
2. Track the minimum and maximum characters while scanning.
3. If the string is already sorted, return `0`.
4. If its length is `2` and it is not sorted, return `-1`.
5. If the first character is the minimum or the last character is the maximum, return `1`.
6. Otherwise, check the interior characters:
    - If any interior character is the minimum or maximum, return `2`.
    - If neither appears in the interior, return `3`.

## 💻 Solution

See [Solution.java](./Solution.java).

## ⏱️ Complexity

- **Time:** O(n), since the string is traversed at most twice.
- **Space:** O(1), since only a constant number of variables are used.

## 📌 Key Takeaway

Not every sorting problem requires an actual sorting algorithm. By identifying the minimum and maximum characters and analyzing their positions, we can determine the minimum number of operations through a linear scan.