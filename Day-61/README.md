# Day 61 — Minimum Insertions to Balance a Parentheses String

**LeetCode:** [1541. Minimum Insertions to Balance a Parentheses String](https://leetcode.com/problems/minimum-insertions-to-balance-a-parentheses-string/)

**Difficulty:** Medium

**Topic:** Greedy, String, Parentheses

## 🧠 Intuition

Each opening parenthesis `(` must be matched with **two consecutive closing parentheses `))`**.

Instead of explicitly building the balanced string, we can track how many closing parentheses are still needed using `needed`. The variable `insertions` counts the extra parentheses required to make the string valid.

The key observation is that the number of closing parentheses needed must remain even whenever we encounter a new opening parenthesis.

## 🔄 Approach

1. Initialize `insertions` and `needed` to `0`.
2. Traverse the string from left to right.
3. When encountering `(`:
    - If `needed` is odd, insert one `)` to complete the previous pair and decrease `needed` by one.
    - Increase `needed` by two for the new opening parenthesis.
4. When encountering `)`:
    - Decrease `needed` by one.
    - If `needed` becomes negative, insert one `(`, increase `insertions` by one, and add two to `needed` to account for the required closing parentheses.
5. After processing the string, add the remaining `needed` to `insertions`.

## 💻 Solution

See [Solution.java](./Solution.java).

## ⏱️ Complexity

- **Time:** O(n)
- **Space:** O(1)

## 📌 Key Takeaway

Greedy counting can solve parentheses-balancing problems without using a stack. By tracking the number of closing parentheses still required and correcting invalid states immediately, we can find the minimum insertions in a single pass.