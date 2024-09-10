public class InsertionSortOPT {
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            if (key > 0) {
                int j = i - 1;
                while (j >= 0 && (arr[j] > key || arr[j] < 1)) {
                    arr[j + 1] = arr[j];
                    j--;
                }
                arr[j + 1] = key;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {10,-10,5,-5,2,-2};
        
        System.out.println("Unsorted Array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        
        insertionSort(arr);
        
        System.out.println("\nSorted Array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

}