# Day 100 — Minimum Changes to Make K Semi-palindromes

**LeetCode:** [2911. Minimum Changes to Make K Semi-palindromes](https://leetcode.com/problems/minimum-changes-to-make-k-semi-palindromes/)

**Difficulty:** Hard

**Topic:** String, Dynamic Programming, Precomputation, Number Theory

## 🧠 Intuition

We need to divide the string into exactly `k` substrings, each having a length of at least 2, and minimize the total character changes required to make every substring semi-palindromic.

A substring is semi-palindromic if there exists a proper divisor `d` of its length such that its characters form palindromes when grouped by their positions modulo `d`.

We can break the problem into two stages:

1. Precompute the minimum changes required to make every possible substring semi-palindromic.
2. Use dynamic programming to find the minimum cost of partitioning the entire string into exactly `k` valid substrings.

## 🔄 Approach

**1. Precompute Divisors**

- For every possible substring length, calculate its proper divisors.
- Store these divisors in lists to avoid repeatedly calculating them.

**2. Calculate Substring Costs**

- Build a `cost[][]` array where `cost[i][j]` represents the minimum changes needed to make substring `s[i...j]` semi-palindromic.
- For each substring, iterate through its proper divisors.
- For every divisor `d`, compare characters belonging to the same modulo-`d` group from opposite ends.
- Each mismatched pair requires one character change.
- Store the minimum mismatch count across all valid divisors.

**3. Dynamic Programming**

Define `dp[i][parts]` as the minimum changes required to partition the first `i` characters into exactly `parts` semi-palindromic substrings.

- Initialize `dp[0][0] = 0`.
- Each substring must contain at least two characters.
- Try every valid previous partition point `p`.
- Update the transition:

`dp[i][parts] = min(dp[i][parts], dp[p][parts - 1] + cost[p][i - 1])`

**4. Return the Result**

After considering all valid partitions, return `dp[n][k]`.

## 💻 Solution

See [Solution.java](./Solution.java).

## ⏱️ Complexity

Let `n` be the length of the string.

- **Time:** O(n⁴ log n) in the worst case for the given implementation, including substring-cost precomputation and partition DP.
- **Space:** O(n² + nk), for the substring cost table, divisor lists, and DP table.

## 📌 Key Takeaway

This problem combines number theory and dynamic programming. Precomputing the cost of transforming every possible substring allows the partitioning problem to become a straightforward DP over prefix positions.

## 🎯 Milestone: 100 Days of LeetCode Completed!

100 days of consistent problem-solving, exploring different algorithms, and strengthening problem-solving intuition.

From basic array traversals to advanced combinations of dynamic programming, graphs, heaps, sliding windows, and monotonic data structures, this journey has been about learning how to approach unfamiliar problems rather than simply increasing the solved count.

The biggest lesson: **Consistency builds progress, but understanding builds problem-solving ability.**

100 days completed. The learning continues.