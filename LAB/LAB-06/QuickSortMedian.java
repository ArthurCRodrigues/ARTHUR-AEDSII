public class QuickSortMedian {
    public static void quickSort(int[] array, int start, int end) {
        if (start < end) {
            int pivotIndex = partition(array, start, end);
            quickSort(array, start, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, end);
        }
    }

    private static int partition(int[] array, int start, int end) {
        int mid = start + (end - start) / 2;
        int pivot = medianOfThree(array, start, mid, end);
        swap(array, pivot, end);
        pivot = end;
        int i = start - 1;
        for (int j = start; j < end; j++) {
            if (array[j] <= array[pivot]) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, pivot);
        return i + 1;
    }

    private static int medianOfThree(int[] array, int start, int mid, int end) {
        if (array[start] > array[mid]) {
            swap(array, start, mid);
        }
        if (array[start] > array[end]) {
            swap(array, start, end);
        }
        if (array[mid] > array[end]) {
            swap(array, mid, end);
        }
        return mid;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    public static void main(String[] args) {
        int[] array = {34, 7, 23, 32, 5, 62};
        System.out.println("Unsorted array:");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();

        quickSort(array, 0, array.length - 1);

        System.out.println("Sorted array:");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
