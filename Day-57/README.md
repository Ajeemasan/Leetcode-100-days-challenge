# Day 57 — Score of Parentheses

**LeetCode:** [856. Score of Parentheses](https://leetcode.com/problems/score-of-parentheses/)

**Difficulty:** Medium

**Topic:** Stack, String, Parentheses

## 🧠 Intuition

The score of a valid parentheses string follows two rules:

- `()` has a score of `1`.
- `(A)` has a score of `2 * score(A)`.
- `AB` has a score of `score(A) + score(B)`.

A stack can keep track of the score being built at each level of nested parentheses.

## 🔄 Approach

1. Initialize a stack with `0` representing the score at the outermost level.
2. For an opening parenthesis `(`, push `0` to start a new nested level.
3. For a closing parenthesis `)`:
    - Pop the score of the current level.
    - If the score is `0`, the pair is `()`, so its score is `1`.
    - Otherwise, the pair contains a nested expression, so its score is `2 * innerScore`.
    - Add this score to the parent level.
4. After processing the entire string, the remaining stack value is the total score.

## 💻 Solution

See [Solution.java](./Solution.java).

## ⏱️ Complexity

- **Time:** O(n)
- **Space:** O(n)

## 📌 Key Takeaway

A stack can represent nested levels and maintain partial results for each level. By processing a closing parenthesis, we can immediately convert the completed nested block into its corresponding score.