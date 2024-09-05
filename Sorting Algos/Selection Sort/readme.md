Selection Sort
## How it works:
Selection Sort repeatedly selects the smallest (or largest, depending on order) element from the unsorted portion of the array and swaps it with the first unsorted element. 
It divides the array into a sorted and an unsorted part, growing the sorted part one element at a time.

## Steps:
- Start at the first element, and find the smallest element in the array.
- Swap it with the first element.
- Move to the next element and repeat the process for the rest of the array.

## Time Complexity:
- **Best case:** O(n²)
- **Worst case:** O(n²)
- **Average case:** O(n²)

## Stability:
- **Not stable.** It may change the relative order of elements with equal values due to the swapping.

