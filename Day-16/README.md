# Day 16 — Smallest Missing Multiple of K

**LeetCode:** [3718. Smallest Missing Multiple of K](https://leetcode.com/problems/smallest-missing-multiple-of-k/)

**Difficulty:** Easy

**Topic:** Arrays, HashSet, Math

## 🧠 Intuition

We need to find the smallest positive multiple of `k` that does not appear in `nums`.

Instead of checking every number in the array, I only care about numbers that are multiples of `k`.

I store all multiples of `k` that appear in the array inside a `HashSet`.

Then I start checking:

`k, 2k, 3k, 4k, ...`

The first multiple that is not present in the set is the answer.

## 🔄 Approach

1. Create a `HashSet` to store the multiples of `k` present in `nums`.
2. Traverse the array.
3. If `nums[i]` is divisible by `k`, add it to the set.
4. Start with `i = 1`.
5. Calculate the current multiple as `k * i`.
6. If the multiple is not present in the set, return it.
7. Otherwise, increment `i` and continue.

## 💻 Solution

See [`Solution.java`](./Solution.java).

## ⏱️ Complexity

Let `n` be the length of `nums`.

- **Time:** `O(n + m)`, where `m` is the number of multiples of `k` checked before finding the answer.
- **Space:** `O(n)` in the worst case.

## 📌 Key Takeaway

The main idea I learned from this problem is:

> When looking for a missing value from a specific set of candidates, store the relevant values in a `HashSet` and check the candidates efficiently.

This problem helped me practice **HashSet usage and simple mathematical reasoning**.