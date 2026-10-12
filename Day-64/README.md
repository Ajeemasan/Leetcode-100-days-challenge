# Day 64 — Apply Operations on Array to Maximize Sum of Squares

**LeetCode:** [2897. Apply Operations on Array to Maximize Sum of Squares](https://leetcode.com/problems/apply-operations-on-array-to-maximize-sum-of-squares/)

**Difficulty:** Medium

**Topic:** Greedy, Bit Manipulation, Array

## 🧠 Intuition

The goal is to maximize the sum of squares of `k` numbers formed using the available elements' set bits.

Since squaring larger numbers increases the sum more significantly, we want to construct numbers with as many set bits as possible.

By counting how many elements contain each bit, we can greedily build each number using every bit that is still available, then decrement the corresponding bit counts.

## 🔄 Approach

1. Initialize a `bitCounts` array to track how many elements have each of the 30 bits set.
2. Traverse the input list and count the set bits in every number.
3. Repeat the following process `k` times:
    - Construct a number by setting every bit whose count is greater than zero.
    - Decrease the count of each bit used in the constructed number.
    - Add the square of the constructed number to the result, taking the modulo \(10^9 + 7\).
4. Return the accumulated sum modulo \(10^9 + 7\).

## 💻 Solution

See [Solution.java](./Solution.java).

## ⏱️ Complexity

- **Time:** O(n × B + k × B), where `n` is the number of elements and `B = 30` is the number of bits considered.
- **Space:** O(B), which is O(1) because the bit count array has a fixed size.

## 📌 Key Takeaway

Bit manipulation and greedy construction can maximize the sum of squares without explicitly simulating every array operation. Counting available set bits lets us repeatedly build the largest possible numbers while efficiently tracking which bits remain.