# Day 3: Lobby (Part One)

Approach & Thought Process

We need to configure an emergency battery bank to maximize joltage by picking specific digits from each bank of batteries without rearranging them.

Greedy Selection:
- We need to select exactly two digits to form the largest possible 2-digit number while preserving their relative order.
- This is a greedy algorithm problem. We scan the string from left to right to find the maximum available digit for the tens place, ensuring we leave at least one digit remaining for the units place. 
- Once the tens place is selected, we scan the remaining suffix of the string for the maximum digit for the units place.

Complexity Analysis

Time Complexity: O(B * L)
Where B is the number of battery banks (lines) and L is the length of the string.
Space Complexity: O(1)
The string evaluation happens in place with a few tracking variables.

Solution

[View Java Solution](D3q1.java)

---

# Day 3: Lobby (Part Two)

Approach & Thought Process

The requirement scales up drastically: we now need to form optimal 12-digit numbers.

Sliding Window Construction:
- Maintained the greedy selection logic but shifted the construction mechanism to handle 12 digits.
- We maintain a loop that runs 12 times. In each iteration, we search the valid remaining suffix of the string for the highest possible digit.
- The search boundary dynamically shrinks, always leaving enough characters remaining to fulfill the rest of the required digits.
- I utilized a StringBuffer to append the largest digits safely, and then parsed the final result to a Long.

Complexity Analysis

Time Complexity: O(B * L * K)
Where K is the number of digits to select (12). This scales linearly with the input size.
Space Complexity: O(K)
Memory allocated for the StringBuffer to hold the constructed number.

Solution

[View Java Solution](D3q2.java)
