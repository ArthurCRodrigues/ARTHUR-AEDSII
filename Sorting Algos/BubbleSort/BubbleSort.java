public class BubbleSort {
    public static void sort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) { 
                // The - i in the for loop optimizes the algorithm to ignore the sorted elements of the array.
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 8, 12, 1, 6, 3};
        System.out.println("Array before sorting:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();

        sort(arr);

        System.out.println("Array after sorting:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}