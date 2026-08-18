# Day 8 — Stone Game V

**LeetCode:** [1563. Stone Game V](https://leetcode.com/problems/stone-game-v/)

**Difficulty:** Hard

**Topic:** Dynamic Programming, Recursion, Memoization, Prefix Sum

## 🧠 Intuition

At each step, Alice can split the current range of stones into two non-empty parts.

She compares the sum of the left and right parts:

- If `left < right`, Alice keeps the left part and gains `left`.
- If `right < left`, Alice keeps the right part and gains `right`.
- If `left == right`, Alice can choose either part.

The main challenge is that the same subranges can be reached through different splits.

So instead of solving the same range repeatedly, I store the answer for every range `[s, e]`.

This gives us the DP state:

`dp[s][e]` → maximum score Alice can obtain from the subarray `s...e`.

## 🔄 Approach

I used **top-down dynamic programming with memoization** and **prefix sums**.

1. Build a prefix sum array so that the sum of any subarray can be calculated in `O(1)`.
2. Define `solve(s, e)` as the maximum score Alice can obtain from the range `s...e`.
3. Try every possible split position `i` between `s` and `e`.
4. Calculate the left and right sums using the prefix sum array.
5. If the left sum is smaller, Alice keeps the left part and gains the left sum.
6. If the right sum is smaller, Alice keeps the right part and gains the right sum.
7. If both sums are equal, Alice can choose either side, so consider both possibilities.
8. Store the result in `dp[s][e]` to avoid solving the same range repeatedly.

The base case is:

`s == e` → only one stone remains, so Alice cannot split it and gains `0`.

## 💻 Solution

See [`Solution.java`](./Solution.java).

## ⏱️ Complexity

There are `O(n²)` possible subarrays.

For each subarray, we try every possible split, which can take `O(n)` time.

- **Time:** `O(n³)`
- **Space:** `O(n²)`

The prefix sum array requires an additional `O(n)` space, and the recursion stack can grow up to `O(n)`.

## 📌 Key Takeaway

The main idea I learned from this problem is:

> When a problem repeatedly asks us to make decisions on subarrays, defining the DP state using the range boundaries can help us solve it systematically.

Using **prefix sums** makes calculating the sum of each possible split efficient, while **memoization** prevents the same subproblem from being solved repeatedly.

This problem helped me practice **interval DP, prefix sums, and recursive memoization**.
