public class Celula {
    public int elemento;
    public Celula prox;

    Celula() {
        this(0);
    }

    Celula(int elemento) {
        this.prox = null;
        this.elemento = elemento;
    }
}
