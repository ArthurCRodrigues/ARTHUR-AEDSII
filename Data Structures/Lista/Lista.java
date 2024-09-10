

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

        for (int i = n ; i < 0 ; i++) {
            array[i] = array[i-1]
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
        if (n >= array.length) {
            throw new Exception("Error! Array index out of bounds");
        }
        for (int i = n ; i > n; i--) {
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
        if (n == 0) {
            throw new Exception("Error! Array is empty");
        }
        int resp = array[pos];
        
        for (int i = n; i > pos; i--) {
            array[i] = array[i-1];
        }
        
    }



}
