# Day 26 — Smallest Stable Index I

**LeetCode:** [3903. Smallest Stable Index I](https://leetcode.com/problems/smallest-stable-index-i/)

**Difficulty:** Easy

**Topic:** Arrays, Prefix Maximum, Suffix Minimum

## 🧠 Intuition

For an index `i` to be stable, the difference between the maximum value from the beginning of the array up to `i` and the minimum value from `i` to the end of the array must be at most `k`.

In other words:

`max(nums[0...i]) - min(nums[i...n-1]) <= k`

So instead of checking all elements repeatedly, I precompute:

- The maximum value from the left up to every index.
- The minimum value from the right starting at every index.

Then I scan the array from left to right and return the first index satisfying the condition.

## 🔄 Approach

1. Create a `maxmin` array where:
    - `maxmin[i][0]` stores the maximum value from index `0` to `i`.
    - `maxmin[i][1]` stores the minimum value from index `i` to `n - 1`.
2. Build the prefix maximum array from left to right.
3. Build the suffix minimum array from right to left.
4. Traverse the array from left to right.
5. Return the first index where:

   `maxmin[i][0] - maxmin[i][1] <= k`

6. If no stable index exists, return `-1`.

## 💻 Solution

See [`Solution.java`](./Solution.java).

## ⏱️ Complexity

The array is traversed a constant number of times.

- **Time:** `O(n)`
- **Space:** `O(n)`

## 📌 Key Takeaway

> Precomputing prefix and suffix information can turn repeated range calculations into a linear-time solution.

This problem helped me practice combining **prefix and suffix preprocessing** to efficiently answer a condition at every index.