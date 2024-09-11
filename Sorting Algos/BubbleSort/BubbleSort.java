public class BubbleSort {
    public static void sort(int[] arr) {
        int n = arr.length;
        int count = 0; // Initialize count variable
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) { 
                count++; // Increment count for each iteration
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println("Total number of iterations: " + count); // Print the count at the end
    }

    public static void main(String[] args) {
        int[] arr = {6,1,5,3,7,4,2};
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