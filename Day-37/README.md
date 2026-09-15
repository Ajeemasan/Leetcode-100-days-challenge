# Day 37 — Maximum Number of Non-overlapping Palindrome Substrings

**LeetCode:** [2472. Maximum Number of Non-overlapping Palindrome Substrings](https://leetcode.com/problems/maximum-number-of-non-overlapping-palindrome-substrings/)

**Difficulty:** Hard

**Topic:** Dynamic Programming, Palindrome, Strings

## 🧠 Intuition

The goal is to select the maximum number of non-overlapping palindromic substrings with length at least `k`.

For each position, we can either skip the current character or take a valid palindrome ending at that position. Since only lengths `k` and `k + 1` need to be checked, we can efficiently build the answer using 1D DP.

## 🔄 Approach

- Use `dp[i]` to represent the maximum number of valid non-overlapping palindromes within the first `i` characters.
- At every position, first carry forward `dp[i - 1]`.
- Check whether the substring of length `k` ending at `i - 1` is a palindrome.
- Check whether the substring of length `k + 1` ending at `i - 1` is a palindrome.
- If valid, update the DP using the result before that substring.
- Use two pointers to verify whether each candidate substring is a palindrome.

## 💻 Solution

See [Solution.java](./Solution.java).

## ⏱️ Complexity

- **Time:** O(n²)
- **Space:** O(n)

## 📌 Key Takeaway

A useful pattern for interval-selection problems is to combine **1D DP with local validity checks**. By considering whether to skip or take a palindrome ending at each position, we can maximize the number of non-overlapping substrings.