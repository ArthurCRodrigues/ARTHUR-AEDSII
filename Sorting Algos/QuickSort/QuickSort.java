public class QuickSort {
    public static void sort(int[] arr) {
        int end = arr.length -1;
        quicksort(arr,0,end);
    }
    public static void quicksort(int[] arr, int start, int end) {
        int i = start;
        int j = end;
        int pivot = arr[(start+end)/2];
        while (i <= j) {
            while (arr[i]<pivot) i++;
            while(arr[j]>pivot) j--;
            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        if (start < j) quicksort(arr, start, j);
        if (i < end) quicksort(arr, i, end);
    }
    public static void main(String[] args) {
        int[] arr = {1,8,3,2,7,4,5,6};
        System.out.print("Array before sorting: [");
        for (int c : arr) System.out.print(c+" ");
        System.out.print("]\n");
        sort(arr);
        System.out.print("Array after sorting: [");
        for (int c : arr) System.out.print(c+" ");
        System.out.print("]\n");
    }
}
