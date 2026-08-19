# Day 10 — Cinema Seat Allocation

**LeetCode:** [1386. Cinema Seat Allocation](https://leetcode.com/problems/cinema-seat-allocation/)

**Difficulty:** Medium

**Topic:** Arrays, HashMap, Bit Manipulation, Bitmask

## 🧠 Intuition

Each row can normally accommodate **two families of four**.

The only rows we need to worry about are the rows that contain reserved seats.

Since each row has only 10 seats, I can represent the reserved seats using a **bitmask**.

For every reserved seat `(row, col)`, I set the corresponding bit in that row's mask.

Then I check whether the three possible groups of four seats are available:

- Left block: `2, 3, 4, 5`
- Right block: `6, 7, 8, 9`
- Middle block: `4, 5, 6, 7`

## 🔄 Approach

I used a **HashMap + Bitmask** approach.

1. Store the reserved seats for each row in a `HashMap`.
2. Represent the reserved seats of each row using an integer bitmask.
3. Initially assume every row can accommodate two families:

   `n * 2`

4. For every row that has reserved seats, check whether the left, right, and middle blocks are available.
5. If both the left and right blocks are available, the row can still accommodate two families.
6. If at least one valid block is available, the row can accommodate one family.
7. If none of the blocks are available, the row cannot accommodate any family.
8. Adjust the initial answer accordingly.

Rows without any reserved seats don't need to be processed because they can always accommodate two families.

## 💻 Solution

See [`Solution.java`](./Solution.java).

## ⏱️ Complexity

Let `R` be the number of rows that contain reserved seats.

Each row requires only a constant amount of work because there are only 10 seats.

- **Time:** `O(R)` → `O(n)` in the worst case
- **Space:** `O(R)` → `O(n)` in the worst case

## 📌 Key Takeaway

The main idea I learned from this problem is:

> When a problem has a small fixed number of states, bitmasks can represent those states compactly and allow efficient bitwise operations.

This problem helped me practice **bit manipulation and using a bitmask to represent the state of each row**.