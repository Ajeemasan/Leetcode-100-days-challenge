# Day 99 — Number of Sub-arrays With Odd Sum

**LeetCode:** [1524. Number of Sub-arrays With Odd Sum](https://leetcode.com/problems/number-of-sub-arrays-with-odd-sum/)

**Difficulty:** Medium

**Topic:** Array, Prefix Sum, Counting, Math

## 🧠 Intuition

The sum of a subarray can be determined using prefix sums.

Instead of storing the entire prefix sum array, we only need to track how many previous prefix sums are even and how many are odd.

A subarray has an odd sum when its two prefix sums have different parities:
- Even prefix sum followed by an odd prefix sum.
- Odd prefix sum followed by an even prefix sum.

## 🔄 Approach

**1. Initialize Parity Counts**

- `evenCount = 1`, representing the initial empty prefix with sum zero.
- `oddCount = 0`.
- Initialize `prefixSum` and `result` to zero.

**2. Traverse the Array**

For each element:

- Add it to `prefixSum`.
- If the prefix sum is odd:
    - Every previous even prefix produces an odd-sum subarray.
    - Add `evenCount` to the result.
    - Increment `oddCount`.
- Otherwise:
    - Every previous odd prefix produces an odd-sum subarray.
    - Add `oddCount` to the result.
    - Increment `evenCount`.

Take the result modulo `1,000,000,007` to prevent overflow.

**3. Return the Result**

After processing all elements, return the total number of odd-sum subarrays.

## 💻 Solution

See [Solution.java](./Solution.java).

## ⏱️ Complexity

Let `n` be the length of the array.

- **Time:** O(n), since the array is traversed once.
- **Space:** O(1), as only a constant number of variables are maintained.

## 📌 Key Takeaway

Prefix sum parity is often more useful than the actual prefix sum when a problem only depends on whether a sum is odd or even. Tracking parity frequencies eliminates the need for a separate prefix sum array.