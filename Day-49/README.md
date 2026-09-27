# Day 49 — Reverse Substrings Between Each Pair of Parentheses

**LeetCode:** [1190. Reverse Substrings Between Each Pair of Parentheses](https://leetcode.com/problems/reverse-substrings-between-each-pair-of-parentheses/)

**Difficulty:** Medium

**Topic:** Stack, Strings

## 🧠 Intuition

Parentheses define sections of the string that need to be reversed. A stack naturally handles these nested sections because the most recently opened parenthesis is processed first.

Whenever a closing parenthesis is encountered, characters are popped until the matching opening parenthesis is reached. The popped characters are then pushed back in reversed order.

## 🔄 Approach

- Use a `Stack<Character>` to process the string from left to right.
- Push regular characters and opening parentheses onto the stack.
- When `)` is encountered, pop characters until `(` is found.
- Remove the opening parenthesis.
- Push the extracted characters back onto the stack, preserving the required reversal.
- After processing the entire string, pop the remaining characters and reverse the result to obtain the final string.

## 💻 Solution

See [Solution.java](./Solution.java).

## ⏱️ Complexity

- **Time:** O(n²) in the worst case due to repeatedly popping and pushing characters for nested parentheses.
- **Space:** O(n)

## 📌 Key Takeaway

A **stack** is a natural choice for problems involving nested parentheses because it follows the same last-in, first-out structure as nested expressions. Processing each closing parenthesis as a complete reversal operation simplifies the implementation.