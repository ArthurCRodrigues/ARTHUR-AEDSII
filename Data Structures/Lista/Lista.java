

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



}
