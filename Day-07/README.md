# Day 7 — Stone Game IX

**LeetCode:** [2029. Stone Game IX](https://leetcode.com/problems/stone-game-ix/)

**Difficulty:** Medium

**Topic:** Math, Game Theory, Modulo

## 🧠 Intuition

The important observation is that only the **remainder when a stone is divided by 3** matters.

Every stone belongs to one of three groups:

- `num % 3 == 0`
- `num % 3 == 1`
- `num % 3 == 2`

We don't need the actual values of the stones.

The players lose when the running sum becomes divisible by `3`, so the game can be analyzed using only these three remainder groups.

The number of stones with remainder `0` affects how many times the game can alternate between the other two remainder groups.

This allows us to determine the winner without simulating every possible move.

## 🔄 Approach

I used **remainder counting and game theory**.

1. Count how many stones have remainder `0`, `1`, and `2` when divided by `3`.
2. If the number of remainder `0` stones is even:
    - Alice can win if there is at least one stone with remainder `1` and at least one stone with remainder `2`.
3. If the number of remainder `0` stones is odd:
    - Alice wins only when the difference between the number of remainder `1` and remainder `2` stones is greater than `2`.
4. Return the corresponding result.

## 💻 Solution

See [`Solution.java`](./Solution.java).

## ⏱️ Complexity

We traverse the array once to count the three remainder groups.

- **Time:** `O(n)`
- **Space:** `O(1)`

Only three counters are maintained regardless of the size of the input.

## 📌 Key Takeaway

The main idea I learned from this problem is:

> Sometimes a game involving large numbers can be simplified completely by looking at only their values modulo a small number.

This problem helped me understand how **modular arithmetic can simplify game theory problems**.