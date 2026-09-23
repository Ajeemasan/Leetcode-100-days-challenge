# Day 45 — Minimum Operations to Reduce X to Zero

**LeetCode:** [1658. Minimum Operations to Reduce X to Zero](https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/)

**Difficulty:** Medium

**Topic:** Sliding Window, Arrays, Prefix Sum

## 🧠 Intuition

Instead of removing elements from the left and right to make their sum equal to `x`, we can look at the problem from the opposite direction.

If the total sum of the array is `total`, then the elements we keep in the middle must have sum:

`total - x`

So the problem becomes finding the **longest subarray with sum `total - x`**. The elements outside this subarray are the ones removed, so minimizing removals is equivalent to maximizing the length of this subarray.

## 🔄 Approach

- Calculate the total sum of the array.
- Let `target = totalSum - x`.
- Use a sliding window to find the longest subarray whose sum equals `target`.
- Since the array contains positive integers, expand the window from the right and shrink it from the left whenever its sum exceeds the target.
- If the target subarray has length `maxLen`, the minimum number of operations is `n - maxLen`.
- Handle cases where the target is negative or no valid subarray exists.

## 💻 Solution

See [Solution.java](./Solution.java).

## ⏱️ Complexity

- **Time:** O(n)
- **Space:** O(1)

## 📌 Key Takeaway

A useful problem-solving technique is to **reframe the problem instead of directly simulating the required operations**. Turning "remove elements to reach `x`" into "keep the longest subarray with sum `total - x`" makes the problem a straightforward sliding-window problem.