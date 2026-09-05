# Day 27 — Smallest Stable Index II

**LeetCode:** [3904. Smallest Stable Index II](https://leetcode.com/problems/smallest-stable-index-ii/)

**Difficulty:** Easy

**Topic:** Arrays, Prefix Maximum, Suffix Minimum

## 🧠 Intuition

For an index `i` to be stable, the difference between the maximum value from the beginning of the array up to `i` and the minimum value from `i` to the end of the array must be at most `k`.

The condition is:

`max(nums[0...i]) - min(nums[i...n-1]) <= k`

Instead of repeatedly calculating these values for every index, I precompute the required maximum and minimum values.

## 🔄 Approach

1. Create a `minmax` array.
2. Build the prefix maximum from left to right.
3. Build the suffix minimum from right to left.
4. Traverse the array from left to right.
5. For each index `i`, check:

   `minmax[i][0] - minmax[i][1] <= k`

6. Return the first index satisfying the condition.
7. If no such index exists, return `-1`.

## 💻 Solution

See [`Solution.java`](./Solution.java).

## ⏱️ Complexity

The array is traversed a constant number of times.

- **Time:** `O(n)`
- **Space:** `O(n)`

## 📌 Key Takeaway

> Recognizing a pattern from a previous problem can make a new problem much easier to solve.

This problem reinforced my understanding of **prefix and suffix preprocessing** and how it can help avoid repeated calculations.