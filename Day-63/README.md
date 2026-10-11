# Day 63 — Sum of Squares of Special Elements

**LeetCode:** [2778. Sum of Squares of Special Elements](https://leetcode.com/problems/sum-of-squares-of-special-elements/)

**Difficulty:** Easy

**Topic:** Array, Math

## 🧠 Intuition

An element is considered special if its 1-based index divides the length of the array evenly.

For every special element, add the square of its value to the final sum.

## 🔄 Approach

1. Initialize `n` as the array length and `ans` as `0`.
2. Iterate through the array using index `i`.
3. Check whether `n % (i + 1) == 0`, since the problem uses 1-based indexing.
4. If the condition holds, add `nums[i] * nums[i]` to `ans`.
5. Return the final sum.

## 💻 Solution

See [Solution.java](./Solution.java).

## ⏱️ Complexity

- **Time:** O(n), since each element is checked once.
- **Space:** O(1), since only a constant amount of extra space is used.

## 📌 Key Takeaway

Careful handling of 1-based indexing and a simple divisibility check are enough to solve this problem efficiently in a single pass.