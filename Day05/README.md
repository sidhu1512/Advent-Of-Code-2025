# Day 5: Cafeteria (Part One)

Approach & Thought Process

We are tasked with verifying fresh ingredients using a list of ingredient ID ranges and a separate list of available ingredient IDs.

Range Checking:
- The input contains fresh ID ranges (e.g., 3-5, 10-14) and individual available IDs.
- For Part One, the goal is to count how many of the available IDs fall into at least one of the fresh ranges.
- We iterate through the available IDs and check each against the parsed start and end bounds of the fresh ranges.

Complexity Analysis

Time Complexity: O(A * R)
Where A is the number of available IDs and R is the number of ranges.
Space Complexity: O(R + A)
Storing the ranges and the available IDs in memory.

Solution

[View Java Solution](D5q1.java)

---

# Day 5: Cafeteria (Part Two)

Approach & Thought Process

Part Two asks for the total count of unique integer IDs covered by the fresh ranges. Because ranges can overlap, we need to find the union of all intervals to avoid double-counting.

Interval Merging:
- First, the ranges are sorted by their starting boundaries.
- We iterate through the sorted list, maintaining a current range. 
- If the next interval overlaps with the current range, we extend the end boundary using Math.max. 
- If it does not overlap, the interval is finalized, we calculate the size of the disjoint interval (end - start + 1), add it to the total, and reset current to the new range.

Complexity Analysis

Time Complexity: O(R log R)
Sorting the intervals dominates the time complexity. The linear sweep to merge overlapping ranges is O(R).
Space Complexity: O(R)
Storing the interval bounds in a list for sorting and merging.

Solution

[View Java Solution](D5q2.java)
