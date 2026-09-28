# Day 50 — Maximum Nesting Depth of the Parentheses

**LeetCode:** [1614. Maximum Nesting Depth of the Parentheses](https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/)

**Difficulty:** Easy

**Topic:** Stack, Strings

## 🧠 Intuition

The nesting depth represents the maximum number of opening parentheses that are active at the same time.

A stack can track the currently open parentheses. Whenever a closing parenthesis is encountered, the stack size before removing it represents the nesting depth at that point.

## 🔄 Approach

- Traverse the string from left to right.
- Push every opening parenthesis `(` onto the stack.
- When a closing parenthesis `)` is encountered, record the current stack size as the nesting depth.
- Pop the matching opening parenthesis.
- Keep track of the maximum depth encountered.

## 💻 Solution

See [Solution.java](./Solution.java).

## ⏱️ Complexity

- **Time:** O(n)
- **Space:** O(n)

## 📌 Key Takeaway

A **stack** provides a straightforward way to track nested parentheses. The current stack size directly represents how deeply nested the expression is at any point.