public class bubbleSortOPT {
    public static void swap(int[] arr, int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        
        public static void Sort(int[] arr) {
            int count = 0; // Initialize count variable
            int n = arr.length;
            for (int i = 0; i < n - 1; i++) {
                int troca = n;
                int current_swap = 0;  // Initialize to n before each pass
                for (int j = 0; j < troca - 1; j++) {
                    if (arr[j] > arr[j + 1]) {
                        swap(arr, j, j + 1);
                        current_swap = j + 1;  // Update the position of the last swap
                    }
                    count++; // Increment count for each iteration
                }
                // If no swaps were made in the entire pass, the array is sorted
                if (current_swap == 0) {
                    break;
                } else {
                    troca = current_swap;
                }
            }
            System.out.println("Total number of iterations: " + count); // Print the total number of iterations
        }

    public static void main(String[] args) {
        int[] arr = {6,1,5,3,7,4,2};
        for (int item : arr) {
            System.out.print(item+"\t");
        }
        System.out.print("\n");
        Sort(arr);
        for (int item : arr) {
            System.out.print(item+"\t");
        }
    }
}
