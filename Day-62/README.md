# Day 62 — Minimum Sum of Squared Difference

**LeetCode:** [2333. Minimum Sum of Squared Difference](https://leetcode.com/problems/minimum-sum-of-squared-difference/)

**Difficulty:** Medium

**Topic:** Greedy, Counting, Array

## 🧠 Intuition

The goal is to minimize the sum of squared differences between corresponding elements of two arrays by performing at most `k1 + k2` operations.

Since squaring larger differences contributes much more to the total sum, reducing the largest differences first is an effective greedy strategy.

Instead of sorting the differences, we can use a frequency array to count how many times each difference occurs and efficiently reduce the largest differences.

## 🔄 Approach

1. Calculate the absolute difference between each pair of corresponding elements and store its frequency in a counting array.
2. Combine `k1` and `k2` into a single operation budget, `k`.
3. Traverse the possible differences from largest to smallest:
    - Reduce the current difference by one for as many elements as possible, limited by its frequency and the remaining operations.
    - Move those elements into the frequency bucket for the next smaller difference.
    - Stop when all operations are used.
4. Calculate the final sum by multiplying each difference's frequency by its squared value.

## 💻 Solution

See [Solution.java](./Solution.java).

## ⏱️ Complexity

- **Time:** O(n + M), where `n` is the array length and `M` is the maximum possible difference.
- **Space:** O(M) for the frequency array.

Here, `M = 100000`.

## 📌 Key Takeaway

A greedy strategy combined with frequency counting can avoid sorting and efficiently minimize the squared-difference sum. Reducing the largest differences first helps achieve the greatest benefit from the available operations.