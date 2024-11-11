public class CelulaCTT {
    Contato contato;
    CelulaCTT prox;
    CelulaCTT() {
        this(null);
    }
    CelulaCTT (Contato contato) {
        this.contato = contato;
        this.prox = null;
    }
}
