# Day 76 — Count Days Spent Together

**LeetCode:** [2409. Count Days Spent Together](https://leetcode.com/problems/count-days-spent-together/)

**Difficulty:** Easy

**Topic:** Array, String, Date Conversion, Math

## 🧠 Intuition

To find how many days Alice and Bob spend together, we need to calculate the overlap between their arrival and departure intervals.

Since the dates are given in `MM-DD` format and the problem assumes a non-leap year, we can convert each date into its day number within the year. This makes comparing dates and calculating the overlap straightforward.

## 🔄 Approach

1. Store the number of days in each month in an array.
2. Convert Alice's and Bob's arrival and departure dates into day-of-year values using `dateToDay()`.
3. Find the later arrival day using `Math.max()` to determine the overlap's start.
4. Find the earlier departure day using `Math.min()` to determine the overlap's end.
5. If the overlap's start is less than or equal to its end, return the difference plus one to count both endpoints. Otherwise, return `0`.

## 💻 Solution

See [Solution.java](./Solution.java).

## ⏱️ Complexity

- **Time:** O(1), since each date conversion iterates through at most 11 months.
- **Space:** O(1), since only a fixed-size month array and a constant number of variables are used.

## 📌 Key Takeaway

Converting dates into a common numerical representation simplifies interval-overlap problems. The general formula is:

`overlap = max(0, min(endAlice, endBob) - max(startAlice, startBob) + 1)`

The `+1` is essential because both arrival and departure days are inclusive.