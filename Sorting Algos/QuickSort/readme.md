# QuickSort Algorithm

QuickSort is a highly efficient sorting algorithm and is based on partitioning of an array of data into smaller arrays. A large array is partitioned into two arrays, one of which holds values smaller than the specified value, say pivot, based on which the partition is made and another array holds values greater than the pivot value.

## Steps and Logic

1. **Choose a Pivot**: Pick an element from the array as the pivot. This can be the first element, the last element, the middle element, or any random element. The choice of pivot can affect the performance of the algorithm.

2. **Partitioning**: Rearrange the elements in the array so that all elements less than the pivot are on the left side, and all elements greater than the pivot are on the right side. The pivot element is now in its final position.

3. **Recursively Apply**: Apply the above steps recursively to the sub-array of elements with smaller values and separately to the sub-array of elements with greater values.

### Example

Consider the array: `[10, 80, 30, 90, 40, 50, 70]`

1. **Choose a Pivot**: Let's choose the last element, `70`, as the pivot.
2. **Partitioning**:
    - Start from the leftmost element and compare each element with the pivot.
    - Swap elements to ensure all elements less than `70` are on the left and all elements greater are on the right.
    - After partitioning, the array looks like: `[10, 30, 40, 50, 70, 90, 80]`
3. **Recursively Apply**:
    - Apply the same process to the sub-arrays `[10, 30, 40, 50]` and `[90, 80]`.

### Pseudocode

```java
public class QuickSort {
     // Function to perform QuickSort
     public static void quickSort(int[] array, int low, int high) {
          if (low < high) {
                // Partition the array
                int pi = partition(array, low, high);

                // Recursively sort elements before and after partition
                quickSort(array, low, pi - 1);
                quickSort(array, pi + 1, high);
          }
     }

     // Function to partition the array
     public static int partition(int[] array, int low, int high) {
          int pivot = array[high];
          int i = (low - 1); // Index of smaller element
          for (int j = low; j < high; j++) {
                // If current element is smaller than or equal to pivot
                if (array[j] <= pivot) {
                     i++;

                     // Swap array[i] and array[j]
                     int temp = array[i];
                     array[i] = array[j];
                     array[j] = temp;
                }
          }

          // Swap array[i + 1] and array[high] (or pivot)
          int temp = array[i + 1];
          array[i + 1] = array[high];
          array[high] = temp;

          return i + 1;
     }
}
```

### Time Complexity

- **Best Case**: O(n log n) - Occurs when the pivot divides the array into two equal halves.
- **Average Case**: O(n log n) - Occurs when the pivot divides the array into two nearly equal halves.
- **Worst Case**: O(n^2) - Occurs when the pivot is the smallest or largest element, resulting in unbalanced partitions.

### Space Complexity

- **O(log n)** - Due to the recursive stack space.

QuickSort is widely used due to its efficiency and simplicity in implementation. It is particularly useful for large datasets.
