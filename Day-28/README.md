# Day 28 — Distinct Subsequences

**LeetCode:** [115. Distinct Subsequences](https://leetcode.com/problems/distinct-subsequences/)

**Difficulty:** Hard

**Topic:** Dynamic Programming, Strings, Space Optimization

## 🧠 Intuition

The goal is to count how many distinct subsequences of `s` can form the string `t`.

For every character in `s`, if it matches the current character in `t`, there are two choices:

- Use the character to match `t[j]`.
- Skip the character and continue searching for another match.

This gives the recurrence:

`dp[j] = dp[j] + dp[j - 1]`

where:

- `dp[j]` represents the number of ways to form the first `j` characters of `t`.
- `dp[j - 1]` represents the number of ways when the current character from `s` is used.

## 🔄 Approach

I used **Dynamic Programming with space optimization**.

1. Create a 1D DP array of size `n + 1`.
2. Set `dp[0] = 1` because there is exactly one way to form an empty string.
3. Iterate through every character of `s`.
4. Traverse `t` from right to left.
5. If the current characters match, update:

   `dp[j] = dp[j] + dp[j - 1]`

6. Traverse backwards so that `dp[j - 1]` still represents the value from the previous iteration.
7. The final answer is `dp[n]`.

## 💻 Solution

See [`Solution.java`](./Solution.java).

## ⏱️ Complexity

Let `m = s.length()` and `n = t.length()`.

- **Time:** `O(m × n)`
- **Space:** `O(n)`

## 📌 Key Takeaway

> When a DP state only depends on the current and previous values, a 2D DP table can often be optimized to a 1D array.

This problem helped me practice both the **subsequence DP pattern** and **space optimization**.