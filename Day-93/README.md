# Day 93 — Climbing Stairs II

**LeetCode:** [3693. Climbing Stairs II](https://leetcode.com/problems/climbing-stairs-ii/)

**Difficulty:** Medium

**Topic:** Dynamic Programming, Array

## 🧠 Intuition

Each move can climb either 1, 2, or 3 stairs. Reaching stair `i` requires paying the cost of that stair along with the square of the jump distance.

To find the minimum total cost, we can use dynamic programming and consider all three possible previous positions for every stair.

## 🔄 Approach

**1. Initialize the DP Array**

- Create `f[]`, where `f[i]` represents the minimum cost to reach stair `i`.
- Initialize all positions to `Integer.MAX_VALUE`.
- Set `f[0] = 0`, since reaching the ground requires no cost.

**2. Calculate Minimum Cost**

For every stair `i` from `1` to `n`:

- Consider the previous positions `i - 1`, `i - 2`, and `i - 3`, ensuring the index is not negative.
- Calculate the jump distance as `i - j`.
- Update the minimum cost using:

`f[i] = min(f[i], f[j] + costs[i - 1] + jumpDist²)`

**3. Return the Result**

After processing all stairs, `f[n]` contains the minimum cost required to reach the top.

## 💻 Solution

See [Solution.java](./Solution.java).

## ⏱️ Complexity

Let `n` be the number of stairs.

- **Time:** O(n), since each stair considers at most three previous positions.
- **Space:** O(n), for the DP array.

## 📌 Key Takeaway

This problem demonstrates how to build a bottom-up DP solution by considering a limited set of previous states. Identifying the transition clearly makes the minimum-cost calculation straightforward.