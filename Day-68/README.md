# Day 68 — Subarrays Distinct Element Sum of Squares II

**LeetCode:** [2916. Subarrays Distinct Element Sum of Squares II](https://leetcode.com/problems/subarrays-distinct-element-sum-of-squares-ii/)

**Difficulty:** Hard

**Topic:** Segment Tree, Lazy Propagation, Hash Map, Array

## 🧠 Intuition

Unlike the first version, this problem requires efficiently calculating the sum of squared distinct-element counts across all subarrays, with results taken modulo \(10^9 + 7\).

For each right endpoint `r`, we maintain the distinct-element counts of all subarrays ending at `r`. When adding `nums[r]`, the number of distinct elements increases by one only for subarrays whose starting positions are after the previous occurrence of that value.

A lazy-propagation segment tree allows us to increment a range of counts efficiently while maintaining both the sum of counts and the sum of their squares.

## 🔄 Approach

1. Initialize a segment tree over all possible starting indices. Each position initially has a distinct-element count of zero.
2. Use a `HashMap` named `lastSeen` to track the most recent index of each value.
3. Iterate through the array using the right endpoint `r`:
    - Find `l`, the index immediately after the previous occurrence of `nums[r]`, or `0` if it has not appeared before.
    - Increment all counts in the range `[l, r]` by one using a lazy-propagation range update.
    - Update the most recent occurrence of `nums[r]`.
    - Add the segment tree's total sum of squared counts to the answer, modulo \(10^9 + 7\).
4. Return the accumulated result.

### Segment Tree Details

Each node maintains:
- `sumOfCounts`: the sum of distinct-element counts in its range.
- `sumOfSquares`: the sum of the squares of those counts.
- `lazy`: a pending increment to apply to the node's range.

When every count in a range increases by `val`, the sum of squares is updated using:

\[
\sum (x+v)^2 = \sum x^2 + 2v\sum x + v^2 \cdot L
\]

where \(L\) is the range length. Lazy propagation applies these updates efficiently without visiting every element individually.

## 💻 Solution

See [Solution.java](./Solution.java).

## ⏱️ Complexity

- **Time:** O(n log n), since each array element triggers one range update and each update takes O(log n).
- **Space:** O(n) for the segment tree and the last-occurrence map.

## 📌 Key Takeaway

Lazy propagation can efficiently maintain both sums and sums of squares when an entire range is incremented. Combining this with last-occurrence tracking transforms a quadratic subarray-enumeration problem into an O(n log n) solution.