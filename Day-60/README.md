# Day 60 — Remove Outermost Parentheses

**LeetCode:** [1021. Remove Outermost Parentheses](https://leetcode.com/problems/remove-outermost-parentheses/)

**Difficulty:** Easy

**Topic:** String, Stack, Parentheses

## 🧠 Intuition

A primitive valid parentheses string has one outermost pair of parentheses. The goal is to remove that outermost pair from every primitive component.

We can track the nesting depth while traversing the string. The outermost opening and closing parentheses of each primitive occur when the depth changes between `0` and `1`.

## 🔄 Approach

1. Start from the second character, skipping the first outermost `(`.
2. Maintain `open` to track the current nesting depth inside the primitive.
3. For an opening parenthesis `(`:
    - Increase `open`.
    - Add it to the result.
4. For a closing parenthesis `)`:
    - If `open == 0`, it is the outermost closing parenthesis, so skip it.
    - Otherwise, decrease `open` and add the parenthesis to the result.
5. Continue until the entire string is processed.

## 💻 Solution

See [Solution.java](./Solution.java).

## ⏱️ Complexity

- **Time:** O(n)
- **Space:** O(n) for the result string.

## 📌 Key Takeaway

Tracking the nesting depth allows us to identify the outermost parentheses of each primitive component and remove them in a single pass without explicitly splitting the string.