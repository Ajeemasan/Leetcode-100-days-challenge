# Day 72 — Sum of Sortable Integers

**LeetCode:** [3886. Sum of Sortable Integers](https://leetcode.com/problems/sum-of-sortable-integers/)

**Difficulty:** Medium

**Topic:** Array, Math, Divisors, Sorting

## 🧠 Intuition

The goal is to find all valid block sizes that allow the array to be sorted by independently sorting consecutive blocks of that size, then return the sum of those sizes.

A valid block size must divide the array length evenly. For each possible block size, we can check whether every block can be sorted independently and whether the resulting blocks remain correctly ordered relative to one another.

## 🔄 Approach

1. Find all divisors of the array length `n` by iterating from `1` to \(\sqrt{n}\). Add both `i` and `n / i` when they are distinct divisors.
2. For each divisor `k`, call `isValidBlockSize()` to verify whether it is a valid block size.
3. Within each block:
    - Track its minimum and maximum values.
    - Count the descending transitions, including the transition from the block's last element back to its first.
    - Reject the block size if there is more than one descending transition.
4. Ensure each block's minimum is at least the maximum of the preceding block.
5. If the block size passes all checks, add it to the total sum.
6. Return the sum of all valid block sizes.

## 💻 Solution

See [Solution.java](./Solution.java).

## ⏱️ Complexity

- **Time:** O(n × d(n)), where \(d(n)\) is the number of divisors of `n`. Each candidate block size requires O(n) time to validate.
- **Space:** O(d(n)) to store the divisors.

## 📌 Key Takeaway

Checking only the divisors of the array length reduces the candidate block sizes. Validating each block's ordering and its relationship with the previous block provides a structured way to determine which block sizes work.