

public class SelectionSort {
    public static int[] Sort(int arr[]) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i - 1;
            
            System.out.println("\nCurrent element: " + temp);
            System.out.println("Comparing with elements at indices: ");
            
            while ((j >= 0) && (arr[j] > temp)) {
                System.out.println(j + " and " + (j + 1));
                
                arr[j + 1] = arr[j];
                j--;
                
                System.out.println("Array after modification:");
                for (int num : arr) {
                    System.out.print(num + " ");
                }
                System.out.println();
            }
            
            System.out.println("Moving " + temp + " to index " + (j + 1));
            arr[j + 1] = temp;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] unsortedArray = {5, 2, 9, 1, 3};
        
        System.out.println("\nUnsorted Array:");
        for (int num : unsortedArray) {
            System.out.print(num + " ");
        }
        
        int[] sortedArray = Sort(unsortedArray);
        
        System.out.println("\nSorted Array:\n");
        for (int num : sortedArray) {
            System.out.print(num + " ");
        }
    }
}