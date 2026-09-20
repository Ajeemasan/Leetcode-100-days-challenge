# Day 42 — Reverse Degree of a String

**LeetCode:** [3498. Reverse Degree of a String](https://leetcode.com/problems/reverse-degree-of-a-string/)

**Difficulty:** Easy

**Topic:** Strings, Arrays, Implementation

## 🧠 Intuition

The reverse degree of a character is based on its position in the reversed alphabet, where `a = 26`, `b = 25`, ..., `z = 1`.

For each character, multiply its reverse-alphabet value by its 1-based position in the string and add it to the total degree.

## 🔄 Approach

- Create an array of size `26` to store the reverse-alphabet value of each character.
- Assign `26` to `a`, `25` to `b`, and so on until `1` for `z`.
- Traverse the string from left to right.
- For each character, multiply its reverse value by its 1-based index.
- Add the result to the total reverse degree.

## 💻 Solution

See [Solution.java](./Solution.java).

## ⏱️ Complexity

- **Time:** O(n)
- **Space:** O(1)

## 📌 Key Takeaway

Simple string problems can often be solved cleanly by mapping each character to its required numerical value and processing the string in a single pass.