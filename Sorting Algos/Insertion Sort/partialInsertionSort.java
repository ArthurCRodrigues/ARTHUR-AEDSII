public class partialInsertionSort {
    public static void insertionSortK(int[] arr, int k) {
        for (int i = 1 ; i < k; i++) {
            int temp = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > temp) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = temp;
        }
    }
    public static void main(String[] args) {
        int[] arr = {3,2,1,2,1,8,7,6};
        insertionSortK(arr, 3);
        for (int item : arr) {
            System.out.print(item+"\t");
        }
    }
}
