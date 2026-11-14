# Day 97 — Minimum Positive Sum Subarray

**LeetCode:** [3364. Minimum Positive Sum Subarray](https://leetcode.com/problems/minimum-positive-sum-subarray/)

**Difficulty:** Easy

**Topic:** Array, Prefix Sum, Brute Force

## 🧠 Intuition

We need to find the minimum positive sum among all subarrays whose lengths are between `l` and `r`.

Calculating each subarray sum from scratch would be inefficient. Instead, we can use a prefix sum array to calculate subarray sums in constant time.

## 🔄 Approach

**1. Build the Prefix Sum Array**

- Create `prefix[]`, where `prefix[i]` stores the sum of elements from index `0` to `i`.
- This allows us to calculate subarray sums efficiently.

**2. Generate Valid Subarrays**

- Iterate through every possible starting index `i`.
- Consider ending indices from `i + l - 1` up to `i + r - 1`, while staying within the array.
- Calculate the subarray sum using:

`sum(i, j) = prefix[j] - prev`

Here, `prev` stores the prefix sum immediately before the current starting index, or `0` when `i = 0`.

**3. Find the Minimum Positive Sum**

- If the calculated sum is positive, update the minimum answer.
- If no positive subarray sum is found, return `-1`.

## 💻 Solution

See [Solution.java](./Solution.java).

## ⏱️ Complexity

Let `n` be the length of the array.

- **Time:** O(n × (r - l + 1)), for checking all valid subarray lengths.
- **Space:** O(n), for the prefix sum array.

## 📌 Key Takeaway

Prefix sums eliminate repeated subarray-sum calculations. Combining them with bounded enumeration provides a simple and efficient solution when the allowed subarray lengths are restricted.