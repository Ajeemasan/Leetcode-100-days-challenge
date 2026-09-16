# Day 38 — Number of Sets of K Non-Overlapping Line Segments

**LeetCode:** [1621. Number of Sets of K Non-Overlapping Line Segments](https://leetcode.com/problems/number-of-sets-of-k-non-overlapping-line-segments/)

**Difficulty:** Medium

**Topic:** Dynamic Programming, Combinatorics

## 🧠 Intuition

The problem can be transformed into a combinatorial counting problem. By representing the placement of `k` non-overlapping segments through their endpoints, the number of valid configurations can be computed as a binomial coefficient.

The solution calculates this value using 1D dynamic programming while applying the modulo constraint.

## 🔄 Approach

- Transform the problem into choosing `2k` endpoints from `n + k - 1` possible positions.
- Let `N = n + k - 1` and `K = 2k`.
- Use a 1D DP array where `dp[j]` represents the number of ways to choose `j` elements from the processed positions.
- Update the DP array from right to left to avoid overwriting values needed for the current iteration.
- Apply modulo `1,000,000,007` throughout the computation.
- If there are not enough positions to choose `2k` endpoints, return `0`.

## 💻 Solution

See [Solution.java](./Solution.java).

## ⏱️ Complexity

- **Time:** O((n + k) × k)
- **Space:** O(k)

## 📌 Key Takeaway

Some counting problems become much simpler after finding the right combinatorial transformation. Here, converting the segment-placement problem into an endpoint-selection problem allows the answer to be computed efficiently using 1D DP.