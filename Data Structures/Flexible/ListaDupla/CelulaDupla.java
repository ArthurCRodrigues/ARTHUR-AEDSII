public class CelulaDupla {
    public int elemento;
    public CelulaDupla prox,ant;
    CelulaDupla() {
        this(0);
    }
    CelulaDupla(int x) {
        this.elemento = x;
        this.prox = this.ant = null;
    }
}
