# Day 1 — Stone Game IV

**LeetCode:** [1510. Stone Game IV](https://leetcode.com/problems/stone-game-iv/)

**Difficulty:** Hard

**Topic:** Dynamic Programming, Recursion, Memoization

## 🧠 Intuition

At each turn, Alice can remove any perfect square that is less than or equal to the remaining number of stones.

The important observation is that we don't need to know the entire sequence of moves.

For any number `n`:

* If there is at least one square `x²` such that the position `n - x²` is a losing position, then `n` is a winning position.
* If every possible move leads to a winning position for the opponent, then `n` is a losing position.

The base case is:

`n = 0` → the current player cannot make a move, so the current player loses.

## 🔄 Approach

I used **top-down dynamic programming with memoization**.

1. Generate all perfect squares less than or equal to `n`.
2. Define `solve(n)` as whether the current player can win when `n` stones remain.
3. Try removing every possible perfect square.
4. If `solve(n - square)` is `false`, the opponent loses from that position, so the current player wins.
5. Store the result in `dp[n]` so that the same state is not solved repeatedly.

## 💻 Solution

See [`Solution.java`](./Solution.java).

## ⏱️ Complexity

There are `n` possible DP states.

For each state, we may try up to `√n` perfect squares.

* **Time:** `O(n√n)`
* **Space:** `O(n)`

The recursion stack can also grow up to `O(n)` in the worst case.

## 📌 Key Takeaway

The main idea I learned from this problem is:

> To determine whether a player can win, look for at least one move that puts the opponent in a losing state.

This is a common pattern in **Game Theory + Dynamic Programming** problems.
