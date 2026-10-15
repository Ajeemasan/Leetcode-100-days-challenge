# Day 67 — Subarrays Distinct Element Sum of Squares I

**LeetCode:** [2913. Subarrays Distinct Element Sum of Squares I](https://leetcode.com/problems/subarrays-distinct-element-sum-of-squares-i/)

**Difficulty:** Easy

**Topic:** Array, Hash Set, Enumeration

## 🧠 Intuition

The goal is to consider every possible contiguous subarray, count its distinct elements, square that count, and add it to the total sum.

A `HashSet` efficiently tracks the distinct elements in each subarray. By fixing a starting index and extending the subarray one element at a time, we can update the set incrementally instead of recounting distinct elements from scratch.

## 🔄 Approach

1. Initialize `totalSum` to `0` and get the length of the list.
2. Iterate through each possible starting index `i`.
3. For each starting index:
    - Extend the subarray by iterating through every ending index `j`.
    - Add `nums[j]` to the `HashSet`.
    - Get the number of distinct elements using `distinctElements.size()`.
    - Add the square of that count to `totalSum`.
4. Clear the set before processing the next starting index.
5. Return `totalSum`.

## 💻 Solution

See [Solution.java](./Solution.java).

## ⏱️ Complexity

- **Time:** O(n²) expected, assuming average constant-time `HashSet` operations.
- **Space:** O(n) for storing distinct elements in the set.

## 📌 Key Takeaway

Fixing a starting index and extending each subarray allows us to enumerate all contiguous subarrays while maintaining their distinct elements incrementally. A `HashSet` makes this straightforward and avoids repeatedly counting duplicates.