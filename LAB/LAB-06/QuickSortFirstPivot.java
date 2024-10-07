public class QuickSortFirstPivot {

    public static void main(String[] args) {
        int[] array = {34, 7, 23, 32, 5, 62};
        
        System.out.print("Unsorted array: ");
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
        
        quickSort(array, 0, array.length - 1);
        
        System.out.print("Sorted array: ");
        for (int i : array) {
            System.out.print(i + " ");
        }
    }

    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(array, low, high);
            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, high);
        }
    }

    private static int partition(int[] array, int low, int high) {
        int pivot = array[low];
        int left = low + 1;
        int right = high;

        while (left <= right) {
            while (left <= right && array[left] <= pivot) {
                left++;
            }
            while (left <= right && array[right] > pivot) {
                right--;
            }
            if (left < right) {
                swap(array, left, right);
            }
        }
        swap(array, low, right);
        return right;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}