# Day 43 — Find X Value of Array I

**LeetCode:** [3524. Find X Value of Array I](https://leetcode.com/problems/find-x-value-of-array-i/)

**Difficulty:** Medium

**Topic:** Dynamic Programming, Arrays, Modular Arithmetic

## 🧠 Intuition

The key is to track the product modulo `k` rather than the complete product of each subarray.

For every position, we maintain the number of subarrays ending at the current element for each possible remainder `0` to `k - 1`. This allows us to extend previous subarrays and update their product modulo `k` efficiently.

## 🔄 Approach

- Use `dp[r]` to store the number of subarrays ending at the previous position whose product modulo `k` is `r`.
- For each number, start a new subarray containing only that number.
- Extend every existing subarray and calculate the new product modulo `k`.
- Store these updated counts in `newDp`.
- Add the counts from `newDp` to the global answer array.
- Move `newDp` into `dp` and continue processing the array.

## 💻 Solution

See [Solution.java](./Solution.java).

## ⏱️ Complexity

- **Time:** O(n × k)
- **Space:** O(k)

## 📌 Key Takeaway

When the exact value of a product can become very large, tracking its **remainder modulo `k`** can reduce the state space dramatically. This is a useful dynamic programming pattern for subarray problems involving modular arithmetic.