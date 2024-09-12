

public class Lista {

    public int[] array;
    public int n;// Next empty index

    public Lista() {
        this(6);
    }

    public Lista(int tamanho) {
        array = new int[tamanho];
        n = 0;
    }
    // Add an item to the first array slot, thus moving all the previous element to the right so that the new element can be placed.
    public void insertStart(int x) throws Exception{
        if (n >= array.length) {
            throw new Exception("Error! Array index out of bounds");
        }

        for (int i = n ; i > 0 ; i--) {
            array[i] = array[i-1];
        }

        array[0] = x;
        n++;

    }

    public void append(int x) throws Exception {
        if (n >= array.length) {
            throw new Exception("Error! Array index out of bounds");
        }
        array[n] = x;
        n++;
    }

    public void insert(int x , int pos) throws Exception {
        if (n >= array.length  || pos < 0 || pos > n) {
            throw new Exception("Error! Array index out of bounds");
        }
        for (int i = n ; i > pos; i--) {
            array[i] = array[i -1];
        }


        array[pos] = x;
        n++;

    }

    public int removeStart() throws Exception {
        if (n == 0) {
            throw new Exception("Error! Array is empty");
        }
        int resp = array[0];
        n--;
        for (int i = 0 ; i < n ; i++) {
            array[i] = array[i+1];
        }

        return resp;
    }

    public int pop() throws Exception {
        if (n == 0) {
            throw new Exception("Error! Array is empty");
        }
        
        return array[--n];

    }

    public int remove(int pos) throws Exception {
        if (n == 0 || pos < 0 || pos >= n) {
            throw new Exception("Error! Array is empty");
        }
        int resp = array[pos];
        n--;
        
        for (int i = pos; i < n; i++) {
            array[i] = array[i+1];
        }
        return resp;
    }
    public void print() {
        for (int i = 0 ; i < n ; i++) {
            System.out.print(array[i]+" ");
        }
        System.out.print("\n");
    }
    public static void main(String[] args) {
        try {
            Lista lista = new Lista(6);
            
            lista.append(10);
            lista.append(20);
            lista.append(30);
            lista.print(); // Output: 10 20 30
            
            lista.insertStart(5);
            lista.print(); // Output: 5 10 20 30
            
            lista.insert(15, 2);
            lista.print(); // Output: 5 10 15 20 30
            
            int removedItem = lista.removeStart();
            System.out.println("Removed item: " + removedItem); // Output: Removed item: 5
            lista.print(); // Output: 10 15 20 30
            
            int poppedItem = lista.pop();
            System.out.println("Popped item: " + poppedItem); // Output: Popped item: 30
            lista.print(); // Output: 10 15 20
            
            int removedItem2 = lista.remove(1);
            System.out.println("Removed item: " + removedItem2); // Output: Removed item: 15
            lista.print(); // Output: 10 20
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
        }
    }

}
