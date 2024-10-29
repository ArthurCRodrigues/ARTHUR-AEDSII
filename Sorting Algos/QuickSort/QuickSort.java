public class QuickSort {

    public static void quicksort(int[] arr, int left, int right) {
        if (left < right) {
            // Get the pivot index
            int pivotIndex = partition(arr, left, right);
            
            // Recursively apply quicksort to the left and right sub-arrays
            quicksort(arr, left, pivotIndex - 1);
            quicksort(arr, pivotIndex + 1, right);
        }
    }

    private static int partition(int[] arr, int left, int right) {
        // Choose the middle element as the pivot
        int middle = left + (right - left) / 2;
        int pivot = arr[middle];

        // Swap the pivot with the right element
        swap(arr, middle, right);

        // Initialize the partitioning index
        int partitionIndex = left;

        for (int i = left; i < right; i++) {
            if (arr[i] <= pivot) {
                swap(arr, i, partitionIndex);
                partitionIndex++;
            }
        }

        // Swap back the pivot to its correct position
        swap(arr, partitionIndex, right);

        return partitionIndex;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {3, 6, 8, 10, 1, 2, 1};
        
        quicksort(arr, 0, arr.length - 1);

        // Print the sorted array
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
