# Day 12 — Kth Smallest Amount With Single Denomination Combination

**LeetCode:** [3116. Kth Smallest Amount With Single Denomination Combination](https://leetcode.com/problems/kth-smallest-amount-with-single-denomination-combination/)

**Difficulty:** Hard

**Topic:** Binary Search, Inclusion-Exclusion, Bit Manipulation, GCD, LCM

## 🧠 Intuition

We need to find the `k`-th smallest positive amount that can be represented as a multiple of at least one of the given coin denominations.

Instead of generating all possible amounts, I can **binary search the answer**.

For a given value `x`, the important question becomes:

> How many valid amounts are less than or equal to `x`?

If there are at least `k` valid amounts, the answer is at most `x`.

Otherwise, the answer must be greater than `x`.

To calculate the number of valid amounts up to `x`, I use the **Inclusion-Exclusion Principle**.

## 🔄 Approach

### 1. Binary Search on the Answer

I maintain a search range:

```text
low = 1
high = minimum(coin × k)
For each mid, I calculate how many valid amounts are <= mid.

If count(mid) >= k, move high to mid.
Otherwise, move low to mid + 1.

When low == high, we have found the answer.

2. Count Valid Amounts

For every subset of the coin denominations, calculate their LCM.

If the LCM is L, then:

x / L

numbers up to x are divisible by every denomination in that subset.

Using Inclusion-Exclusion:

Odd-sized subsets are added.
Even-sized subsets are subtracted.

This avoids counting numbers divisible by multiple denominations more than once.

3. Calculate LCM Using GCD

The LCM is calculated using:

LCM(a, b) = (a / GCD(a, b)) × b

Dividing before multiplying also helps reduce the possibility of overflow.

4. Bitmasking

I use a bitmask to generate every non-empty subset of the coin array.

For example, with three coins:

001 → coin 1
010 → coin 2
100 → coin 3
011 → coin 1 + coin 2
...

This allows all subsets to be processed efficiently.

💻 Solution

See Solution.java.

⏱️ Complexity

Let n be the number of coins.

There are 2^n - 1 non-empty subsets.

For each binary-search iteration, we examine all subsets and up to n coins while constructing their LCM.

Time: O(log(k × min(coins)) × n × 2^n)
Space: O(1) auxiliary space apart from recursion-free variables.
📌 Key Takeaway

The main idea I learned from this problem is:

When it is difficult to directly construct the k-th answer, try converting the problem into a counting problem and use binary search on the answer.

This problem combined several important concepts:

Binary Search on Answer + Inclusion-Exclusion + Bitmasking + GCD/LCM

and showed how multiple techniques can work together to solve a difficult problem efficiently.