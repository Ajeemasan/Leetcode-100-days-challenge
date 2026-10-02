# Day 53 — Valid Parentheses

**LeetCode:** [20. Valid Parentheses](https://leetcode.com/problems/valid-parentheses/)

**Difficulty:** Easy

**Topic:** Stack, String

## 🧠 Intuition

A valid parentheses string must close brackets in the reverse order in which they were opened.

A stack naturally fits this **Last In, First Out (LIFO)** behavior. Whenever an opening bracket is encountered, push it onto the stack. For a closing bracket, the top of the stack must contain its corresponding opening bracket.

## 🔄 Approach

1. Create a stack to store opening brackets.
2. Traverse the string character by character.
3. If the character is an opening bracket `(`, `[`, or `{`, push it onto the stack.
4. For a closing bracket:
    - If the stack is empty, the string is invalid.
    - Check whether the top opening bracket matches the current closing bracket.
    - If it matches, pop it from the stack.
    - Otherwise, return `false`.
5. After processing the entire string, the stack must be empty for the parentheses to be valid.

## 💻 Solution

See [Solution.java](./Solution.java).

## ⏱️ Complexity

- **Time:** O(n)
- **Space:** O(n)

## 📌 Key Takeaway

When matching nested or paired elements, a stack is often the natural data structure because the most recently opened bracket must be the first one to be closed.