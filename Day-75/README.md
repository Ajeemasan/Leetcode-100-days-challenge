# Day 75 — Maximum K to Sort a Permutation

**LeetCode:** [3644. Maximum K to Sort a Permutation](https://leetcode.com/problems/maximum-k-to-sort-a-permutation/)

**Difficulty:** Medium

**Topic:** Array, Bit Manipulation, Greedy

## 🧠 Intuition

The goal is to find the maximum value of `k` that allows the permutation to be sorted using the permitted bitwise operations.

An element already at its correct index does not need to be changed. For every misplaced element, its value must be compatible with the allowed `k`.

The bitwise AND of all misplaced elements captures the bits shared by every value that needs to be moved.

## 🔄 Approach

1. Initialize `ans` to `-1` and get the array length `n`.
2. Traverse the array and compare each element with its target index `i`.
3. If `nums[i] != i`, update `ans` using bitwise AND: `ans &= nums[i]`.
4. After processing all elements, return `Math.max(ans, 0)` to ensure the result is non-negative.

## 💻 Solution

See [Solution.java](./Solution.java).

## ⏱️ Complexity

- **Time:** O(n), since each element is examined once.
- **Space:** O(1), since only a constant amount of extra space is used.

## 📌 Key Takeaway

Bitwise AND can identify the bits shared by all misplaced elements, providing an efficient way to determine the maximum valid `k` without simulating sorting operations.