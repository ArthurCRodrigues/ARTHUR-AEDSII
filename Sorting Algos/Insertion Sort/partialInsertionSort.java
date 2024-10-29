public class partialInsertionSort {
    public static void partialInsertionSort(int[] arr, int k) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            
            arr[j + 1] = key;
            
            if (i == k) {
                break;
            }
        }
    }
    
    public static void main(String[] args) {
        int[] arr = {5, 2, 7, 3, 4, 1, 6};
        int k = 3;
        
        partialInsertionSort(arr, k);
        
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}