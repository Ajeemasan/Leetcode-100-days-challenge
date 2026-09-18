# Day 40 — Maximum Number of Non-Overlapping Substrings

**LeetCode:** [1520. Maximum Number of Non-Overlapping Substrings](https://leetcode.com/problems/maximum-number-of-non-overlapping-substrings/)

**Difficulty:** Medium

**Topic:** Greedy, Strings, Intervals

## 🧠 Intuition

For each character, find its first and last occurrence. A valid substring must contain every occurrence of every character that appears inside it.

Starting from the first occurrence of a character, we expand the interval whenever we encounter a character whose last occurrence extends beyond the current boundary. If we encounter a character whose first occurrence is before the starting position, the interval is invalid.

Among valid intervals, choosing the smaller ending interval allows us to keep more non-overlapping substrings.

## 🔄 Approach

- Store the first and last occurrence of every character.
- Consider only positions that are the first occurrence of their character.
- Use `isValid()` to expand the substring until all characters inside it are fully contained.
- If a character inside the interval started before the current position, the interval is invalid.
- Maintain the end of the previously selected interval.
- If a new valid interval overlaps the previous one, replace the previous substring with the smaller valid interval.
- Otherwise, add the new substring to the result.

## 💻 Solution

See [Solution.java](./Solution.java).

## ⏱️ Complexity

- **Time:** O(26 × n), which is effectively O(n) since there are only 26 lowercase letters.
- **Space:** O(26), excluding the output list.

## 📌 Key Takeaway

For substring and interval problems, tracking the **first and last occurrence of each character** can turn a complicated search into an interval-based greedy problem. Choosing the smallest valid intervals helps maximize the number of non-overlapping substrings.