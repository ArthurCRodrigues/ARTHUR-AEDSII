

public class SelectionSort {
    public static int[] Sort(int arr[]) {
        // Sorting algorithm using Selection Sort
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i]; // Store the current element
            int j = i - 1; // Initialize the index of the previous element
            
            // Compare the current element with elements at indices
            while ((j >= 0) && (arr[j] > temp)) {
                arr[j + 1] = arr[j]; // Shift elements to the right
                j--; // Move to the previous element
            }
            
            arr[j + 1] = temp; // Insert the current element at the correct position
        }
        return arr; // Return the sorted array    
    }
    
    public static void main(String[] args) {
        int[] unsortedArray = {5, 2, 9, 1, 3};
        System.out.println("Unsorted Array:");
        for (int num : unsortedArray) {
            System.out.print(num + " ");
        }
        
        int[] sortedArray = Sort(unsortedArray);
        
        System.out.println("\nSorted Array:");
        for (int num : sortedArray) {
            System.out.print(num + " ");
        }
    }
}