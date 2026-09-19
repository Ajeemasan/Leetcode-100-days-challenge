# Day 41 — Circle and Rectangle Overlapping

**LeetCode:** [1401. Circle and Rectangle Overlapping](https://leetcode.com/problems/circle-and-rectangle-overlapping/)

**Difficulty:** Medium

**Topic:** Geometry, Math

## 🧠 Intuition

A circle overlaps a rectangle if the distance between the circle's center and the closest point on the rectangle is less than or equal to the circle's radius.

The closest point can be found by clamping the circle's center coordinates to the rectangle's boundaries.

## 🔄 Approach

- Find the closest `x` coordinate on the rectangle to the circle's center.
- Find the closest `y` coordinate in the same way.
- Calculate the squared Euclidean distance between the circle's center and this closest point.
- Compare the squared distance with the squared radius.
- If the distance is less than or equal to the radius, the circle and rectangle overlap.

## 💻 Solution

See [Solution.java](./Solution.java).

## ⏱️ Complexity

- **Time:** O(1)
- **Space:** O(1)

## 📌 Key Takeaway

For geometry problems, finding the **closest point** between two shapes can simplify intersection checks significantly. Using squared distances also avoids unnecessary square-root calculations.