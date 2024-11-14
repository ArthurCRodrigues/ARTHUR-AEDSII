package HybridList;

public class CelulaPilha {
    int elemento;
    CelulaPilha prox;
    CelulaPilha() {
        this(0);
    }
    CelulaPilha(int x) {
        this.elemento = x;
        this.prox = null;
    }
}
