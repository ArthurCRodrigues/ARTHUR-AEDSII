//Algorithm to only sort the k first numbers.

public class partialSelectionSort {
    public static void selectionSortK(int[] arr, int k ) {
        for (int i = 0 ; i < k; i++) {
            int menor = i;
            for (int j = i + 1 ; j < k; j++) {
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
        int[] arr = {4,3,2,1,8,7,6,5};
        selectionSortK(arr, 4);
        for (int j : arr) {
            System.out.print(j+"\t");
        }
    }
}
