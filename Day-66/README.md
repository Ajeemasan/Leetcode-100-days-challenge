# Day 66 — Maximize Sum of Squares of Digits

**LeetCode:** [3723. Maximize Sum of Squares of Digits](https://leetcode.com/problems/maximize-sum-of-squares-of-digits/)

**Difficulty:** Medium

**Topic:** Greedy, Math, String

## 🧠 Intuition

To maximize the sum of squared digits while keeping the digit sum equal to `sum`, we should prioritize larger digits because their squares contribute more to the total.

The greedy strategy is to use as many `9`s as possible, followed by the remaining digit, and then fill the rest of the number with zeros.

## 🔄 Approach

1. Check whether `sum` is negative or exceeds the maximum possible digit sum, `num * 9`. If either condition holds, return an empty string.
2. Calculate how many `9`s can be formed using `sum / 9`.
3. Append those `9`s to the result.
4. Calculate the remaining digit using `sum % 9` and append it if it is greater than zero.
5. Append zeros until the string reaches the required length `num`.
6. Return the constructed string.

## 💻 Solution

See [Solution.java](./Solution.java).

## ⏱️ Complexity

- **Time:** O(num), since the result contains `num` digits.
- **Space:** O(num) for the resulting string.

## 📌 Key Takeaway

A greedy strategy maximizes the sum of squared digits by concentrating the available digit sum into the largest possible digits first. Filling the remaining positions with zeros satisfies the required length without reducing the result.