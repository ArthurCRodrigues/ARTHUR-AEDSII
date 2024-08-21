public class SelectionSort {
    public static void SeleSort(int arr[]) {
        int n = arr.length;
        for (int i = 0 ; i < (n-1); i++ ) {
                int smallest = i;
                for (int j = i+1 ; j < n; j++) {
                    if (arr[smallest] > arr[j]) {
                        smallest = j;
                    }
                }
                int temp = arr[smallest];
                arr[smallest] = arr[i];
                arr[i] = temp;
        }
    }
    public static void main(String[] args) {
        int[] arr = {10,9,3,1,7,4,2,6,5,8};
        System.out.println("Array before sorting: ");
        for (int num : arr) {
            System.out.printf("%d\t",num);
        }
        SeleSort(arr);
        System.out.println("\nArray after sorting: ");
        for (int num : arr) {
            System.out.printf("%d\t",num);
        }
    }
}
