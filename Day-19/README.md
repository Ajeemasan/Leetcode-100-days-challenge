# Day 19 — Lexicographically Smallest Palindromic Permutation Greater Than Target

**LeetCode:** [3734. Lexicographically Smallest Palindromic Permutation Greater Than Target](https://leetcode.com/problems/lexicographically-smallest-palindromic-permutation-greater-than-target/)

**Difficulty:** Hard

**Topic:** Greedy, Strings, Frequency Counting, Palindrome, Backtracking

## 🧠 Intuition

A palindrome is completely determined by its first half and its middle character (if the length is odd).

So instead of constructing the entire palindrome directly, I only need to determine the correct **left half**.

First, I count the frequency of every character in `s`.

For a valid palindrome:

- Every character must have an even frequency.
- At most one character can have an odd frequency.
- Half of each character's frequency belongs to the left half.

I then try to construct the left half so that the resulting palindrome is as close as possible to `target`, while still being strictly greater.

The key idea is to match `target` from left to right whenever possible. If I cannot continue matching, I try to place the smallest character greater than the current target character.

If that is not possible, I **roll back from the right** and try increasing an earlier position.

## 🔄 Approach

1. Count the frequency of every character in `s`.
2. Check whether a palindrome can be constructed.
    - If more than one character has an odd frequency, return `""`.
3. Build the frequency table for the left half by taking half of every character's frequency.
4. Try to match the first half of `target` from left to right.
5. At each position:
    - If the target character is available, use it.
    - Otherwise, try to use the smallest available character greater than the target character.
6. If a greater character is found:
    - Place it at the current position.
    - Fill all remaining positions with the smallest available characters.
    - Construct the palindrome and return it.
7. If no greater character is available, perform a right-to-left rollback.
8. During rollback:
    - Restore the previously used character.
    - Try to replace it with the smallest available character greater than it.
    - Fill the remaining positions with the smallest characters.
9. Mirror the left half around the middle character to construct the final palindrome.
10. If no valid palindrome greater than `target` exists, return `""`.

## 💻 Solution

See [`Solution.java`](./Solution.java).

## ⏱️ Complexity

Let `n` be the length of the string.

The alphabet contains only 26 lowercase English characters.

- **Time:** `O(26n)`
- **Space:** `O(n + 26)`

Since the alphabet size is fixed, the time complexity can effectively be considered `O(n)`.

## 📌 Key Takeaway

The main idea I learned from this problem is:

> When constructing the smallest value greater than a target, try to keep the prefix identical for as long as possible and make the smallest possible increase at the latest position.

For palindromes, working with only the **left half** greatly simplifies the problem because the other half is completely determined by mirroring it.