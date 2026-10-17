# Day 69 — Minimum Swaps to Sort by Digit Sum

**LeetCode:** [3551. Minimum Swaps to Sort by Digit Sum](https://leetcode.com/problems/minimum-swaps-to-sort-by-digit-sum/)

**Difficulty:** Medium

**Topic:** Array, Sorting, Greedy, Cycle Decomposition

## 🧠 Intuition

The goal is to sort the array by digit sum in ascending order, using the element's value as a tie-breaker when two elements have the same digit sum.

Instead of directly swapping elements, we can determine where each original element belongs in the sorted order. This creates a permutation of indices, which can be decomposed into cycles.

A cycle of length `k` requires `k - 1` swaps to place all its elements in their correct positions.

## 🔄 Approach

1. Create an array of indices representing the original positions of the elements.
2. Sort these indices using two criteria:
    - First, compare the digit sums of the corresponding elements.
    - If the digit sums are equal, compare the element values in ascending order.
3. Initialize a `visited` array to track processed indices.
4. Traverse the indices and identify permutation cycles:
    - Skip indices that are already visited or are already in their correct positions.
    - Follow the permutation until a visited index is reached, counting the cycle length.
    - Add `cycleSize - 1` to the total number of swaps.
5. Return the total number of swaps.

The helper method `getDigitSum()` calculates the sum of the digits of a number.

## 💻 Solution

See [Solution.java](./Solution.java).

## ⏱️ Complexity

- **Time:** O(n log n + n × d), where `n` is the array length and `d` is the maximum number of digits in an element. Sorting dominates for typical bounded integer inputs.
- **Space:** O(n) for the index array and visited array.

## 📌 Key Takeaway

Permutation cycles provide an efficient way to calculate the minimum number of swaps needed to reorder elements. Sorting indices instead of moving the original values also makes it easier to preserve the original array while determining each element's target position.