
public class Pilha {
    int array[];
    int n;

    public Pilha() {
        this(5);
    }
    public Pilha(int tamanho) {
        array = new int[tamanho];
        n = 0;
    }


    public void add(int element) throws Exception {
        if (n >= array.length) {
            throw new Exception("Stack is full!")
        }
        array[n] = element;
        n++;
    }
    public int remove() throws Exception {
        if (n == 0) {
            throw new Exception("Error! Stack is empty");
        }
        return array[--n];
    }
}