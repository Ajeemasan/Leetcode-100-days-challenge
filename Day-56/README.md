# Day 56 — Valid Parenthesis String

**LeetCode:** [678. Valid Parenthesis String](https://leetcode.com/problems/valid-parenthesis-string/)

**Difficulty:** Medium

**Topic:** Greedy, String, Parentheses

## 🧠 Intuition

The `*` character can act as `(`, `)`, or an empty character. Instead of trying all possibilities, we can track the possible range of unmatched opening parentheses.

- `minOpen` represents the minimum possible number of unmatched opening parentheses.
- `maxOpen` represents the maximum possible number of unmatched opening parentheses.

For `*`, the minimum can decrease by one while the maximum increases by one, representing its different possible interpretations.

## 🔄 Approach

1. Initialize `minOpen` and `maxOpen` to `0`.
2. Traverse the string from left to right.
3. For `(`, increment both bounds.
4. For `)`, decrement both bounds.
5. For `*`:
    - Decrement `minOpen`, treating it as `)`.
    - Increment `maxOpen`, treating it as `(`.
6. If `maxOpen < 0`, there are more closing parentheses than can possibly be matched, so return `false`.
7. If `minOpen < 0`, reset it to `0` because the number of unmatched opening parentheses cannot be negative.
8. At the end, the string is valid if `minOpen == 0`.

## 💻 Solution

See [Solution.java](./Solution.java).

## ⏱️ Complexity

- **Time:** O(n)
- **Space:** O(1)

## 📌 Key Takeaway

When a character has multiple possible interpretations, tracking a range of possible states can avoid expensive backtracking. Here, maintaining the minimum and maximum possible unmatched opening parentheses gives an efficient greedy solution.