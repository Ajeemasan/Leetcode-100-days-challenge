# Day 25 — Construct Uniform Parity Array II

**LeetCode:** [3876. Construct Uniform Parity Array II](https://leetcode.com/problems/construct-uniform-parity-array-ii/)

**Difficulty:** Easy

**Topic:** Arrays, Parity, Greedy

## 🧠 Intuition

The key observation is to find the **smallest odd number** in the array.

If there are no odd numbers, the answer is automatically `true`.

Otherwise, an even number can only be transformed appropriately if it is not smaller than the smallest odd number.

Therefore, after finding the smallest odd value, I check whether there exists an even number smaller than it.

- If such an even number exists → `false`
- Otherwise → `true`

## 🔄 Approach

1. Traverse the array and find the smallest odd number.
2. If there is no odd number, return `true`.
3. Traverse the array again.
4. If any even number is smaller than the smallest odd number, return `false`.
5. Otherwise, return `true`.

## 💻 Solution

See [`Solution.java`](./Solution.java).

## ⏱️ Complexity

The array is traversed twice.

- **Time:** `O(n)`
- **Space:** `O(1)`

## 📌 Key Takeaway

> Finding the right value to compare against can simplify a problem significantly.

This problem helped me practice identifying a useful **greedy condition** instead of simulating every possible operation.