# Day 30 — Count Commas in Range

**LeetCode:** [3870. Count Commas in Range](https://leetcode.com/problems/count-commas-in-range/)

**Difficulty:** Easy

**Topic:** Math, Counting

## 🧠 Intuition

A comma appears in a number when the number is at least `1000`.

For the range from `1` to `n`:

- If `n < 1000`, there are no commas.
- If `n >= 1000`, every number from `1000` through `n` contains exactly one comma.

Therefore, the number of commas is simply:

`n - 1000 + 1`

which is equivalent to:

`n - 999`

## 🔄 Approach

1. If `n < 1000`, return `0`.
2. Otherwise, count all numbers from `1000` to `n`.
3. Return the count.

## 💻 Solution

See [`Solution.java`](./Solution.java).

## ⏱️ Complexity

- **Time:** `O(1)`
- **Space:** `O(1)`

## 📌 Key Takeaway

> Sometimes the simplest solution comes from identifying the exact range where the required condition starts.

This problem is a good reminder to look for a direct mathematical observation before reaching for a more complicated approach.