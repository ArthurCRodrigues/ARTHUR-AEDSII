public class selectionSortOptimized {
    public static void Sort(int[] arr) {
        int n = arr.length;
        int aux = n - 1;

        for (int i = 0; i < aux; i++) {

            int maior = i;
            int menor = i;

            for (int j = i + 1; j <= aux; j++) {
                if (arr[j] > arr[maior]) maior = j;
                if (arr[j] < arr[menor]) menor = j;
            }

            System.out.println("Highest: " + arr[maior]);
            System.out.println("Lowest: " + arr[menor]);

            // Swap the minimum element with the current element
            if (menor != i) {
                int temp = arr[menor];
                arr[menor] = arr[i];
                arr[i] = temp;
            }

            // If maior was swapped, update its index to reflect the change
            if (maior == i) {
                maior = menor;
            }

            // Swap the maximum element with the current last element
            if (maior != aux) {
                int temp = arr[maior];
                arr[maior] = arr[aux];
                arr[aux] = temp;
            }

            aux--;  // Reduce the range from the right end
        }
    }

    public static void main(String[] args) {
        int[] arr = {8, 1, 4, 2, 3, 5, 7, 6};
        for (int item : arr) {
            System.out.print(item + "\t");
        }
        System.out.print("\n");
        Sort(arr);
        System.out.print("\n");
        for (int item : arr) {
            System.out.print(item + "\t");
        }
    }
}
