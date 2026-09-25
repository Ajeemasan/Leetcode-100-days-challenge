# Day 47 — Brace Expansion II

**LeetCode:** [1096. Brace Expansion II](https://leetcode.com/problems/brace-expansion-ii/)

**Difficulty:** Hard

**Topic:** Recursion, Strings, TreeSet

## 🧠 Intuition

Brace expansion can be solved by repeatedly resolving the innermost brace expression.

For each brace group, split its contents by commas and recursively replace the group with each possible option. Eventually, all braces are removed and the generated expressions are added to a `TreeSet`, which automatically removes duplicates and keeps the results lexicographically sorted.

## 🔄 Approach

- Find the first closing brace `}`.
- Find the matching opening brace `{` using `lastIndexOf`.
- Extract the prefix, suffix, and comma-separated options inside the braces.
- Replace the brace group with each option and recursively process the resulting expression.
- When no braces remain, add the complete expression to a `TreeSet`.
- Convert the set to a list for the final result.

## 💻 Solution

See [Solution.java](./Solution.java).

## ⏱️ Complexity

- **Time:** O(E × L), where `E` is the number of generated expressions and `L` is their average length.
- **Space:** O(E × L), for storing the generated expressions and recursion state.

## 📌 Key Takeaway

Recursive expansion is a natural way to handle nested choices in string expressions. Using a **TreeSet** also simplifies the final step by handling both duplicate removal and lexicographical ordering automatically.