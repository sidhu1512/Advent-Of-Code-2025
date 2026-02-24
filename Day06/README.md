# Day 6: Trash Compactor (Part One)

Approach & Thought Process

We are given a math worksheet consisting of numbers arranged in columns separated by spaces, with operators at the bottom. We need to evaluate each column.

Vertical Parsing:
- Extracted the file into a memory structure. 
- The numbers needed to be parsed cleanly vertically, ignoring whitespace anomalies. 
- The columns are processed from top to bottom, accumulating numbers, and applying the final operator (addition or multiplication) found at the base of the column.

Complexity Analysis

Time Complexity: O(R * C)
We visit characters in the grid to build the math expressions per column.
Space Complexity: O(R * C)
Memory is used to store the parsed lines into a matrix structure.

Solution

[View Java Solution](D6q1.java)

---

# Day 6: Trash Compactor (Part Two)

Approach & Thought Process

Part Two reveals the input is actually written right-to-left in columns, where digits of a single number are stacked vertically. Problems are separated by a full column of only spaces.

Right-to-Left Reconstruction:
- We read the grid right-to-left, column by column.
- For each column, digits are concatenated to form numbers. A completely blank column signifies the boundary of an equation block.
- Operators are applied dynamically as we reconstruct the values.

Complexity Analysis

Time Complexity: O(R * C)
Scanning the grid backwards requires a full traversal of the bounds.
Space Complexity: O(C)
Holding the temporary values and digits for the current equation block before reducing them.

Solution

- [View Java Solution](D6q2.java)
- [View Alternative Solution](D6q3.java)
