//Algorithm to only sort the k first numbers.

public class partialSelectionSort {
    public static void selectionSortK(int[] arr, int k ) {
        int n = arr.length;
        for (int i = 0 ; i < k; i++) {
            int menor = i;
            for (int j = i + 1 ; j < n; j++) {
                if (arr[j] < arr[menor]) {
                    menor = j;
                }
            }
            int temp = arr[menor];
            arr[menor] = arr[i];
            arr[i] = temp;
        }
    }
    public static void main(String[] args) {
        int[] arr = {7,6,5,4,3,2,1};
        selectionSortK(arr, 2);
        for (int j : arr) {
            System.out.print(j+"\t");
        }
    }
}
