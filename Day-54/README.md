# Day 54 — Generate Parentheses

**LeetCode:** [22. Generate Parentheses](https://leetcode.com/problems/generate-parentheses/)

**Difficulty:** Medium

**Topic:** Backtracking, Recursion, String

## 🧠 Intuition

We need to generate all valid combinations of `n` pairs of parentheses.

During construction, we can make two choices:
- Add `(` as long as we have not used all `n` opening parentheses.
- Add `)` only when there are more opening parentheses than closing parentheses, ensuring the sequence remains valid.

Using backtracking, we build the string character by character and undo each choice after exploring it.

## 🔄 Approach

1. Maintain the number of opening and closing parentheses used.
2. If `open < n`, add `(` and recursively continue.
3. If `close < open`, add `)` and recursively continue.
4. When the string length reaches `2 * n`, add the generated combination to the result.
5. Remove the last character after each recursive call to backtrack and explore other possibilities.

## 💻 Solution

See [Solution.java](./Solution.java).

## ⏱️ Complexity

- **Time:** O(Cₙ · n), where `Cₙ` is the `n`th Catalan number.
- **Space:** O(n) for the recursion depth and current string, excluding the output.

## 📌 Key Takeaway

Backtracking is effective when we need to generate all valid combinations. By restricting `)` to cases where `close < open`, invalid parentheses sequences are avoided during construction rather than generated and filtered afterward.