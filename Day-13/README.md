# Day 13 — Check Divisibility by Digit Sum and Product

**LeetCode:** [3622. Check Divisibility by Digit Sum and Product](https://leetcode.com/problems/check-divisibility-by-digit-sum-and-product/)

**Difficulty:** Easy

**Topic:** Math, Digit Manipulation

## 🧠 Intuition

We need to check whether `n` is divisible by the sum of its digits plus the product of its digits.

For example, if:

`n = 123`

Then:

`digit sum = 1 + 2 + 3 = 6`

`digit product = 1 × 2 × 3 = 6`

So we check whether:

`123 % (6 + 6) == 0`

To extract each digit, I repeatedly use `% 10` and `/ 10`.

## 🔄 Approach

1. Initialize `digitsSum` to `0`.
2. Initialize `digitsProduct` to `1`.
3. Create a temporary variable `t = n`.
4. Extract the last digit using `t % 10`.
5. Add the digit to `digitsSum`.
6. Multiply the digit with `digitsProduct`.
7. Remove the last digit using `t /= 10`.
8. Repeat until all digits are processed.
9. Finally, check whether `n` is divisible by `digitsSum + digitsProduct`.

## 💻 Solution

See [`Solution.java`](./Solution.java).

## ⏱️ Complexity

If `d` is the number of digits in `n`:

- **Time:** `O(d)`
- **Space:** `O(1)`

## 📌 Key Takeaway

The main idea I learned from this problem is:

> Digit-based problems can often be solved efficiently by repeatedly using `% 10` to extract a digit and `/ 10` to remove it.

This problem helped me practice **digit manipulation and basic mathematical operations**.