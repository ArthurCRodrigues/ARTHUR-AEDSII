public class selectionSortOptimized {
    public static void Sort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n / 2; i++) {
            int maior, menor, maiorI, menorI;
            maior = menor = arr[i];
            maiorI = menorI = i;

            // Find the largest and smallest elements in the range
            for (int j = i; j < n - i; j++) {
                if (arr[j] > maior) {
                    maior = arr[j];
                    maiorI = j;
                } else if (arr[j] < menor) {
                    menor = arr[j];
                    menorI = j;
                }
            }

            
        }
    }

    public static void main(String[] args) {
        int[] arr = {10,1,5,2,7,3,9,4,8,6};
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
