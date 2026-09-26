# Day 48 — Evaluate the Bracket Pairs of a String

**LeetCode:** [1807. Evaluate the Bracket Pairs of a String](https://leetcode.com/problems/evaluate-the-bracket-pairs-of-a-string/)

**Difficulty:** Medium

**Topic:** Strings, HashMap, StringBuilder

## 🧠 Intuition

Each bracket pair represents a key that needs to be replaced by its corresponding value from the knowledge list.

A `HashMap` provides efficient key-value lookup, while a single traversal of the string lets us process each bracketed key and build the final result.

## 🔄 Approach

- Store all key-value pairs from `knowledge` in a `HashMap`.
- Traverse the string from left to right.
- When `(` is encountered, find the corresponding `)`.
- Extract the key between the brackets.
- Look up the key in the map and append its value to the result.
- If the key does not exist, append `?`.
- Otherwise, append regular characters directly to the result.
- Use `StringBuilder` to construct the final string efficiently.

## 💻 Solution

See [Solution.java](./Solution.java).

## ⏱️ Complexity

- **Time:** O(n + K), where `n` is the string length and `K` represents the total characters processed while extracting bracketed keys.
- **Space:** O(m + n), where `m` is the number of knowledge pairs and `n` is the output size.

## 📌 Key Takeaway

A combination of **HashMap lookup and string traversal** is often enough for key-value replacement problems. Using `StringBuilder` keeps the construction of the final string efficient and clean.