
public class Fila {
    int array[];
    int n;
    public Fila() {
        this(5);
    }
    public Fila(int tamanho) {
        array = new int[tamanho];
        n = 0;
    }
    public void add(int element) throws Exception{
        if (n >= array.length) {
            throw new Exception("Error! Array index out of bounds");
        }

        for (int i = n ; i > 0 ; i--) {
            array[i] = array[i-1];
        }

        array[0] = element;
        n++;
    }
    public int remove() throws Exception {
        if (n == 0) {
            throw new Exception("Error! Stack is empty");
        }
        return array[--n];
    }
 
}
