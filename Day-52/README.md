# Day 52 — Maximum Nesting Depth of Two Valid Parentheses Strings

**LeetCode:** [1111. Maximum Nesting Depth of Two Valid Parentheses Strings](https://leetcode.com/problems/maximum-nesting-depth-of-two-valid-parentheses-strings/)

**Difficulty:** Medium

**Topic:** Greedy, Parentheses, Depth

## 🧠 Intuition

The goal is to split the parentheses string into two valid subsequences while minimizing the maximum nesting depth of either subsequence.

A simple way to balance the depth is to assign each parenthesis based on the **parity of its current nesting depth**.

At each position, the parenthesis is assigned to:
- Subsequence `0` when the depth is even.
- Subsequence `1` when the depth is odd.

This distributes alternating nesting levels between the two subsequences.

## 🔄 Approach

1. Maintain the current nesting `depth`.
2. For an opening parenthesis `(`:
    - Increase `depth`.
    - Assign it using `depth % 2`.
3. For a closing parenthesis `)`:
    - Assign it using `depth % 2`.
    - Then decrease `depth`.
4. Return the resulting assignment array.

This effectively divides the nested levels between the two subsequences so that neither subsequence contains all the original nesting depth.

## 💻 Solution

See [Solution.java](./Solution.java).

## ⏱️ Complexity

- **Time:** O(n)
- **Space:** O(n) for the result array.

## 📌 Key Takeaway

Alternating assignments based on nesting-depth parity provide a simple greedy way to split a valid parentheses sequence while keeping the maximum depth balanced between the two subsequences.