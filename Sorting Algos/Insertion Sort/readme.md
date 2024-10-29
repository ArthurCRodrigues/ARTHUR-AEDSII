# Insertion Sort

## How it works:
Insertion Sort builds the sorted array one element at a time. It picks the next element from the unsorted array and places it at the correct position in the already sorted part.

## Steps:
 - Start from the **second element**, compare it with the previous elements.
 - Shift the elements of the sorted  portion that are greater than the current element to the right
  - Insert the current element in its correct position
  - Repeat for all elements

## Time Complexity:
 - **Best case:** O(n) (if the array is already sorted)
  - **Worst case:** O(n²)
  - **Average case:** O(n²)

## Stability:
 - **Stable**: It preserves the relative order of equal elements