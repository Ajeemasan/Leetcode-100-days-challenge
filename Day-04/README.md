# Day 4 — Longest Substring of One Repeating Character

**LeetCode:** [2213. Longest Substring of One Repeating Character](https://leetcode.com/problems/longest-substring-of-one-repeating-character/)

**Difficulty:** Hard

**Topic:** Segment Tree, Range Query, Point Update

## 🧠 Intuition

The string changes after every query because one character at a specific index is replaced.

After each update, we need to find the length of the longest substring containing only one repeating character.

Rechecking the entire string after every update would be too slow.

The important observation is that each query changes only **one position** in the string.

So, instead of recalculating the answer for the entire string, I can use a **Segment Tree** to store useful information about different segments of the string.

For every segment, I store:

* The character at the left boundary
* The character at the right boundary
* The longest repeating prefix
* The longest repeating suffix
* The longest repeating substring inside the segment
* The length of the segment

This information is enough to combine two adjacent segments and calculate the answer for their parent segment.

## 🔄 Approach

I used a **Segment Tree with point updates**.

1. Build a Segment Tree from the original string.
2. For every node, store information about its corresponding segment.
3. For a leaf node, the segment contains only one character, so its prefix, suffix, and best length are all `1`.
4. When merging two adjacent segments:

    * The left character comes from the left segment.
    * The right character comes from the right segment.
    * The prefix can extend into the right segment if the entire left segment contains the same character and both boundary characters match.
    * Similarly, the suffix can extend into the left segment.
    * The best answer is the maximum of the best answers from both segments and any repeating substring crossing their boundary.
5. For each query, update the changed index using the Segment Tree.
6. The root node represents the entire string, so `tree[1].best` gives the longest repeating substring after each update.

## 💻 Solution

See [`Solution.java`](./Solution.java).

## ⏱️ Complexity

Building the Segment Tree takes `O(n)` time.

Each character update requires traversing one path from the root to a leaf and merging the affected nodes.

* **Time:** `O(n + q log n)`
* **Space:** `O(n)`

where `n` is the length of the string and `q` is the number of queries.

## 📌 Key Takeaway

The main idea I learned from this problem is:

> A Segment Tree can store carefully chosen information about each segment so that a single point update can be propagated efficiently without recalculating the entire string.

This problem helped me understand how **Segment Trees can be used for dynamic range information with point updates**.
