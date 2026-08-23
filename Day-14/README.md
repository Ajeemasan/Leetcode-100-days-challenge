# Day 14 — Sum Game

**LeetCode:** [1927. Sum Game](https://leetcode.com/problems/sum-game/)

**Difficulty:** Medium

**Topic:** Math, Game Theory, Greedy

## 🧠 Intuition

The string is divided into two equal halves.

Alice and Bob take turns replacing the `?` characters with digits. Alice wants the final sums of both halves to be different, while Bob wants them to be equal.

Instead of considering every possible digit assignment, we can look at:

- The current digit sum of each half.
- The number of `?` characters in each half.

If the total number of `?` characters is odd, Alice always has the advantage because she gets the final move.

When the number of `?` characters is even, we can determine the result mathematically by comparing the current difference between the two halves with the maximum possible contribution from the remaining `?` characters.

## 🔄 Approach

1. Split the string into two equal halves.
2. Count the number of `?` characters in each half:
    - `q1` → number of `?` in the first half.
    - `q2` → number of `?` in the second half.
3. Calculate the sum of the known digits:
    - `s1` → sum of known digits in the first half.
    - `s2` → sum of known digits in the second half.
4. If `(q1 + q2)` is odd, return `true` because Alice can always force the sums to be different.
5. Otherwise, check whether:

   `2 * (s1 - s2) != (q2 - q1) * 9`

6. If the equation is not balanced, Alice can force a different sum.
7. If it is balanced, Bob can make the two sums equal.

## 💻 Solution

See [`Solution.java`](./Solution.java).

## ⏱️ Complexity

We traverse the string once to calculate the digit sums and the number of question marks.

- **Time:** `O(n)`
- **Space:** `O(1)`

## 📌 Key Takeaway

The main idea I learned from this problem is:

> Some game problems can be solved by finding a mathematical condition instead of simulating every possible move.

This problem helped me practice **game theory, mathematical reasoning, and deriving conditions from the possible moves**.