# Day 58 — Minimum Add to Make Parentheses Valid

**LeetCode:** [921. Minimum Add to Make Parentheses Valid](https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/)

**Difficulty:** Medium

**Topic:** Greedy, String, Parentheses

## 🧠 Intuition

A valid parentheses string can never have more closing parentheses than opening parentheses at any point.

We can track the number of unmatched opening parentheses using `open`. Whenever a closing parenthesis makes `open` negative, it means there is no available opening parenthesis to match it, so one opening parenthesis must be added.

After processing the string, any remaining unmatched opening parentheses also need corresponding closing parentheses.

## 🔄 Approach

1. Maintain `open` as the number of unmatched opening parentheses.
2. Traverse the string from left to right.
3. For `(`, increment `open`.
4. For `)`, decrement `open`.
5. If `open` becomes negative:
    - Add one to the answer because an opening parenthesis is needed.
    - Reset `open` to `0`.
6. After the traversal, add the remaining `open` value to the answer because each unmatched `(` needs one `)`.

## 💻 Solution

See [Solution.java](./Solution.java).

## ⏱️ Complexity

- **Time:** O(n)
- **Space:** O(1)

## 📌 Key Takeaway

Instead of explicitly adding parentheses, we can count the unmatched parentheses that must be added. Tracking the balance greedily gives a simple one-pass solution with constant extra space.