# Day 15 — Stone Game VIII

**LeetCode:** [1872. Stone Game VIII](https://leetcode.com/problems/stone-game-viii/)

**Difficulty:** Hard

**Topic:** Dynamic Programming, Prefix Sum, Game Theory

## 🧠 Intuition

In this game, the important observation is that after a player takes the first `i + 1` stones, all those stones are replaced by their total sum.

This means that instead of tracking every individual stone, we can work with **prefix sums**.

Let `prefix[i]` represent the sum of the first `i + 1` stones.

For a given prefix, the current player can choose it and leave the remaining game to the opponent.

The game can therefore be represented using a simple recurrence:

`current = prefix[i] - opponent`

We can work backwards and keep track of the best score difference that can be achieved from each position.

## 🔄 Approach

### 1. Calculate Prefix Sums

I calculate the prefix sums directly inside the `stones` array:

`stones[i] += stones[i - 1]`

This avoids creating an additional prefix array.

### 2. Start With the Last Prefix

The last possible move results in taking all remaining stones, so the initial score difference is:

`maxDiff = stones[n - 1]`

### 3. Work Backwards

Starting from `n - 2` down to `1`, I calculate:

`maxDiff = max(maxDiff, stones[i] - maxDiff)`

Here:

- `stones[i]` represents the score obtained by choosing that prefix.
- `maxDiff` represents the opponent's best possible score difference from the remaining game.

We take the maximum because each player plays optimally.

### 4. Return the Optimal Difference

After processing all possible prefixes, `maxDiff` represents the maximum score difference the first player can guarantee.

## 💻 Solution

See [`Solution.java`](./Solution.java).

## ⏱️ Complexity

We traverse the array once to calculate prefix sums and once backwards to calculate the optimal score difference.

- **Time:** `O(n)`
- **Space:** `O(1)`

The prefix sums are calculated in-place, so no additional prefix array is required.

## 📌 Key Takeaway

The main idea I learned from this problem is:

> In game problems, when both players play optimally, we can often define the state as the best score difference the current player can achieve.

Combining this idea with **prefix sums** allows the problem to be solved in `O(n)` time and `O(1)` extra space.