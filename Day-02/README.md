# Day 2 — Smallest Missing Integer Greater Than Sequential Prefix Sum

**LeetCode:** [2996. Smallest Missing Integer Greater Than Sequential Prefix Sum](https://leetcode.com/problems/smallest-missing-integer-greater-than-sequential-prefix-sum/)

**Difficulty:** Easy

**Topic:** Arrays, Prefix Sum

## 🧠 Intuition

The first step is to find the sum of the longest sequential prefix of the array.

A sequential prefix is a prefix where every element is exactly `1` greater than the previous element.

For example:

`[1, 2, 3, 7, ...]`

has a sequential prefix of `[1, 2, 3]`.

Its sum is:

`1 + 2 + 3 = 6`

Once we find this prefix sum, we need to find the smallest integer greater than or equal to this sum that does not exist in the array.

## 🔄 Approach

I used **array traversal to find the sequential prefix** and then searched for the smallest missing integer starting from its sum.

1. Start with the first element as the beginning of the sequential prefix.
2. Traverse the array and check whether the current element is exactly `1` greater than the previous element.
3. If it is, add it to the current prefix sum.
4. When the sequential pattern breaks, store the maximum prefix sum found.
5. Start checking from the prefix sum to find the smallest integer that is not present in the array.
6. I used an `ArrayList` and `contains()` to check whether each candidate exists.

## 💻 Solution

See [`Solution.java`](./Solution.java).

## ⏱️ Complexity

There are `n` elements in the array.

Finding the sequential prefix takes `O(n)` time.

For each candidate, `ArrayList.contains()` can take `O(n)` time in the worst case.

- **Time:** `O(n²)` in the worst case
- **Space:** `O(n)`

## 📌 Key Takeaway

The main idea I learned from this problem is:

> First identify the sequential prefix and calculate its sum, then use that sum as the starting point to find the smallest missing integer.

This problem helped me practice **sequential prefix identification and array traversal**.