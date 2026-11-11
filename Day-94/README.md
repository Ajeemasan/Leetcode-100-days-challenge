# Day 94 — Minimum Cost to Acquire Required Items

**LeetCode:** [3789. Minimum Cost to Acquire Required Items](https://leetcode.com/problems/minimum-cost-to-acquire-required-items/)

**Difficulty:** Easy

**Topic:** Math, Greedy, Enumeration

## 🧠 Intuition

We need to satisfy the required quantities of two item types while minimizing the total cost.

Since buying a combined item can satisfy both requirements simultaneously, we can evaluate different purchasing strategies and choose the cheapest one.

## 🔄 Approach

Consider three possible strategies:

**1. Buy Both Types Separately**

Purchase exactly `need1` items of type 1 and `need2` items of type 2.

`a = need1 * cost1 + need2 * cost2`

**2. Buy Only Combined Items**

Purchase enough combined items to satisfy the larger requirement.

`b = max(need1, need2) * costBoth`

**3. Combine Shared Requirements with Separate Items**

- Use combined items to satisfy the overlapping requirement, `min(need1, need2)`.
- Purchase the remaining items separately for whichever type has a higher requirement.

`c = min(need1, need2) * costBoth + (need1 - mn) * cost1 + (need2 - mn) * cost2`

Finally, return the minimum among the three strategies.

## 💻 Solution

See [Solution.java](./Solution.java).

## ⏱️ Complexity

- **Time:** O(1), since only three purchasing strategies are evaluated.
- **Space:** O(1), as only a constant number of variables are used.

## 📌 Key Takeaway

A greedy comparison of a few carefully chosen purchasing strategies can eliminate the need for complex algorithms. Identifying overlapping requirements helps simplify cost-optimization problems.