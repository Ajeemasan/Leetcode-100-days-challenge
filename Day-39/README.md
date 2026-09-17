# Day 39 — Find Two Non-overlapping Sub-arrays Each With Target Sum

**LeetCode:** [1477. Find Two Non-overlapping Sub-arrays Each With Target Sum](https://leetcode.com/problems/find-two-non-overlapping-sub-arrays-each-with-target-sum/)

**Difficulty:** Medium

**Topic:** Sliding Window, Dynamic Programming, Arrays

## 🧠 Intuition

Since the array contains positive integers, a sliding window can efficiently find subarrays whose sum equals the target.

The main challenge is finding two non-overlapping subarrays with the minimum combined length. We can store the shortest valid subarray found up to each position and use it when a new valid subarray is discovered.

## 🔄 Approach

- Use a sliding window with `left` and `right` pointers to find subarrays with sum equal to `target`.
- Maintain `best[i]` as the minimum length of a valid subarray ending at or before index `i`.
- When a valid subarray `[left, right]` is found, check `best[left - 1]` to ensure the previous subarray does not overlap.
- Update the minimum combined length.
- Propagate the best result forward through the `best` array.
- Return `-1` if no valid pair of non-overlapping subarrays exists.

## 💻 Solution

See [Solution.java](./Solution.java).

## ⏱️ Complexity

- **Time:** O(n)
- **Space:** O(n)

## 📌 Key Takeaway

Combining a **sliding window** with a prefix-style DP array is an effective way to solve non-overlapping subarray problems. The key is to store the best result from the portion of the array that comes before the current window.