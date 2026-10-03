# Day 55 — Longest Valid Parentheses

**LeetCode:** [32. Longest Valid Parentheses](https://leetcode.com/problems/longest-valid-parentheses/)

**Difficulty:** Hard

**Topic:** Stack, String, Parentheses

## 🧠 Intuition

The key is to track the indices that can act as boundaries for valid parentheses substrings.

A stack stores indices of unmatched opening parentheses. We start with `-1` as a base index, which allows us to calculate the length of a valid substring directly using index differences.

Whenever a closing parenthesis matches an opening parenthesis, the current valid length is `i - stack.peek()`.

## 🔄 Approach

1. Initialize a stack and push `-1` as the base index.
2. Traverse the string from left to right.
3. For `(`, push its index onto the stack.
4. For `)`:
    - Pop the top element.
    - If the stack becomes empty, push the current index as the new boundary.
    - Otherwise, calculate the current valid length as `i - stack.peek()` and update the maximum.
5. Return the maximum length found.

## 💻 Solution

See [Solution.java](./Solution.java).

## ⏱️ Complexity

- **Time:** O(n)
- **Space:** O(n)

## 📌 Key Takeaway

When finding the longest valid parentheses substring, storing indices in a stack allows us to track unmatched boundaries and calculate valid substring lengths efficiently in a single pass.