# Day 2: Gift Shop (Part One)

Approach & Thought Process

The objective is to scan large numerical ranges of product IDs and flag the invalid ones. An ID is considered invalid if it consists of a sequence of digits repeated exactly twice.

Input Parsing:
- Read the comma-separated ranges (e.g., 9191896883-9191940271) and split them by the hyphen to extract the start and end bounds.
- Parse the boundaries using Long data types since the IDs exceed standard integer limits.

Validation Logic:
- Iterate through the numeric range. 
- Convert the ID to a string and check if the first half of the string exactly matches the second half. 
- If they match and the length is even, it is an invalid ID.

Complexity Analysis

Time Complexity: O(R * W * L)
Where R is the number of ranges, W is the width of the ranges, and L is the string length of the ID. 
Space Complexity: O(L)
Storing the string representation of the current ID being evaluated.

Solution

[View Java Solution](D2q1.java)

---

# Day 2: Gift Shop (Part Two)

Approach & Thought Process

Part Two expands the rule: an ID is invalid if it consists of any sequence repeated at least twice. Processing massive ranges sequentially becomes too slow, requiring an optimized approach.

Pattern Generation:
- Instead of checking every single number within the massive bounds, we can mathematically generate the repeating invalid ID configurations.
- A repeating pattern is essentially a multiplication (e.g., a pattern "12" repeated twice is 12 * 101 = 1212).
- We generate these numbers dynamically and simply verify if they fall within our start and end bounds, heavily reducing the search space.

Complexity Analysis

Time Complexity: O(K)
Where K is the number of dynamically generated repeating IDs. This completely eliminates the linear iteration over the massive bounds.
Space Complexity: O(1)
Only variables for bounds and tracking counts are maintained.

Solution

[View Java Solution](D2q2.java)
