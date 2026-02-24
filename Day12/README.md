# Day 12: Christmas Tree Farm (Part One)

Approach & Thought Process

We need to parse geometric region dimensions and quantities to determine if present shapes fit under the trees.

Parsing and Capacity Checks:
- I processed the input file to separate the dimension strings (width x height) from the sequence arrays. 
- The logic involves splitting the lines to extract the grid boundaries and the required shapes for further area capacity checks.

Complexity Analysis

Time Complexity: O(N)
Where N is the number of lines in the input. Each line is split and parsed strictly once.
Space Complexity: O(L)
Memory allocated for holding the string arrays split from the input lines.

Solution

[View Java Solution](D12q1.java)
