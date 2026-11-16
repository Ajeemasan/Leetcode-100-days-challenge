# Day 99 — Calculate Digit Sum of a String

**LeetCode:** [2243. Calculate Digit Sum of a String](https://leetcode.com/problems/calculate-digit-sum-of-a-string/)

**Difficulty:** Easy

**Topic:** String, Simulation, StringBuilder

## 🧠 Intuition

We repeatedly divide the string into consecutive groups of `k` characters and replace each group with the sum of its digits.

We continue this process until the resulting string contains at most `k` characters.

## 🔄 Approach

**1. Process Groups of K Characters**

- Continue iterating while `s.length() > k`.
- Divide the current string into groups of at most `k` characters.
- Maintain a running `sum` for each group.

**2. Build the Next String**

- When a new group begins (`i % k == 0`), append the previous group's sum to the `StringBuilder`.
- Reset the sum using the current digit.
- For other characters, add their digit values to the running sum.
- Append the final group's sum after completing the traversal.

**3. Repeat Until Completion**

Convert the `StringBuilder` into a string and repeat until its length is at most `k`.

Return the final string.

## 💻 Solution

See [Solution.java](./Solution.java).

## ⏱️ Complexity

Let `n` be the initial length of the string.

- **Time:** O(n logₖ n), since each iteration reduces the string length by approximately a factor of `k`.
- **Space:** O(n), for the intermediate strings and `StringBuilder`.

## 📌 Key Takeaway

This problem demonstrates string simulation using `StringBuilder`. Breaking a transformation into repeated group-processing steps makes the implementation simple and easy to follow.